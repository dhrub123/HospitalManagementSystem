package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Specialist;
import com.hospital.frontdesk.validator.SpecialistRequestValidator;
import com.hospital.frontdesk.response.SpecialistResponseProcessor;

@Component
public class GetSpecialistsProcessor {

	@Autowired
	private SpecialistRequestValidator specialistRequestValidator;

	@Autowired
	private GetSpecialistService getSpecialistService;

	@Autowired
	private SpecialistResponseProcessor SpecialistResponseProcessor;

	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		specialistRequestValidator.validateRequestParameters(specialistRequestDto);
		List<Specialist> specs = getSpecialistService.getSpecialists(specialistRequestDto);

		// implement reponse processing
		return SpecialistResponseProcessor.buildResponse(specs);
	}

}
