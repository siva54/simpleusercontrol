package com.siva.ws;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
import com.siva.exceptions.MyApplicationException;

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
		ResponseEntity<String> responseEntity = null;

		try {
			userControlService.createUser(user);
			responseEntity = new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (MyApplicationException myApplicationException) {
			// All Known exceptions
			responseEntity = new ResponseEntity<String>(myApplicationException.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception exception) {
			// All unexpected exceptions
			responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
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

		ResponseEntity<List<User>> responseEntity = null;
		List<User> data = new ArrayList<>();

		try {

			data = userControlService.getUsers(firstName, lastName);

			if (CollectionUtils.isEmpty(data)) {
				responseEntity = new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			} else {
				responseEntity = new ResponseEntity<List<User>>(data, HttpStatus.OK);
			}
		} catch (MyApplicationException myApplicationException) {
			// All Known exceptions
			responseEntity = new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception exception) {
			// All unexpected exceptions
			responseEntity = new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}
}
