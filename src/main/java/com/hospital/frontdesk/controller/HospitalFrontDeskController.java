package com.hospital.frontdesk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hospital.frontdesk.response.ProviderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hospital.frontdesk.request.dto.ApiRequestDto;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Appointment;
import com.hospital.frontdesk.response.Specialist;
import com.hospital.frontdesk.service.ServiceProcessor;


@RestController
@RequestMapping("${base.uri}")
public class HospitalFrontDeskController {
	
	@Autowired
	private ServiceProcessor serviceProcessor;
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "${retrieve.specialist.uri}", 
			produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE}
	)
	public List<Specialist> retrieveSpecialistDetails(
			@RequestParam(value = "specialist_type", required = true) String specialistType,
			@RequestParam(value = "hospital_name", required = true) String hospitalName) {
		
			return serviceProcessor.getSpecialists(new SpecialistRequestDto(hospitalName, specialistType));
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
		
			return serviceProcessor.getAppointment(new AppointmentRequestDto(hospitalName, specialistName, patientName, appointmentDay));
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "${bed.details.uri}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String retrieveNumberOfAvailableBeds(
			@RequestParam(value = "hospital_name", required = true) String hospitalName) {

			return serviceProcessor.getNumberOfAvailableBeds(hospitalName);
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "${call.api.uri}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> callApi(
			@RequestParam(value = "port", required = true) String port,
			@RequestParam(value = "env", required = true) String env,
			@RequestParam(value = "hospital_name", required = true) String hospitalName,
			@RequestParam(value = "specialist_type", required = true) String specialistType) {
			
			return serviceProcessor.callRestApi(new ApiRequestDto(hospitalName, specialistType, port, env));
			
	}

	@GetMapping(
			value = "/providers",
			produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public ProviderResponse getProviderDetails(){
		System.out.println("Inside Get Providers");
		Map<String,String> providerMap = new HashMap<String,String>();
		providerMap.put("Carol Bling", "ORTHOPAEDICS");
		providerMap.put("John Doe", "CARDIOLOGY");
		providerMap.put("Kutum Singh", "PAEDIATRICS");
		providerMap.put("Bhutum Singh", "ENT");
		return new ProviderResponse(providerMap);
	}
}
