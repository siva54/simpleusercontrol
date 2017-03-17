package com.siva.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.business.spi.UserControlService;
import com.siva.dao.spi.UserOperationsDAO;
import com.siva.entity.User;

@Service
public class UserControlServiceImpl implements UserControlService {

	@Autowired
	UserOperationsDAO userOperationsDAO;

	@Override
	public void createUser(User user) {
		try {
			userOperationsDAO.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getUsers(String firstName, String lastName) {
		List<User> userList = null;
		try {
			userList = userOperationsDAO.getUsersBasedOnName(firstName, lastName);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return userList;
	}
}