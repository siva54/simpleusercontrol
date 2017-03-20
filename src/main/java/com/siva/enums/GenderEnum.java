package com.siva.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.siva.exceptions.MyApplicationException;

public enum GenderEnum {
	MALE, FEMALE;

	private static Map<String, GenderEnum> genderMap = new HashMap<>();

	static {
		genderMap.put("m", MALE);
		genderMap.put("f", FEMALE);
	}

	@JsonCreator
	public static GenderEnum forValue(String value) throws MyApplicationException {
		GenderEnum genderEnum = genderMap.get(value);
		return genderEnum;
	}

	@JsonValue
	public String toValue() {
		String result = null;
		for (Entry<String, GenderEnum> entry : genderMap.entrySet()) {
			if (entry.getValue() == this) {
				result = entry.getKey();
				break;
			}
		}
		return result;
	}
}