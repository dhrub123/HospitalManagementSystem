package com.hospital.frontdesk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "specialistName", "patientName", "appointmentDay", "appointmentTime" })
public class Appointment {

	public Appointment() {

	}

	public Appointment(String specialistName, String patientName, String appointmentDay, String appointmentTime) {
		this.specialistName = specialistName;
		this.patientName = patientName;
		this.appointmentDay = appointmentDay;
		this.appointmentTime = appointmentTime;
	}

	@JsonProperty("specialistName")
	private String specialistName;

	@JsonProperty("patientName")
	private String patientName;

	@JsonProperty("appointmentDay")
	private String appointmentDay;

	@JsonProperty("appointmentTime")
	private String appointmentTime;

	public String getSpecialistName() {
		return specialistName;
	}

	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAppointmentDay() {
		return appointmentDay;
	}

	public void setAppointmentDay(String appointmentDay) {
		this.appointmentDay = appointmentDay;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

}
