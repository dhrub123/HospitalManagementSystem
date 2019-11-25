package com.hospital.frontdesk.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.request.dto.AppointmentRequestDto;
import com.hospital.frontdesk.request.dto.SpecialistRequestDto;
import com.hospital.frontdesk.response.BedResponse;
import com.hospital.frontdesk.response.Hospital;
import com.hospital.frontdesk.response.Specialist;
import com.hospital.frontdesk.util.HospitalFrontdeskUtil;

@Component
public class HospitalDataLookup {

	@Autowired
	SpecialistData specialistData;
	
	@Autowired
	HospitalData hospitalData;

	@Value("${hospital.code.fortis}")
	private int hospitalCodeFortis;

	@Value("${hospital.code.apollo}")
	private int hospitalCodeApollo;

	@Value("${hospital.code.default}")
	private int hospitalCodeDefault;

	public List<Specialist> getSpecialistByHospitalNameAndSpecialistType(SpecialistRequestDto specialistRequestDto) {

		String hospitalName = specialistRequestDto.getHospitalName();
		String specialistType = specialistRequestDto.getSpecialistType();

		try {
			int hospitalId = lookupHospitalIdByName(hospitalName);
			return lookupSpecialistByHospitalIdAndSpecialistType(hospitalId, specialistType);
		} catch (HospitalCommonException he) {
			throw he;
		}
	}

	public Specialist getSpecialistByHospitalNameAndSpecialistNameAndAppointmentDay(
			AppointmentRequestDto appointmentRequestDto) {

		String hospitalName = appointmentRequestDto.getHospitalName();
		String specialistName = appointmentRequestDto.getSpecialistName();
		String appointmentDay = appointmentRequestDto.getAppointmentDay();

		try {
			int hospitalId = lookupHospitalIdByName(hospitalName);
			return lookupSpecialistByHospitalIdAndSpecialistNameAndAppointmentDay(hospitalId, specialistName,
					appointmentDay);
		} catch (HospitalCommonException he) {
			throw he;
		}
	}
	
	public BedResponse getNumberOfAvailableBeds(String hospitalName) {
		BedResponse br = new BedResponse();
		try {
			lookupHospitalIdByName(hospitalName);
			br.setNumberOfAvailableBeds(lookupNumberOfAvailableBedsByHospitalName(hospitalName));
		} catch (HospitalCommonException he) {
			throw he;
		}
		return br;
	}

	public int lookupHospitalIdByName(String hospitalName) {
		if (hospitalName.equalsIgnoreCase("fortis")) {
			return hospitalCodeFortis;
		} else if (hospitalName.equalsIgnoreCase("apollo")) {
			return hospitalCodeApollo;
		} else {
			throw new HospitalCommonException(HospitalErrorCodes.INVALID_HOSPITAL_NAME);
		}

	}

	public String lookupNumberOfAvailableBedsByHospitalName(String hospitalName) {
		String numberOfBeds = "0";
		List<Hospital> hospitals = hospitalData.createDummyRecords();
		if(Objects.isNull(hospitals) || hospitals.size() < 1) {
			throw new HospitalCommonException(HospitalErrorCodes.DATA_NOT_AVAILABLE_FOR_HOSPITAL);
		}
		for (Hospital hospital : hospitals) {
			if (hospital.getHospitalName().equalsIgnoreCase(hospitalName)) {
				numberOfBeds = hospital.getNumberOfBedsAvailable();
			}
		}
		return numberOfBeds;
	}
	
	public List<Specialist> lookupSpecialistByHospitalIdAndSpecialistType(int hospitalId, String specialistType) {
		List<Specialist> finalSpecs = new ArrayList<Specialist>();
		List<Specialist> specialists = specialistData.createDummyRecords();
		for (Specialist specialist : specialists) {
			if ((specialist.getHospitalId() == hospitalId) && (specialist.getType().equalsIgnoreCase(specialistType))) {
				finalSpecs.add(specialist);
			}
		}
		return finalSpecs;
	}

	public Specialist lookupSpecialistByHospitalIdAndSpecialistNameAndAppointmentDay(int hospitalId,
			String specialistName, String appointmentDay) {
		Specialist finalSpec = null;
		List<Specialist> specialists = specialistData.createDummyRecords();
		for (Specialist specialist : specialists) {
			String[] availableDays = HospitalFrontdeskUtil.parseAvailableDays(specialist.getAvailableday());
			for (int i = 0; i < availableDays.length; i++) {
				if ((specialist.getHospitalId() == hospitalId)
						&& (specialist.getName().equalsIgnoreCase(specialistName))
						&& (availableDays[i].equalsIgnoreCase(appointmentDay))) {
					finalSpec = specialist;
				}
			}

		}
		return finalSpec;
	}

}
