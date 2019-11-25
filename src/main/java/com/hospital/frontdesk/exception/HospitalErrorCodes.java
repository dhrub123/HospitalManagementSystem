package com.hospital.frontdesk.exception;

public enum HospitalErrorCodes {

	MISSING_HOSPITAL_NAME("Hospital name is required", "hospitalName.missing", 400, ErrorSeverity.FAIL),
	
	MISSING_PATIENT_NAME("Patient name is required", "patientName.missing", 400, ErrorSeverity.FAIL),

	MISSING_SPECIALIST_NAME("Specialist name is required", "specialistName.missing", 400, ErrorSeverity.FAIL),
	
	MISSING_APPOINTMENT_DAY("Appointment day is required", "appointmentDay.missing", 400, ErrorSeverity.FAIL),
	
	INVALID_HOSPITAL_NAME("Hospital name is invalid", "hospitalName.invalid", 400, ErrorSeverity.FAIL),

	APPLICATION_ERROR("Hospital application error", "hospital.application.error", 400, ErrorSeverity.FAIL),

	MISSING_SPECIALIST_TYPE("Specialist type is required", "specialistType.missing", 400, ErrorSeverity.FAIL),
	
	NO_SPECIALIST_FOUND("No specialist found for selected hospital", "specialist.not.found", 400, ErrorSeverity.FAIL),
	
	BED_NOT_AVAILABLE("No beds are available in selected hospital", "bed.not.available", 400, ErrorSeverity.FAIL),
	
	DATA_NOT_AVAILABLE_FOR_HOSPITAL("data not available for selected hospital", "data.not.available", 400, ErrorSeverity.FAIL);

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
			if (hospitalErrorCode.getInformationCode().equalsIgnoreCase(informationCode)) {
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
