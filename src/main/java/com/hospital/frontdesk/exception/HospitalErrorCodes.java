package com.hospital.frontdesk.exception;

public enum HospitalErrorCodes {
	
	INVALID_HOSPITAL_NAME("Hospital name is required","hospitalName.missing",
			 400,ErrorSeverity.FAIL),
	
	APPLICATION_ERROR("Hospital application error", "hospital.application.error", 
			400,ErrorSeverity.FAIL),
	
	INVALID_SPECIALIST_TYPE("Specialist type is required","specialistType.missing",
			 400,ErrorSeverity.FAIL);
	
	private String message;
	private String informationCode;
	private int httpCode;
	private ErrorSeverity severity;
	private String backendErrorCode;
	
	private HospitalErrorCodes(String message, String informationCode, int httpCode, ErrorSeverity severity) {
		this(message, informationCode, httpCode, severity, null);
	}
	
	private HospitalErrorCodes(String message, String informationCode, int httpCode, ErrorSeverity severity,
			String backendErrorCode) {
		this.message = message;
		this.informationCode = informationCode;
		this.httpCode = httpCode;
		this.severity = severity;
		this.backendErrorCode = backendErrorCode;
	}
	
	public static HospitalErrorCodes getHospitalErrorCodesFromInformationCode(String informationCode) {
		for (HospitalErrorCodes hospitalErrorCode : values()) {
			if(hospitalErrorCode.getInformationCode().equalsIgnoreCase(informationCode)) {
				return hospitalErrorCode;
			}
			
		}
		return APPLICATION_ERROR;
	}
	
	public String getMessage() {
		return message;
	}
	public String getInformationCode() {
		return informationCode;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public ErrorSeverity getSeverity() {
		return severity;
	}
	public String getBackendErrorCode() {
		return backendErrorCode;
	}
	
	
	
	
}
