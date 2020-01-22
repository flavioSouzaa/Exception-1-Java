package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Etities.Reservation;
import Model.Exceptions.DomeinException;

public class Program {

	public static void main(String[] args)  {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number:");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy):");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy):");
			Date checkout = sdf.parse(sc.next());
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation  " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());
	
			reservation.UpadateDates(checkin, checkout);
			System.out.println("Reservation  " + reservation);
			
		}
		
		catch(ParseException e){
			System.out.println("Invalid date format!dados invalidos");
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid paramiter");
		}
		catch(DomeinException e) {
			System.out.println("Error in reservation:" + e.getMessage());
		}
	}

}
