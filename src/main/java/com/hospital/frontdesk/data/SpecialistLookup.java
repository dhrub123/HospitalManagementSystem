package com.hospital.frontdesk.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.exception.HospitalErrorCodes;
import com.hospital.frontdesk.properties.SpecialistsProperties;

import com.hospital.frontdesk.response.Specialist;

@Component
public class SpecialistLookup {

	@Autowired
	SpecialistsProperties specialistsProperties;

	@Value("${hospital.code.fortis}")
    private int hospitalCodeFortis;
	
	@Value("${hospital.code.apollo}")
    private int hospitalCodeApollo;
	
	@Value("${hospital.code.default}")
    private int hospitalCodeDefault;
	
	@Cacheable("specialists")
	public List<Specialist> getSpecialistByHospitalNameAndSpecialistType(String hospitalName, String specialistType) {
		try {
			int hospitalId = lookupHospitalIdByName(hospitalName);
			return lookupSpecialistByHospitalIdAndSpecialistType(hospitalId, specialistType);
		}catch(HospitalCommonException he) {
			throw he;
		}
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

	public List<Specialist> lookupSpecialistByHospitalIdAndSpecialistType(int hospitalId, String specialistType) {
		List<Specialist> finalSpecs = new ArrayList<Specialist>();
		List<Specialist> specialists = createDummyRecords();
		for (Specialist specialist : specialists) {
			if ((specialist.getHospitalId() == hospitalId) && (specialist.getType().equalsIgnoreCase(specialistType))) {
				finalSpecs.add(specialist);
			}
		}
		return finalSpecs;
	}

	public List<Specialist> createDummyRecords() {
		System.out.println("Create dummy records");
		return specialistsProperties.getList();

	}
}
