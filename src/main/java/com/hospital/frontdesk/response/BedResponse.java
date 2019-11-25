package com.hospital.frontdesk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hospitalName", "numberOfAvailableBeds" })
public class BedResponse {

	public BedResponse() {

	}

	public BedResponse(String hospitalName, String numberOfAvailableBeds) {
		this.hospitalName = hospitalName;
		this.numberOfAvailableBeds = numberOfAvailableBeds;
	}

	@JsonProperty("hospitalName")
	private String hospitalName;

	@JsonProperty("numberOfAvailableBeds")
	private String numberOfAvailableBeds;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getNumberOfAvailableBeds() {
		return numberOfAvailableBeds;
	}

	public void setNumberOfAvailableBeds(String numberOfAvailableBeds) {
		this.numberOfAvailableBeds = numberOfAvailableBeds;
	}

}
