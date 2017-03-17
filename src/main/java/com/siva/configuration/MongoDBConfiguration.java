package com.siva.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoDBConfiguration extends AbstractMongoConfiguration {

	@Value("${mongodb.endpoint}")
	private String mongoEndpoint;

	@Value("${mongodb.database.name}")
	private String mongoDBName;

	@Value("${mongodb.user}")
	private String mongoUserName;

	@Value("${mongodb.password}")
	private String mongoPassword;

	@Override
	protected String getDatabaseName() {
		return mongoDBName;
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {

		// MongoClientOptions.Builder optionsBuilder =
		// MongoClientOptions.builder().writeConcern(WriteConcern.W1)
		// .readPreference(ReadPreference.primary()).connectionsPerHost(10).connectTimeout(15000)
		// .maxWaitTime(300000).socketTimeout(600000).threadsAllowedToBlockForConnectionMultiplier(1500);
		//
		// MongoClientOptions options = optionsBuilder.build();

		System.out.println("Accessing MONGO DB:");
		
		StringBuilder sb = new StringBuilder();
		sb.append("mongodb://" + mongoUserName + ":" + mongoPassword + "@" + mongoEndpoint + ":27017/" + mongoDBName);

		System.out.println("MONGO URL:" + sb.toString());

		MongoClientURI uri = new MongoClientURI(sb.toString());
		MongoClient client = new MongoClient(uri);

		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate template = new MongoTemplate(mongo(), getDatabaseName());
		return template;
	}

	@Override
	public String getMappingBasePackage() {
		return "com.siva.*";
	}

	/**
	 * @return the mongoEndpoint
	 */
	public String getMongoEndpoint() {
		return mongoEndpoint;
	}

	/**
	 * @return the mongoDBName
	 */
	public String getMongoDBName() {
		return mongoDBName;
	}

	/**
	 * @return the mongoUserName
	 */
	public String getMongoUserName() {
		return mongoUserName;
	}

	/**
	 * @return the mongoPassword
	 */
	public String getMongoPassword() {
		return mongoPassword;
	}

}
