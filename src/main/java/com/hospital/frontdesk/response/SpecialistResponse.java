package com.hospital.frontdesk.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpecialistResponse {

	@JsonProperty("specialists")
	private List<Specialist> specialists;

	public List<Specialist> getSpecialists() {
		return specialists;
	}

	public void setSpecialists(List<Specialist> specialists) {
		this.specialists = specialists;
	}

}
