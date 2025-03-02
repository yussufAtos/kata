package com.kata.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;


public class TimeNotFoundException extends RuntimeException {
	public TimeNotFoundException(LocalDate date, LocalTime houre) {
		super("Le crenaux " + date + " " + houre + " ,n'est pas trouvé");
	}
}
