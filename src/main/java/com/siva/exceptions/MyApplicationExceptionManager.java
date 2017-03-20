package com.siva.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.siva.enums.ExceptionTolerance;

public class MyApplicationExceptionManager extends MyApplicationException {

	private static final long serialVersionUID = 5972654858970932241L;

	private Map<ExceptionTolerance, List<MyApplicationException>> exceptionMap;

	/**
	 * @return the exceptionList
	 */
	public Map<ExceptionTolerance, List<MyApplicationException>> getExceptionMap() {
		if (exceptionMap == null) {
			exceptionMap = new HashMap<>();
			exceptionMap.put(ExceptionTolerance.ACCEPTABLE, new ArrayList<>());
			exceptionMap.put(ExceptionTolerance.UNACCEPTABLE, new ArrayList<>());
		}
		return exceptionMap;
	}

	/**
	 * Method to retrieve all unacceptable exceptions.
	 * 
	 * @return
	 */
	public List<MyApplicationException> retrieveUnacceptableExceptions() {
		return getExceptionMap().get(ExceptionTolerance.UNACCEPTABLE);
	}

	/**
	 * Method to add an unacceptable exception.
	 * 
	 * @param myApplicationException
	 * @return
	 */
	public MyApplicationExceptionManager addToUnacceptableException(MyApplicationException myApplicationException) {
		getExceptionMap().get(ExceptionTolerance.UNACCEPTABLE).add(myApplicationException);
		return this;
	}

	/**
	 * Method to add an acceptable exception.
	 * 
	 * @param myApplicationException
	 * @return
	 */
	public MyApplicationExceptionManager addToAcceptableException(MyApplicationException myApplicationException) {
		getExceptionMap().get(ExceptionTolerance.ACCEPTABLE).add(myApplicationException);
		return this;
	}
}