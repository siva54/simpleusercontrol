package com.siva.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.business.spi.UserControlService;
import com.siva.entity.User;

@RestController
@RequestMapping(path = "/user")
@EnableAutoConfiguration
public class UserControlWebService {

	@Autowired
	UserControlService userControlService;

	/**
	 * POST Web service method to create a user.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> createUser(@RequestBody User user) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.CREATED);

		try {
			userControlService.createUser(user);
		} catch (Exception exception) {
			
		}
		return responseEntity;
	}

	/**
	 * GET Web service method to get user information.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@GetMapping(path = "/get", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> getUser(@RequestParam(value = "firstname", required = false) String firstName,
			@RequestParam(value = "lastname", required = false) String lastName) {
		List<User> data = new ArrayList<>();

		data = userControlService.getUsers(firstName, lastName);

		return new ResponseEntity<List<User>>(data, HttpStatus.ACCEPTED);
	}
}
