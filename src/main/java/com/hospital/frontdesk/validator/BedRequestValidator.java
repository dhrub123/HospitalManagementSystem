package com.hospital.frontdesk.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;

@Component
public class BedRequestValidator {

	public void validateRequestParameters(String hospitalName) {

		if (StringUtils.isEmpty(hospitalName)) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_HOSPITAL_NAME);
		}

	}

}
