package com.hospital.frontdesk.request.dto;

public class ApiRequestDto {

	private String hospitalName;
	private String specialistType;
	private String port;
	private String env;

	
	public ApiRequestDto(String hospitalName, String specialistType, String port, String env) {
		this.hospitalName = hospitalName;
		this.specialistType = specialistType;
		this.port = port;
		this.env = env;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
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
