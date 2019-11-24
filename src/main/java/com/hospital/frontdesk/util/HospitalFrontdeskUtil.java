package com.hospital.frontdesk.util;

public class HospitalFrontdeskUtil {

	private static final String COMMA = ",";

	public static String[] parseAvailableDays(String appointmentDay) {

		String[] availableDays = null;
		if (appointmentDay.contains(COMMA)) {
			availableDays = appointmentDay.trim().split(COMMA);
		} else {
			availableDays = new String[] { appointmentDay };
		}
		return availableDays;
	}

}
