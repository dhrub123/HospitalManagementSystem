package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.data.SpecialistLookup;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Specialist;

@Component
public class GetSpecialistService {

	@Autowired
	SpecialistLookup specialistLookup;

	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		return specialistLookup.getSpecialistByHospitalNameAndSpecialistType(specialistRequestDto.getHospitalName(),
				specialistRequestDto.getSpecialistType());

	}

}
