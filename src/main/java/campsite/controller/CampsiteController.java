package campsite.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import campsite.model.Reservation;
import campsite.model.ReservationStatus;
import campsite.service.CampsiteService;

@RestController
public class CampsiteController {

	private static Logger LOGGER = LogManager.getLogger(CampsiteController.class);

	@Autowired
	private CampsiteService campsiteService;

	@RequestMapping(value = "/", produces = "application/json")
	public String getMessage() {
		LOGGER.info("Getting message from static variable ... ");
		return "Campsite API v1.0";
	}

	@RequestMapping("/reservation/{id}")
	public Reservation getReservation(@PathVariable(value = "id") String id) {
		LOGGER.info("Getting campsite Reservations with id {} ... ", id);
		return new Reservation(id, LocalDate.now(), LocalDate.now().plusDays(1), new ReservationStatus("ACTIVE"));
	}

	@RequestMapping(value = "/reservation/availability/{checkIn}/{checkOut}", produces = "application/json")
	public Boolean checkAvailability(@PathVariable(value = "checkIn") String checkIn,
			@PathVariable(value = "checkOut") String checkOut) {
		LOGGER.info("Getting campsite availability with checkIn {} and checkOut {}... ", checkIn, checkOut);
		boolean isAvailable = false;
		try {
			synchronized (this) {
				isAvailable = campsiteService.isAvailable(LocalDate.parse(checkIn), LocalDate.parse(checkOut));
			}
		} catch (DateTimeParseException e) {
			LOGGER.error("Error parsing date.", e);
		}
		return isAvailable;
	}

	public void setCampsiteService(CampsiteService campsiteService) {
		this.campsiteService = campsiteService;
	}

}
