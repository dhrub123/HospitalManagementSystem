package com.hospital.frontdesk.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.request.dto.ApiRequestDto;

@Component
public class ApiRequestValidator {

	public void validateRequestParameters(ApiRequestDto apiRequestDto) {

		if (StringUtils.isEmpty(apiRequestDto.getHospitalName())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_HOSPITAL_NAME);
		}

		if (StringUtils.isEmpty(apiRequestDto.getSpecialistType())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_SPECIALIST_TYPE);
		}

		if (StringUtils.isEmpty(apiRequestDto.getPort())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_PORT);
		}

		if (StringUtils.isEmpty(apiRequestDto.getEnv())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_ENV);
		}

	}

}
