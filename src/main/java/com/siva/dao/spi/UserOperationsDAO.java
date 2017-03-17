package com.siva.dao.spi;

import java.util.List;

import com.siva.entity.User;

public interface UserOperationsDAO {
	/**
	 * DAO method to create a user.
	 * 
	 * @param user
	 * @throws Exception
	 */
	void createUser(User user) throws Exception;

	/**
	 * DAO method to get all users within the database.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<User> getUsers() throws Exception;

	/**
	 * DAO method to get the user based on firstname and lastname.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws Exception
	 */
	List<User> getUsersBasedOnName(String firstName, String lastName) throws Exception;
}
