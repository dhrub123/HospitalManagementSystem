package com.hospital.frontdesk.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hospital.frontdesk.exception.ErrorSeverity;
import com.hospital.frontdesk.exception.HospitalCommonException;
import com.hospital.frontdesk.response.BaseResponse;
import com.hospital.frontdesk.response.ErrorDetail;

@ControllerAdvice
public class HospitalFrontDeskControllerAdvice {

	private static final String GENERIC_ERROR_INFORMATION_CODE = "GENERIC_ERROR";
	private static final int INTERNAL_SERVER_ERROR_STATUS_CODE = 500;

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BaseResponse handleGenericException(Exception e, HttpServletResponse response) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setMessage(e.getMessage());
		errorDetail.setHttpCode(INTERNAL_SERVER_ERROR_STATUS_CODE);
		errorDetail.setInformationCode(GENERIC_ERROR_INFORMATION_CODE);
		errorDetail.setSeverity(ErrorSeverity.FAIL.getName());

		return createBaseResponse(response, INTERNAL_SERVER_ERROR_STATUS_CODE, errorDetail);
	}

	@ExceptionHandler(HospitalCommonException.class)
	@ResponseBody
	public BaseResponse handlePaymentsCommonException(Exception e, HttpServletResponse response) {
		ErrorDetail errorDetail = new ErrorDetail();
		int statusCode = INTERNAL_SERVER_ERROR_STATUS_CODE;
		if (e instanceof HospitalCommonException) {
			HospitalCommonException hospitalCommonException = (HospitalCommonException) e;
			errorDetail.setMessage(hospitalCommonException.getMessage());
			errorDetail.setHttpCode(hospitalCommonException.getHttpCode());
			errorDetail.setInformationCode(hospitalCommonException.getInformationCode());
			errorDetail.setSeverity(hospitalCommonException.getSeverity());

			statusCode = hospitalCommonException.getHttpCode();
		}

		return createBaseResponse(response, statusCode, errorDetail);
	}

	private BaseResponse createBaseResponse(HttpServletResponse response, int httpStatus, ErrorDetail errorDetail) {
		BaseResponse baseResponse = new BaseResponse();
		response.setStatus(httpStatus);
		baseResponse.setErrorDetail(errorDetail);
		return baseResponse;
	}
}
