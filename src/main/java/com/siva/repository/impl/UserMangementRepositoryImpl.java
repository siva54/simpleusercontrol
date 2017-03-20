package com.siva.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.siva.entity.User;
import com.siva.enums.CollectionsEnum;
import com.siva.enums.UserCollectionEnum;
import com.siva.repository.spi.UserManagementRepository;

@Repository
public class UserMangementRepositoryImpl implements UserManagementRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public <S extends User> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends User> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createUser(User user) throws Exception {
		Query idSearchQuery = new Query(Criteria.where(UserCollectionEnum.ID.getColumnName()).is(user.getId()));

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
	public List<User> findCustomerByName(String firstName, String lastName) throws Exception {
		CriteriaDefinition criteriaDefinition = Criteria.where(UserCollectionEnum.FIRSTNAME.getColumnName())
				.is(firstName).andOperator(Criteria.where(UserCollectionEnum.LASTNAME.getColumnName()).is(lastName));
		Query query = new Query(criteriaDefinition);

		return mongoTemplate.find(query, User.class, CollectionsEnum.USER.getCollectionName());
	}

	@Override
	public void deleteUserById(String id) throws Exception {
		Query deleteQuery = new Query(Criteria.where(UserCollectionEnum.ID.getColumnName()).is(id));
		mongoTemplate.remove(deleteQuery, CollectionsEnum.USER.getCollectionName());
	}
}