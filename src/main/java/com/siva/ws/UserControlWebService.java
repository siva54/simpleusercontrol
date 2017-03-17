package com.siva.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.dao.impl.UserOperationsDAOImpl;
import com.siva.dao.spi.UserOperationsDAO;
import com.siva.entity.User;

@RestController
@RequestMapping(path = "/user")
@EnableAutoConfiguration
public class UserControlWebService {

	UserOperationsDAO userOperationsDAO = new UserOperationsDAOImpl();

	@PostMapping(path = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createUser(@RequestBody User user) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.ACCEPTED);

		try {
			userOperationsDAO.createUser((User) user);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return responseEntity;
	}

	@GetMapping(path = "/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> getUser() {
		List<User> data = new ArrayList<>();

		try {
			data = userOperationsDAO.getUser();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		
		return new ResponseEntity<List<User>>(data,HttpStatus.ACCEPTED);
	}
}
