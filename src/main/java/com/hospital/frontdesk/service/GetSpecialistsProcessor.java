package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.Specialist;
import com.hospital.frontdesk.response.SpecialistResponse;
import com.hospital.frontdesk.validator.SpecialistRequestValidator;

@Component
public class GetSpecialistsProcessor {
	
	@Autowired
	private SpecialistRequestValidator specialistRequestValidator;
	
	@Autowired
	private GetSpecialistService getSpecialistService;
	
	public SpecialistResponse getSpecialists(SpecialistRequestDto specialistRequestDto) {
		
		specialistRequestValidator.validateRequestParameters(specialistRequestDto);
		List<Specialist> specs = getSpecialistService.getSpecialists(specialistRequestDto);
		
		//implement caching 
		//implement reponse processing
		SpecialistResponse response = new SpecialistResponse();
		response.setSpecialists(specs);
		return response;
		
	}

}
