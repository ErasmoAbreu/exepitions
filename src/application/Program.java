package application;

import model.entities.Reservation;
import model.exceptitions.DomianExcepition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int roomNumber = sc.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(sc.next());

            reservation.upadateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Invalid date format");
        }
        catch (DomianExcepition e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
