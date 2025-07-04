package model.entities;

import model.exceptitions.DomianExcepition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomianExcepition {
        if(!checkOut.after(checkIn)) {
            throw new DomianExcepition("Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration () {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void upadateDates (Date checkIn, Date checkOut) throws DomianExcepition {

        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)) {
            throw new DomianExcepition("Reservation dates for update must be future dates");
        }
        if(!checkOut.after(checkIn)) {
            throw new DomianExcepition("Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString () {
        return "Room "
                + roomNumber
                + ", check-in "
                + sdf.format(checkIn)
                + ", check-out "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }

}
