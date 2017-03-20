package com.siva.enums;

public enum UserCollectionEnum {
	ID("_id"),
	FIRSTNAME("firstName"), 
	LASTNAME("lastName"), 
	AGE("age"), 
	EMAIL("email"), 
	GENDER("gender");

	private String columnName;

	private UserCollectionEnum(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
