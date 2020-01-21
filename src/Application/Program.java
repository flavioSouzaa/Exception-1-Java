package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Etities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Room number:");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy):");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation  " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());

			String Error = reservation.UpadateDates(checkin, checkout);
			if (Error != null) {
				System.out.println("Error in reservetion: " + Error);
			} 
			else {
				System.out.println("Reservation  " + reservation);
			}
		}

	}

}