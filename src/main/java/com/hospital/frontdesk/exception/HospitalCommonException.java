package com.hospital.frontdesk.exception;

public class HospitalCommonException extends RuntimeException{
	

	
	private static final long serialVersionUID = 7073358279585644915L;
	private String message;
	private String informationCode;
	private int httpCode;
	private String severity;
	private String backendErrorCode;
	
	public HospitalCommonException(HospitalErrorCodes errorCodeEnum) {
		this(errorCodeEnum, null);
	}
	
	public HospitalCommonException(HospitalErrorCodes errorCodeEnum, Throwable nested) {
		this(errorCodeEnum.getMessage(), 
				errorCodeEnum.getInformationCode(), 
				errorCodeEnum.getHttpCode(), 
				errorCodeEnum.getSeverity().getName(), 
				errorCodeEnum.getBackendErrorCode(), 
				nested);
	}
	
//	public HospitalCommonException(HospitalErrorCodes errorCodeEnum, String value, Throwable nested) {
//		this(errorCodeEnum.getMessage().concat(value), 
//				errorCodeEnum.getInformationCode(), 
//				errorCodeEnum.getHttpCode(), 
//				errorCodeEnum.getSeverity().getName(), 
//				errorCodeEnum.getBackendErrorCode(), 
//				nested);
//	}
	
	public HospitalCommonException(String message, String informationCode,
			int httpCode, String severity, String backendErrorCode,
			Throwable nested) {
		this.message = message;
		this.informationCode = informationCode;
		this.severity = severity;
		this.backendErrorCode = backendErrorCode;
		this.httpCode = httpCode;
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
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getBackendErrorCode() {
		return backendErrorCode;
	}
	public void setBackendErrorCode(String backendErrorCode) {
		this.backendErrorCode = backendErrorCode;
	}


}
