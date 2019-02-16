package campsite.model;

import java.time.LocalDate;

public class Reservation {

	private String id;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private ReservationStatus reservationStatus;

	public Reservation(String id, LocalDate checkIn, LocalDate checkOut, ReservationStatus reservationStatus) {
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reservationStatus = reservationStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

}
