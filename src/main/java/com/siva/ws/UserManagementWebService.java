package com.siva.ws;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siva.business.spi.UserManagementService;
import com.siva.entity.User;
import com.siva.exceptions.MyApplicationException;
import com.siva.exceptions.MyApplicationExceptionManager;
import com.siva.helper.WebResponseBuilder;

@RestController
@RequestMapping(path = "/user")
@EnableAutoConfiguration
public class UserManagementWebService {

	@Autowired
	UserManagementService userControlService;

	/**
	 * POST Web service method to create a user.
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> createUser(@RequestBody User user) {

		ResponseEntity<Object> responseEntity = null;

		try {
			userControlService.createUser(user);
			responseEntity = new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (MyApplicationExceptionManager myApplicationManager) {
			responseEntity = WebResponseBuilder
					.errorResponseBuilder(myApplicationManager.retrieveUnacceptableExceptions());
		} catch (MyApplicationException myApplicationException) {
			// All Known exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(myApplicationException);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		} catch (Exception exception) {
			// All unexpected exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(exception);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
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
	public ResponseEntity<Object> getUser(@RequestParam(value = "firstname", required = false) String firstName,
			@RequestParam(value = "lastname", required = false) String lastName) {

		ResponseEntity<Object> responseEntity = null;
		List<User> data = new ArrayList<>();

		try {
			data = userControlService.getUsers(firstName, lastName);

			if (CollectionUtils.isEmpty(data)) {
				responseEntity = new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			} else {
				responseEntity = new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (MyApplicationExceptionManager myApplicationManager) {
			responseEntity = WebResponseBuilder
					.errorResponseBuilder(myApplicationManager.retrieveUnacceptableExceptions());
		} catch (MyApplicationException myApplicationException) {
			// All Known exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(myApplicationException);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		} catch (Exception exception) {
			// All unexpected exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(exception);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		}

		return responseEntity;
	}

	/**
	 * DELETE Web service method to delete an existing user.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/delete")
	public ResponseEntity<Object> deleteUser(@RequestParam(value = "id") String id) {

		ResponseEntity<Object> responseEntity = null;

		try {
			userControlService.deleteUserById(id);
			responseEntity = new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		} catch (MyApplicationExceptionManager myApplicationManager) {
			responseEntity = WebResponseBuilder
					.errorResponseBuilder(myApplicationManager.retrieveUnacceptableExceptions());
		} catch (MyApplicationException myApplicationException) {
			// All Known exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(myApplicationException);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		} catch (Exception exception) {
			// All unexpected exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(exception);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		}
		return responseEntity;
	}

	/**
	 * GET Web service method to demonstrate exception handling for multiple
	 * exceptions.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/demoexception")
	public ResponseEntity<Object> demonstrateExceptions() {
		ResponseEntity<Object> responseEntity = null;

		try {
			userControlService.generateMultipleDummyExceptions();
			responseEntity = new ResponseEntity<Object>(HttpStatus.OK);
		} catch (MyApplicationExceptionManager myApplicationManager) {
			responseEntity = WebResponseBuilder
					.errorResponseBuilder(myApplicationManager.retrieveUnacceptableExceptions());
		} catch (MyApplicationException myApplicationException) {
			// All Known exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(myApplicationException);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		} catch (Exception exception) {
			// All unexpected exceptions
			List<Exception> exceptionList = new ArrayList<>();
			exceptionList.add(exception);
			responseEntity = WebResponseBuilder.errorResponseBuilder(exceptionList);
		}
		return responseEntity;
	}
}