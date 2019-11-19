package com.hospital.frontdesk.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hospital.frontdesk.response.Specialist;

@Component
public class SpecialistLookup {
	
	public List<Specialist> getSpecialistByHospitalNameAndSpecialistType(String hospitalName, String specialistType){
		
		//mock database lookup
		
		int hospitalId = lookupHospitalIdByName(hospitalName);
		
		List<Specialist> finalSpecs = new ArrayList<Specialist>();
		List<Specialist> specialists = createDummyRecords();
		for (Specialist specialist : specialists) {
			if ((specialist.getHospitalId() == hospitalId) && (specialist.getType().equalsIgnoreCase(specialistType))) {
				finalSpecs.add(specialist);
			}
		}
		return finalSpecs;
		
	}
	
	public int lookupHospitalIdByName(String hospitalName) {
		return 946;
	}
	
	public List<Specialist> createDummyRecords() {
		List<Specialist> specs = new ArrayList<Specialist>();
		Specialist spec1 = new Specialist();
		spec1.setType("Dentist");
		spec1.setName("Sandhya");
		spec1.setAvailableday("Monday,Thursday");
		spec1.setAvailableTime("6 to 8");
		spec1.setAvailable(false);
		spec1.setHospitalId(946);
		specs.add(spec1);
		
		Specialist spec2 = new Specialist();
		spec2.setType("ENT");
		spec2.setName("Sushil");
		spec2.setAvailableday("");
		spec2.setAvailableTime("");
		spec2.setAvailable(true);
		spec2.setHospitalId(946);
		specs.add(spec2);
		return specs;
	}
}
