package com.hospital.frontdesk.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
	@JsonProperty("error_detail")
	private ErrorDetail errorDetail;

	public ErrorDetail getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(ErrorDetail errorDetail) {
		this.errorDetail = errorDetail;
	}

	/**
	 * Is this error response ?.
	 *
	 * @return true, if successful
	 */
	public boolean hasError() {
		return this.errorDetail != null;
	}
}
