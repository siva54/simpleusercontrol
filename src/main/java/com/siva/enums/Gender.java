package com.siva.enums;

import org.apache.commons.lang3.StringUtils;

public enum Gender {
	MALE("M"), FEMALE("F");

	private String genderCategory;

	Gender(String genderCategory) {
		this.genderCategory = genderCategory;
	}

	/**
	 * @return the genderCategory
	 */
	public String getGenderCategory() {
		return genderCategory;
	}

	/**
	 * @param genderCategory
	 *            the genderCategory to set
	 */
	public void setGenderCategory(String genderCategory) {
		this.genderCategory = genderCategory;
	}

	public static Gender getGenderEnumFromValue(String genderCategory) {
		Gender result = null;

		for (Gender gender : Gender.values()) {
			if (StringUtils.equals(genderCategory, gender.getGenderCategory())) {
				result = gender;
			}
		}
		return result;
	}
}
