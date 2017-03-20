package com.siva.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ErrorResponse {

	private List<ErrorData> errorResponses;

	/**
	 * @return the errorDataList
	 */
	public List<ErrorData> getErrorResponses() {
		if (CollectionUtils.isEmpty(errorResponses)) {
			errorResponses = new ArrayList<>();
		}
		return errorResponses;
	}

	/**
	 * Method to create and fill and error data object.
	 * 
	 * @param errorCode
	 * @param errorDesc
	 * @param instructions
	 */
	public void createAndFillErrorData(String errorCode, String errorDesc, String instructions) {
		getErrorResponses().add(new ErrorData(errorCode, errorDesc, instructions));
	}

	class ErrorData {
		private String errorCode;
		private String errorDesc;
		private String instructions;

		public ErrorData(String errorCode, String errorDesc, String instructions) {
			super();
			this.errorCode = errorCode;
			this.errorDesc = errorDesc;
			this.instructions = instructions;
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
		 * @return the errorDesc
		 */
		public String getErrorDesc() {
			return errorDesc;
		}

		/**
		 * @param errorDesc
		 *            the errorDesc to set
		 */
		public void setErrorDesc(String errorDesc) {
			this.errorDesc = errorDesc;
		}

		/**
		 * @return the instructions
		 */
		public String getInstructions() {
			return instructions;
		}

		/**
		 * @param instructions
		 *            the instructions to set
		 */
		public void setInstructions(String instructions) {
			this.instructions = instructions;
		}
	}
}