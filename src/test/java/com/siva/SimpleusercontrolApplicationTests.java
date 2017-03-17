//package com.siva;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
//import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
//import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
//import com.amazonaws.services.dynamodbv2.model.KeyType;
//import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
//import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
//import com.siva.configuration.DynamoDBConfiguration;
//import com.siva.entity.User;
//import com.siva.repositories.UserRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = { PropertyPlaceholderAutoConfiguration.class, DynamoDBConfiguration.class })
//public class SimpleusercontrolApplicationTests {
//
//	private static final String KEY_NAME = "id";
//	private static final Long READ_CAPACITY_UNITS = 5L;
//	private static final Long WRITE_CAPACITY_UNITS = 5L;
//
//	@Autowired
//	UserRepository repository;
//
//	@Autowired
//	private AmazonDynamoDB amazonDynamoDB;
//
//	@Before
//	public void init() throws Exception {
//
//		ListTablesResult listTablesResult = amazonDynamoDB.listTables();
//
//		listTablesResult.getTableNames().stream().filter(tableName -> tableName.equals("user")).forEach(tableName -> {
//			amazonDynamoDB.deleteTable(tableName);
//		});
//
//		List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
//		attributeDefinitions.add(new AttributeDefinition().withAttributeName(KEY_NAME).withAttributeType("S"));
//
//		List<KeySchemaElement> keySchemaElements = new ArrayList<KeySchemaElement>();
//		keySchemaElements.add(new KeySchemaElement().withAttributeName(KEY_NAME).withKeyType(KeyType.HASH));
//
//		CreateTableRequest request = new CreateTableRequest().withTableName("user").withKeySchema(keySchemaElements)
//				.withAttributeDefinitions(attributeDefinitions).withProvisionedThroughput(new ProvisionedThroughput()
//						.withReadCapacityUnits(READ_CAPACITY_UNITS).withWriteCapacityUnits(WRITE_CAPACITY_UNITS));
//
//		amazonDynamoDB.createTable(request);
//
//	}
//
//	@Test
//	public void sampleTestCase() {
//		User dave = new User("Dave", "Matthews");
//		repository.save(dave);
//
//		User carter = new User("Carter", "Beauford");
//		repository.save(carter);
//
//		List<User> result = repository.findByName("Max", "Daemon");
//		System.out.println(result);
//		// Assert.assertThat(result.size(), 1);
//		// Assert.assertThat(result, hasItem(dave));
//	}
//
//}
