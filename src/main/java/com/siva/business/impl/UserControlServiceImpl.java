package com.siva.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.business.spi.UserControlService;
import com.siva.dao.spi.UserOperationsDAO;
import com.siva.entity.User;
import com.siva.enums.Errors;
import com.siva.exceptions.MyApplicationException;

@Service
public class UserControlServiceImpl implements UserControlService {

	@Autowired
	UserOperationsDAO userOperationsDAO;

	@Override
	public void createUser(User user) throws MyApplicationException {
		try {
			userOperationsDAO.createUser(user);
		} catch (Exception exception) {
			throw new MyApplicationException(Errors.DATABASE_CALL_FAILED, null, exception);
		}
	}

	@Override
	public List<User> getUsers(String firstName, String lastName) throws MyApplicationException {
		List<User> userList = null;
		try {
			userList = userOperationsDAO.getUsersBasedOnName(firstName, lastName);
		} catch (Exception exception) {
			throw new MyApplicationException(Errors.DATABASE_CALL_FAILED, null, exception);
		}
		return userList;
	}
}