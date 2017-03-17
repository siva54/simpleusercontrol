package com.siva.business.spi;

import java.util.List;

import com.siva.entity.User;

public interface UserControlService {
	/**
	 * Method to create a user onto the database.
	 * 
	 * @param user
	 */
	void createUser(User user);

	/**
	 * Method to get a list of users based on firstname and lastname.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	List<User> getUsers(String firstName, String lastName);
}
