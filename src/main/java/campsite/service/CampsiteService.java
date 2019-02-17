package campsite.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class CampsiteService {

	public Boolean isAvailable(LocalDate checkIn, LocalDate checkOut) {
		return true;
	}

}
