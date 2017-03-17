package com.siva.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
	MALE, FEMALE;

	private static Map<String, Gender> genderMap = new HashMap<>();

	static {
		genderMap.put("m", MALE);
		genderMap.put("f", FEMALE);
	}

	@JsonCreator
	public static Gender forValue(String value) {
		return genderMap.get(value);
	}

	@JsonValue
	public String toValue() {
		String result = null;
		for (Entry<String, Gender> entry : genderMap.entrySet()) {
			if (entry.getValue() == this) {
				result = entry.getKey();
				break;
			}
		}
		return result;
	}
}