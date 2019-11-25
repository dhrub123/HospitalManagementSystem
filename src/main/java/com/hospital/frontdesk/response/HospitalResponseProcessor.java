package com.hospital.frontdesk.response;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;

@Component
public class HospitalResponseProcessor {

	public List<Specialist> buildResponse(List<Specialist> specs) {
		if (specs.size() < 1) {
			throw new HospitalCommonException(HospitalErrorCodes.NO_SPECIALIST_FOUND);
		} else {
			return specs;
		}
	}

	public Appointment buildResponseForAppointment(Specialist spec, AppointmentRequestDto appointmentRequestDto) {
		if (Objects.isNull(spec)) {
			throw new HospitalCommonException(HospitalErrorCodes.NO_SPECIALIST_FOUND);
		} else {
			return new Appointment(spec.getName(), appointmentRequestDto.getPatientName(),
					appointmentRequestDto.getAppointmentDay(), spec.getAvailableTime());
		}
	}

	public String buildResponseForBedAvailability(BedResponse bedResponse) {
		if (Integer.parseInt(bedResponse.getNumberOfAvailableBeds()) < 1) {
			throw new HospitalCommonException(HospitalErrorCodes.BED_NOT_AVAILABLE);
		} else {
			return "Number of Beds Available is = " + bedResponse.getNumberOfAvailableBeds();
		}
	}
}
