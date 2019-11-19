package com.hospital.frontdesk.request.dto;

public class SpecialistRequestDto {

	private String hospitalName;
	private String specialistType;

	public SpecialistRequestDto(String hospitalName, String specialistType) {
		super();
		this.hospitalName = hospitalName;
		this.specialistType = specialistType;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getSpecialistType() {
		return specialistType;
	}

	public void setSpecialistType(String specialistType) {
		this.specialistType = specialistType;
	}

}
