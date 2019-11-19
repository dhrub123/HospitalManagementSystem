package com.hospital.frontdesk.exception;

public enum ErrorSeverity {
	INFO("INFO"),
	WARN("WARN"),
	FAIL("ERROR");
	
	private String name;

	private ErrorSeverity(String severity) {
		this.name = severity;
	}

	public String getName() {
		return name;
	}
}
