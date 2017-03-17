package com.siva.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.siva.dao.spi.UserOperationsDAO;
import com.siva.entity.User;
import com.siva.enums.CollectionsEnum;
import com.siva.enums.UserCollectionEnum;

@Repository
public class UserOperationsDAOImpl implements UserOperationsDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void createUser(User user) throws Exception {

		Query idSearchQuery = new Query(Criteria.where(UserCollectionEnum.ID.getColumnName()).is(user.getUserId()));

		User finalUserDetail = new User();

		User existingUser = mongoTemplate.findOne(idSearchQuery, User.class, CollectionsEnum.USER.getCollectionName());

		if (existingUser != null) {
			finalUserDetail = existingUser;
			if (user.getAge() != null) {
				finalUserDetail.setAge(user.getAge());
			}
			if (user.getEmail() != null) {
				finalUserDetail.setEmail(user.getEmail());
			}
			if (user.getFirstName() != null) {
				finalUserDetail.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				finalUserDetail.setLastName(user.getLastName());
			}
			if (user.getGender() != null) {
				finalUserDetail.setGender(user.getGender());
			}
			mongoTemplate.remove(idSearchQuery, CollectionsEnum.USER.getCollectionName());
		} else {
			finalUserDetail = user;
		}

		mongoTemplate.insert(finalUserDetail, "user");
	}

	@Override
	public List<User> getUsers() throws Exception {
		return mongoTemplate.find(new Query(), User.class, CollectionsEnum.USER.getCollectionName());
	}

	@Override
	public List<User> getUsersBasedOnName(String firstName, String lastName) throws Exception {
		return mongoTemplate.find(
				new Query(Criteria.where(UserCollectionEnum.FIRSTNAME.getColumnName()).is(firstName)
						.where(UserCollectionEnum.LASTNAME.getColumnName()).is(lastName)),
				User.class, CollectionsEnum.USER.getCollectionName());
	}
}