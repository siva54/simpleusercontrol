package com.siva.exceptions;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.siva.enums.ExceptionCategoryEnum;
import com.siva.enums.ExceptionEnum;

public class MyApplicationException extends Exception {
	private static final String ERROR_PARAMETER_VARIABLE = "{}";
	private static final long serialVersionUID = 5199019587791917711L;

	private ExceptionCategoryEnum exceptionCategory;
	private String errorCode;
	private String errorDescription;

	public MyApplicationException() {
		super();
	}

	public MyApplicationException(ExceptionCategoryEnum exceptionCategory, ExceptionEnum error, String[] params) {
		setupExceptionData(exceptionCategory, error, params);
	}

	public MyApplicationException(ExceptionCategoryEnum exceptionCategory, ExceptionEnum error, String[] params,
			Throwable throwable) {
		super(throwable);
		setupExceptionData(exceptionCategory, error, params);
	}

	/**
	 * Method to setup data from a given input.
	 * 
	 * @param exceptionCategory
	 * @param error
	 * @param params
	 */
	private void setupExceptionData(ExceptionCategoryEnum exceptionCategory, ExceptionEnum error, String[] params) {
		this.exceptionCategory = exceptionCategory;
		this.errorCode = error.getErrorCode();
		this.errorDescription = getErrorDescriptionFromGivenData(error.getErrorDescription(), params);
	}

	/**
	 * @return the exceptionCategory
	 */
	public ExceptionCategoryEnum getExceptionCategory() {
		return exceptionCategory;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/**
	 * Method that fills the variables in a template error description with
	 * given set of parameters.
	 * 
	 * @return
	 */
	private String getErrorDescriptionFromGivenData(String errorDescription, String[] errorParameters) {
		String finalizedErrorDesc = errorDescription;

		if (ArrayUtils.isNotEmpty(errorParameters)) {
			for (String errorParameter : errorParameters) {
				finalizedErrorDesc = StringUtils.replaceOnce(finalizedErrorDesc, ERROR_PARAMETER_VARIABLE,
						errorParameter);
			}
		}

		return finalizedErrorDesc;
	}
}