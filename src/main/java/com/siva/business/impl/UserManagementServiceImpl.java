package com.siva.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoException;
import com.siva.business.spi.UserManagementService;
import com.siva.entity.User;
import com.siva.enums.ExceptionCategoryEnum;
import com.siva.enums.ExceptionEnum;
import com.siva.exceptions.MyApplicationException;
import com.siva.exceptions.MyApplicationExceptionManager;
import com.siva.repository.spi.UserManagementRepository;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	@Autowired
	UserManagementRepository userRepository;

	@Override
	public void createUser(User user) throws MyApplicationException {
		try {
			userRepository.createUser(user);
			// userOperationsDAO.createUser(user);
		} catch (MongoException mongoException) {
			throw (new MyApplicationExceptionManager()
					.addToUnacceptableException(new MyApplicationException(ExceptionCategoryEnum.DATABASE_ERROR,
							ExceptionEnum.DATA_ACCESS_LAYER_EXCEPTION, null, mongoException)));
		} catch (Exception exception) {
			throw new MyApplicationException(ExceptionCategoryEnum.DATABASE_ERROR,
					ExceptionEnum.DATA_ACCESS_LAYER_EXCEPTION, new String[] { exception.getMessage() });
		}
	}

	@Override
	public void deleteUserById(String id) throws MyApplicationException {
		try {
			userRepository.deleteUserById(id);
			// userOperationsDAO.createUser(user);
		} catch (MongoException mongoException) {
			throw (new MyApplicationExceptionManager()
					.addToUnacceptableException(new MyApplicationException(ExceptionCategoryEnum.DATABASE_ERROR,
							ExceptionEnum.DATA_ACCESS_LAYER_EXCEPTION, null, mongoException)));
		} catch (Exception exception) {
			throw new MyApplicationException(ExceptionCategoryEnum.DATABASE_ERROR,
					ExceptionEnum.DATA_ACCESS_LAYER_EXCEPTION, new String[] { exception.getMessage() });
		}
	}

	@Override
	public List<User> getUsers(String firstName, String lastName) throws MyApplicationException {
		List<User> userList = null;
		try {
			userList = userRepository.findCustomerByName(firstName, lastName);
			// userList = userOperationsDAO.getUsersBasedOnName(firstName,
			// lastName);
		} catch (MongoException mongoException) {
			throw (new MyApplicationExceptionManager()
					.addToUnacceptableException(new MyApplicationException(ExceptionCategoryEnum.DATABASE_ERROR,
							ExceptionEnum.DATA_ACCESS_LAYER_EXCEPTION, null, mongoException)));
		} catch (Exception exception) {
			throw new MyApplicationException(ExceptionCategoryEnum.DATABASE_ERROR,
					ExceptionEnum.DATA_ACCESS_LAYER_EXCEPTION, new String[] { exception.getMessage() });
		}
		return userList;
	}

	@Override
	public void generateMultipleDummyExceptions() throws MyApplicationException {
		throw new MyApplicationExceptionManager()
				.addToUnacceptableException(new MyApplicationException(ExceptionCategoryEnum.APPLICATION_ERROR,
						ExceptionEnum.APPLICATION_EXCEPTION, new String[] { "Dummy Exception 1" }))
				.addToUnacceptableException(new MyApplicationException(ExceptionCategoryEnum.APPLICATION_ERROR,
						ExceptionEnum.APPLICATION_EXCEPTION, new String[] { "Dummy Exception 2 " }))
				.addToUnacceptableException(new MyApplicationException(ExceptionCategoryEnum.APPLICATION_ERROR,
						ExceptionEnum.APPLICATION_EXCEPTION, new String[] { "Dummy Exception 3 " }));

	}
}