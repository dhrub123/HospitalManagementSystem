package com.hospital.frontdesk.service;

import java.util.List;

import com.hospital.frontdesk.dao.entities.Hospital;
import com.hospital.frontdesk.dao.mapper.HospitalMapper;
import com.hospital.frontdesk.dao.repositories.HospitalRepository;
import com.hospital.frontdesk.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.request.dto.ApiRequestDto;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.validator.ApiRequestValidator;
import com.hospital.frontdesk.validator.AppointmentRequestValidator;
import com.hospital.frontdesk.validator.BedRequestValidator;
import com.hospital.frontdesk.validator.SpecialistRequestValidator;

@Component
public class ServiceProcessor {

	@Autowired
	private SpecialistRequestValidator specialistRequestValidator;

	@Autowired
	private AppointmentRequestValidator appointmentRequestValidator;

	@Autowired
	private BedRequestValidator bedRequestValidator;
	
	@Autowired
	private ApiRequestValidator apiRequestValidator;

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private HospitalResponseProcessor hospitalResponseProcessor;

	@Autowired
	HospitalRepository hospitalRepository;

	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		specialistRequestValidator.validateRequestParameters(specialistRequestDto);
		List<Specialist> specs = hospitalService.getSpecialists(specialistRequestDto);
		return hospitalResponseProcessor.buildResponse(specs);
	}

	public Appointment getAppointment(AppointmentRequestDto appointmentRequestDto) {

		appointmentRequestValidator.validateRequestParameters(appointmentRequestDto);
		Specialist spec = hospitalService.getSpecialistForAppointment(appointmentRequestDto);
		return hospitalResponseProcessor.buildResponseForAppointment(spec, appointmentRequestDto);
	}

	public String getNumberOfAvailableBeds(String hospitalName) {

		bedRequestValidator.validateRequestParameters(hospitalName);
		BedResponse bedResponse = hospitalService.getNumberOfAvailableBeds(hospitalName);
		return hospitalResponseProcessor.buildResponseForBedAvailability(bedResponse);
	}

	public ResponseEntity<String> callRestApi(ApiRequestDto apiRequestDto) {

		apiRequestValidator.validateRequestParameters(apiRequestDto);
		ResponseEntity<String> apiResponse = null;
		try {
			apiResponse = hospitalService.callRestApi(apiRequestDto);
		} catch (RestClientException re) {
			throw new HospitalCommonException(HospitalErrorCodes.HOSPITAL_SERVICE_FAILURE);
		}
		return apiResponse;

	}

	public HospitalResponse getHospitalByHospitalCode(int hospitalCode){
		Hospital hospital = hospitalRepository.findByHospitalCode(hospitalCode);
		return HospitalMapper.toResponse(hospital);
	}

}
