package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Appointment;
import com.hospital.frontdesk.response.Specialist;
import com.hospital.frontdesk.response.SpecialistResponseProcessor;
import com.hospital.frontdesk.validator.AppointmentRequestValidator;
import com.hospital.frontdesk.validator.SpecialistRequestValidator;

@Component
public class GetSpecialistsProcessor {

	@Autowired
	private SpecialistRequestValidator specialistRequestValidator;

	@Autowired
	private AppointmentRequestValidator appointmentRequestValidator;

	@Autowired
	private GetSpecialistService getSpecialistService;

	@Autowired
	private SpecialistResponseProcessor SpecialistResponseProcessor;

	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		specialistRequestValidator.validateRequestParameters(specialistRequestDto);
		List<Specialist> specs = getSpecialistService.getSpecialists(specialistRequestDto);
		return SpecialistResponseProcessor.buildResponse(specs);
	}

	public Appointment getAppointment(AppointmentRequestDto appointmentRequestDto) {

		appointmentRequestValidator.validateRequestParameters(appointmentRequestDto);
		Specialist spec = getSpecialistService.getSpecialistForAppointment(appointmentRequestDto);
		return SpecialistResponseProcessor.buildResponseForAppointment(spec,appointmentRequestDto);
	}

}
