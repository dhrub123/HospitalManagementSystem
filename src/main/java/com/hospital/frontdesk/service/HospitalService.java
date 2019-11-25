package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.frontdesk.data.HospitalDataLookup;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.BedResponse;
import com.hospital.frontdesk.response.Specialist;

@Service
public class HospitalService {

	@Autowired
	HospitalDataLookup hospitalDataLookup;

	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		return hospitalDataLookup.getSpecialistByHospitalNameAndSpecialistType(specialistRequestDto);
	}

	public Specialist getSpecialistForAppointment(AppointmentRequestDto appointmentRequestDto) {

		return hospitalDataLookup.getSpecialistByHospitalNameAndSpecialistNameAndAppointmentDay(appointmentRequestDto);
	}

	public BedResponse getNumberOfAvailableBeds(String hospitalName) {

		return hospitalDataLookup.getNumberOfAvailableBeds(hospitalName);
	}

}
