package com.siva.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.siva.dao.spi.UserOperationsDAO;
import com.siva.entity.User;

@Repository
public class UserOperationsDAOImpl implements UserOperationsDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void createUser(User user) throws Exception {

		//		mongoTemplate = new MongoTemplate(mongo(), "user");
		mongoTemplate.insert(user, "user");
	}

	@Override
	public List<User> getUser() throws Exception {
//		mongoTemplate = new MongoTemplate(mongo(), "user");
		return mongoTemplate.find(new Query(), User.class, "user");
	}

	public Mongo mongo() throws Exception {

		// MongoClientOptions.Builder optionsBuilder =
		// MongoClientOptions.builder().writeConcern(WriteConcern.W1)
		// .readPreference(ReadPreference.primary()).connectionsPerHost(10).connectTimeout(15000)
		// .maxWaitTime(300000).socketTimeout(600000).threadsAllowedToBlockForConnectionMultiplier(1500);
		//
		// MongoClientOptions options = optionsBuilder.build();

		System.out.println("Accessing MONGO DB:");

		StringBuilder sb = new StringBuilder();
		// sb.append("mongodb://" + mongoUserName + ":" + mongoPassword + "@" +
		// mongoEndpoint + ":27017/" + mongoDBName);
		// String mongoDBStr =
		// "mongodb://admin:zQMBni59K1me@127.12.219.2:27017/user";
		String mongoDBStr = "mongodb://localhost:27017/user";
		// System.out.println("MONGO URL:" + sb.toString());

		MongoClientURI uri = new MongoClientURI(mongoDBStr);
		MongoClient client = new MongoClient(uri);

		return client;
	}

}
