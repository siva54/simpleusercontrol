package com.siva.business.spi;

import java.util.List;

import com.siva.entity.User;
import com.siva.exceptions.MyApplicationException;

public interface UserManagementService {
	/**
	 * Method to create a user onto the database.
	 * 
	 * @param user
	 * @throws MyApplicationException
	 */
	void createUser(User user) throws MyApplicationException;

	/**
	 * Method to delete a user from the database.
	 * 
	 * @param id
	 * @throws MyApplicationException
	 */
	void deleteUserById(String id) throws MyApplicationException;

	/**
	 * Method to get a list of users based on firstname and lastname.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws MyApplicationException
	 */
	List<User> getUsers(String firstName, String lastName) throws MyApplicationException;

	/**
	 * Method to throw multiple exceptions.
	 * 
	 * @throws MyApplicationException
	 */
	void generateMultipleDummyExceptions() throws MyApplicationException;
}
