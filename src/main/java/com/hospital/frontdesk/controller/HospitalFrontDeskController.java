package com.hospital.frontdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Appointment;
import com.hospital.frontdesk.response.Specialist;
import com.hospital.frontdesk.service.GetSpecialistsProcessor;


@RestController
@RequestMapping("${base.uri}")
public class HospitalFrontDeskController {
	
	@Autowired
	private GetSpecialistsProcessor getSpecialistsProcessor;
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "${retrieve.specialist.uri}", 
			produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE}
	)
	public List<Specialist> retrieveSpecialistDetails(
			@RequestParam(value = "specialist_type", required = true) String specialistType,
			@RequestParam(value = "hospital_name", required = true) String hospitalName) {
		
			return getSpecialistsProcessor.getSpecialists(new SpecialistRequestDto(hospitalName, specialistType));
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "${appointment.uri}", 
			produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE}
	)
	public Appointment retrieveAppointmentDetails(
			@RequestParam(value = "specialist_name", required = true) String specialistName,
			@RequestParam(value = "hospital_name", required = true) String hospitalName,
			@RequestParam(value = "patient_name", required = true) String patientName,
			@RequestParam(value = "appointment_day", required = true) String appointmentDay) {
		
			return getSpecialistsProcessor.getAppointment(new AppointmentRequestDto(hospitalName, specialistName, patientName, appointmentDay));
	}
}
