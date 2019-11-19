package com.hospital.frontdesk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail {

	/**
	 * Error message
	 */
	private String message;
	
	/**
	 * Information code - this is something that we can also use in metrilyx/zabbix dashboards 
	 */
	@JsonProperty("information_code")
	private String informationCode;
	
	/**
	 * Http Response Status Code
	 */
	@JsonProperty("http_code")
	private int httpCode; 
	
	/**
	 * Severity of the error (WARNING
	 */
	private String severity;

	public ErrorDetail() {
		super();
	}

	public ErrorDetail(String message, String informationCode, int httpCode, String severity) {
		super();
		this.message = message;
		this.informationCode = informationCode;
		this.httpCode = httpCode;
		this.severity = severity;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInformationCode() {
		return informationCode;
	}

	public void setInformationCode(String informationCode) {
		this.informationCode = informationCode;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	@Override
	public String toString() {
		return "ErrorDetail [message=" + message + ", informationCode=" + informationCode + ", httpCode=" + httpCode
				+ ", severity=" + severity + "]";
	}
	

}
