package com.hospital.frontdesk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hospitalName", "numberOfTotalBeds", "numberOfPatientsAdmitted", "numberOfPatientsDischarged" })
public class Hospital {

	public Hospital() {

	}

	public Hospital(String hospitalName, String numberOfTotalBeds, String numberOfPatientsAdmitted,
			String numberOfPatientsDischarged) {
		this.hospitalName = hospitalName;
		this.numberOfTotalBeds = numberOfTotalBeds;
		this.numberOfPatientsAdmitted = numberOfPatientsAdmitted;
		this.numberOfPatientsDischarged = numberOfPatientsDischarged;
	}

	@JsonProperty("hospitalName")
	private String hospitalName;

	@JsonProperty("numberOfTotalBeds")
	private String numberOfTotalBeds;

	@JsonProperty("numberOfPatientsAdmitted")
	private String numberOfPatientsAdmitted;

	@JsonProperty("numberOfPatientsDischarged")
	private String numberOfPatientsDischarged;
	
	private String numberOfBedsAvailable;
	
	public String getNumberOfBedsAvailable() {
		int totalBeds = Integer.parseInt(this.numberOfTotalBeds);
		int admitted = Integer.parseInt(this.numberOfPatientsAdmitted);
		int discharged = Integer.parseInt(this.numberOfPatientsDischarged);
		return (totalBeds - (admitted - discharged)) + "";
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getNumberOfTotalBeds() {
		return numberOfTotalBeds;
	}

	public void setNumberOfTotalBeds(String numberOfTotalBeds) {
		this.numberOfTotalBeds = numberOfTotalBeds;
	}

	public String getNumberOfPatientsAdmitted() {
		return numberOfPatientsAdmitted;
	}

	public void setNumberOfPatientsAdmitted(String numberOfPatientsAdmitted) {
		this.numberOfPatientsAdmitted = numberOfPatientsAdmitted;
	}

	public String getNumberOfPatientsDischarged() {
		return numberOfPatientsDischarged;
	}

	public void setNumberOfPatientsDischarged(String numberOfPatientsDischarged) {
		this.numberOfPatientsDischarged = numberOfPatientsDischarged;
	}

}
