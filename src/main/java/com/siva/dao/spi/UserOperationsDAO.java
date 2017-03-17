package com.siva.dao.spi;

import java.util.List;

import com.siva.entity.User;

public interface UserOperationsDAO {
	public void createUser(User user) throws Exception;

	public List<User> getUser() throws Exception;
}
