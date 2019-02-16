package campsite.controller;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import campsite.model.Reservation;
import campsite.model.ReservationStatus;

@RestController
public class CampsiteController {

	private static Logger LOGGER = LogManager.getLogger(CampsiteController.class);
	private static String msg = "This message is generated from Spring boot application! Great!";

	@RequestMapping("/")
	public String getMessage() {
		LOGGER.info("Getting message from static variable ... ");
		return msg;
	}

	@RequestMapping("/reservation/{id}")
	public Reservation getReservation(@PathVariable(value = "id") String id) {
		LOGGER.info("Getting campsite Reservations with id {} ... ", id);
		return new Reservation(id, LocalDate.now(), LocalDate.now().plusDays(1), new ReservationStatus("ACTIVE"));
	}
}
