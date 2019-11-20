package com.hospital.frontdesk.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;

@Component
public class SpecialistResponseProcessor {
	
	public List<Specialist> buildResponse(List<Specialist> specs) {
		if(specs.size() < 1) {
			throw new HospitalCommonException(HospitalErrorCodes.NO_SPECIALIST_FOUND);
		}else {
			return specs;
		}
		
	}
}
