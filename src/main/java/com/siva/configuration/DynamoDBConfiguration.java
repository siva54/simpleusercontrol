//package com.siva.configuration;
//
//import org.apache.commons.lang3.StringUtils;
//import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
//
//@Configuration
//@EnableDynamoDBRepositories(basePackages = "com.siva.repositories")
//public class DynamoDBConfiguration {
//	@Value("${amazon.dynamodb.endpoint}")
//	private String amazonDynamoDBEndpoint;
//
//	@Value("${amazon.aws.accesskey}")
//	private String amazonAWSAccessKey;
//
//	@Value("${amazon.aws.secretkey}")
//	private String amazonAWSSecretKey;
//
//	@Bean
//	public AmazonDynamoDB amazonDynamoDB(AWSCredentials amazonAWSCredentials) {
//		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials);
//
//		if (StringUtils.isNotEmpty(amazonDynamoDBEndpoint)) {
//			amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
//		}
//		return amazonDynamoDB;
//	}
//
//	@Bean
//	public AWSCredentials amazonAWSCredentials() {
//		return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
//	}
//}
