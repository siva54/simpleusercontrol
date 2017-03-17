package com.siva.enums;

public enum CollectionsEnum {
	USER("user");

	private String collectionName;

	private CollectionsEnum(String collectionName) {
		this.collectionName = collectionName;
	}

	/**
	 * @return the collectionName
	 */
	public String getCollectionName() {
		return collectionName;
	}

	/**
	 * @param collectionName
	 *            the collectionName to set
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
}
