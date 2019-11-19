package com.hospital.frontdesk.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;

@Component
public class SpecialistRequestValidator {

	public void validateRequestParameters(SpecialistRequestDto specialistRequestDto) {

		if (StringUtils.isEmpty(specialistRequestDto.getHospitalName())) {
			throw new HospitalCommonException(HospitalErrorCodes.INVALID_HOSPITAL_NAME);
		}

		if (StringUtils.isEmpty(specialistRequestDto.getSpecialistType())) {
			throw new HospitalCommonException(HospitalErrorCodes.INVALID_SPECIALIST_TYPE);
		}

	}

}
