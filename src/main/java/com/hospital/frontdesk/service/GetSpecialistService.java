package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.frontdesk.data.SpecialistLookup;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Specialist;

@Service
public class GetSpecialistService {

	@Autowired
	SpecialistLookup specialistLookup;

	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		return specialistLookup.getSpecialistByHospitalNameAndSpecialistType(specialistRequestDto);

	}

	public Specialist getSpecialistForAppointment(AppointmentRequestDto appointmentRequestDto) {

		return specialistLookup.getSpecialistByHospitalNameAndSpecialistNameAndAppointmentDay(appointmentRequestDto);

	}

}
