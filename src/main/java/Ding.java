import java.util.HashMap;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class Ding {
	public static void main(String[] args) {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient();
		client.withRegion(Regions.US_EAST_1);

		HashMap<String, AttributeValue> key = new HashMap<String, AttributeValue>();
		key.put("firstname", new AttributeValue().withS("Max"));
		key.put("lastname", new AttributeValue().withS("Daemon"));

		GetItemRequest request = new GetItemRequest().withTableName("user").withKey(key);

		try {
			GetItemResult result = client.getItem(request);
			if (result != null) {
				AttributeValue year = result.getItem().get("age");
				System.out.println(year.getN());
			} else {
				System.out.println("No data found");
			}
		} catch (Exception e) {
			System.err.println("Unable to retrieve data: ");
			System.err.println(e.getMessage());
		}

		// System.out
		// .println("-------------------------------Connection test
		// start---------------------------------------");
		//
		// System.out.println(client.listTables());
		//
		// System.out.println(
		// "-------------------------------Connection test
		// complete---------------------------------------");
	}
}
