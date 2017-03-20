package com.siva.enums;

public enum ExceptionEnum {
	// Database related exceptions
	DATA_ACCESS_LAYER_EXCEPTION("DB-1002", "Repository layer failed to process, reason is {}"),
	
	// Application related generic exception
	APPLICATION_EXCEPTION("SL-1000", "Application failed to process the request, reason is {}"),
	
	// Input data related generic exception
	INPUT_REQUEST_EXCEPTION("CL-1000", "Unable to process data from client request, reason is {}");

	private String errorCode;
	private String errorDescription;

	ExceptionEnum(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}