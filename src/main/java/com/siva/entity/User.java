package com.siva.entity;

import org.springframework.data.mongodb.core.mapping.Document;

//@DynamoDBTable(tableName = "user")
@Document(collection = "user")
public class User {

	// @DynamoDBHashKey
	// @DynamoDBAttribute
	private String firstName;

	// @DynamoDBHashKey
	// @DynamoDBAttribute
	private String lastName;

	// @DynamoDBAttribute
	private String age;

	// @DynamoDBAttribute
	private String email;

	// @DynamoDBAttribute
	// private String gender;

	// public User(String firstName, String lastName, Integer age, String email)
	// {// ,
	// // String
	// // gender)
	// // {
	// super();
	// this.firstName = firstName;
	// this.lastName = lastName;
	// this.age = age;
	// this.email = email;
	// // this.gender = Gender.getGenderEnumFromValue(gender);
	// }

	public User() {
	}

	/*
	 * public User(String firstName, String lastName, String age, String email)
	 * { super(); this.firstName = firstName; this.lastName = lastName; this.age
	 * = age; this.email = email; }
	 */
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	// /**
	// * @return the gender
	// */
	// public Gender getGender() {
	// return gender;
	// }
	//
	// /**
	// * @param gender
	// * the gender to set
	// */
	// public void setGender(Gender gender) {
	// this.gender = gender;
	// }
}
