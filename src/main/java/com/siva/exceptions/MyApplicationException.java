package com.siva.exceptions;

import com.siva.enums.Errors;

public class MyApplicationException extends Exception {
	private static final long serialVersionUID = 5199019587791917711L;
	public String errorCode;
	public String errorDescription;

	public MyApplicationException(Errors error, Object[] params, Throwable throwable) {
		super(throwable);
		this.errorCode = error.getErrorCode();
		this.errorDescription = error.getErrorDescription();
	}
}
