package com.siva.business.service.spi;

import java.util.List;

import com.siva.entity.User;

public interface UserControlService {
	Boolean createUser(User user);

	List<User> getUsers(String firstName, String lastName);
}
