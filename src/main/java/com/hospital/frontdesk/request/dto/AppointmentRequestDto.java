package com.hospital.frontdesk.request.dto;

public class AppointmentRequestDto {

	private String hospitalName;
	private String specialistName;
	private String patientName;
	private String appointmentDay;

	public AppointmentRequestDto(String hospitalName, String specialistName, String patientName,
			String appointmentDay) {
		this.hospitalName = hospitalName;
		this.specialistName = specialistName;
		this.patientName = patientName;
		this.appointmentDay = appointmentDay;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

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

}
