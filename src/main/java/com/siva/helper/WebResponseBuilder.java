package com.siva.helper;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.siva.entity.ErrorResponse;
import com.siva.enums.ExceptionCategoryEnum;
import com.siva.enums.ExceptionEnum;
import com.siva.exceptions.MyApplicationException;

public class WebResponseBuilder {
	private WebResponseBuilder() {
	}

	public static ResponseEntity<String> successResponseBuilder() {
		return null;
	}

	/**
	 * Method to build error response.
	 * 
	 * @param <T>
	 * 
	 * @param exceptionList
	 * @return
	 */
	public static <T> ResponseEntity<Object> errorResponseBuilder(List<T> exceptionList) {
		ErrorResponse errorResponse = new ErrorResponse();
		HttpStatus httpStatus = null;

		for (T exception : exceptionList) {
			if (exception instanceof MyApplicationException) {
				MyApplicationException myApplicationException = (MyApplicationException) exception;
				errorResponse.createAndFillErrorData(myApplicationException.getErrorCode(),
						myApplicationException.getErrorDescription(), StringUtils.EMPTY);
				httpStatus = getHTTPStatus(httpStatus, myApplicationException.getExceptionCategory());
			} else if (exception instanceof Exception) {
				Exception myApplicationException = (Exception) exception;
				errorResponse.createAndFillErrorData(ExceptionEnum.APPLICATION_EXCEPTION.getErrorCode(),
						myApplicationException.getMessage(), StringUtils.EMPTY);
				httpStatus = getHTTPStatus(httpStatus, ExceptionCategoryEnum.APPLICATION_ERROR);
			}
		}

		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(errorResponse, httpStatus);
		return responseEntity;
	}

	/**
	 * Method that will map the exception category to httpstatus.
	 * 
	 * @param currentHttpStatus
	 * @param exceptionCategoryEnum
	 * @return
	 */
	private static HttpStatus getHTTPStatus(HttpStatus currentHttpStatus, ExceptionCategoryEnum exceptionCategoryEnum) {
		HttpStatus newHttpStatus = null;

		switch (exceptionCategoryEnum) {
		case DATABASE_ERROR:
			newHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			break;
		case APPLICATION_ERROR:
			newHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			break;
		case INPUT_DATA_ERROR:
			newHttpStatus = HttpStatus.BAD_REQUEST;
			break;
		default:
			newHttpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return currentHttpStatus != null && (currentHttpStatus.value() > newHttpStatus.value()) ? currentHttpStatus
				: newHttpStatus;
	}
}