package com.siva.repository.spi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.siva.entity.User;
import com.siva.exceptions.MyApplicationException;

public interface UserManagementRepository extends MongoRepository<User, String> {

	/**
	 * Method to create/update existing user.
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void createUser(User user) throws Exception;

	/**
	 * Method to delete a user from the database.
	 * 
	 * @param id
	 * @throws MyApplicationException
	 * @throws Exception
	 */
	void deleteUserById(String id) throws MyApplicationException, Exception;

	/**
	 * Method to find an existing user using his/her firstname and lastname.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 * @throws Exception
	 */
	public List<User> findCustomerByName(String firstName, String lastName) throws Exception;
}
