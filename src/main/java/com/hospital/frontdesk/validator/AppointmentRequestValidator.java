package com.hospital.frontdesk.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;

@Component
public class AppointmentRequestValidator {

	public void validateRequestParameters(AppointmentRequestDto appointmentRequestDto) {

		if (StringUtils.isEmpty(appointmentRequestDto.getHospitalName())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_HOSPITAL_NAME);
		}

		if (StringUtils.isEmpty(appointmentRequestDto.getSpecialistName())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_SPECIALIST_NAME);
		}

		if (StringUtils.isEmpty(appointmentRequestDto.getPatientName())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_PATIENT_NAME);
		}

		if (StringUtils.isEmpty(appointmentRequestDto.getAppointmentDay())) {
			throw new HospitalCommonException(HospitalErrorCodes.MISSING_APPOINTMENT_DAY);
		}

	}

}
