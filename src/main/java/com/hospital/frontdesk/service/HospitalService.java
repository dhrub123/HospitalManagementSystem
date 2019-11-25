package com.hospital.frontdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hospital.frontdesk.data.HospitalDataLookup;
import com.hospital.frontdesk.request.dto.ApiRequestDto;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.BedResponse;
import com.hospital.frontdesk.response.Specialist;

@Service
public class HospitalService {

	@Autowired
	private HospitalDataLookup hospitalDataLookup;
	
	@Autowired
	private RestTemplate hospitalServiceRestTemplate;
	
	@Value("${base.uri}")
	private String baseUri;
	
	@Value("${retrieve.specialist.uri}")
	private String retrieveSpecialistUri;
	
	public List<Specialist> getSpecialists(SpecialistRequestDto specialistRequestDto) {

		return hospitalDataLookup.getSpecialistByHospitalNameAndSpecialistType(specialistRequestDto);
	}

	public Specialist getSpecialistForAppointment(AppointmentRequestDto appointmentRequestDto) {

		return hospitalDataLookup.getSpecialistByHospitalNameAndSpecialistNameAndAppointmentDay(appointmentRequestDto);
	}

	public BedResponse getNumberOfAvailableBeds(String hospitalName) {

		return hospitalDataLookup.getNumberOfAvailableBeds(hospitalName);
	}
	
	public ResponseEntity<String> callRestApi(ApiRequestDto apiRequestDto) {

		String url = buildUrl(apiRequestDto);
		return hospitalServiceRestTemplate.getForEntity(url, String.class);
	}
	
	public String buildUrl(ApiRequestDto apiRequestDto) {
		String url = "http://" 
						+ apiRequestDto.getEnv() 
						+ ":" 
						+ apiRequestDto.getPort() 
						+ "/" 
						+ baseUri
						+ retrieveSpecialistUri 
						+ "?specialist_type=" 
						+ apiRequestDto.getSpecialistType() 
						+ "&hospital_name="
						+ apiRequestDto.getHospitalName();
		return url;
	}

}
