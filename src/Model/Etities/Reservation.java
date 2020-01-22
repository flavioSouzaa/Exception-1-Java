package Model.Etities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Model.Exceptions.DomeinException;


public class Reservation {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout)  {
		
			if(!checkout.after(checkin)) {
				throw new DomeinException("Check-out date must be after checkin date");
			}
		
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duretion() {
		long diff = checkin.getTime() - checkout.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void UpadateDates(Date checkin, Date checkout)  {

		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
				throw new DomeinException("Reservation dates for update must be future dates");
		}
		if (!checkout.after(checkin)) {
				throw new  DomeinException("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	@Override
	public String toString() {

		return "Room  " + roomNumber + ", CheckIn: " + sdf.format(checkin) + ", CheckOut: " + sdf.format(checkout) + " "
				+ duretion() + " nights ";
	}
}
