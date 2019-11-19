package com.hospital.frontdesk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "type", "name", "availableday", "availableTime", "isAvailable", "hospitalId" })
public class Specialist {
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("availableday")
	private String availableday;
	
	@JsonProperty("availableTime")
	private String availableTime;
	
	@JsonProperty("isAvailable")
	private boolean isAvailable;
	
	@JsonProperty("hospitalId")
	private int hospitalId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailableday() {
		return availableday;
	}

	public void setAvailableday(String availableday) {
		this.availableday = availableday;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getHospitalId() {
		return hospitalId;
	}
	
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	
	
}
