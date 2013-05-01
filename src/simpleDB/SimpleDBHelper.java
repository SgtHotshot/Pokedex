package simpleDB;

import java.util.*;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.ReplaceableAttribute;
import com.amazonaws.services.simpledb.model.ReplaceableItem;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.*;


public class SimpleDBHelper {

	/**
	 * AmazonSimpleDB object
	 */
	private AmazonSimpleDB sdb;
	
	/**
	 * Domain Name using for the Pokedex project
	 */
	private final String DOMAIN_NAME = "Pokedex";

	/**
	 * Constructor for the simpleDBHelper class
	 * @param accessKey
	 * @param secretKey
	 */
	public SimpleDBHelper() {

		sdb = new AmazonSimpleDBClient(new ClasspathPropertiesFileCredentialsProvider());
		Region usEast1 = Region.getRegion(Regions.US_EAST_1);
		sdb.setRegion(usEast1);
		
		setup();
	}
	
	/**
	 * Setup Database
	 *  ////Will Be used in future versions
	 */
	private void setup(){
		System.out.println("Domain Loaded: " + DOMAIN_NAME + ".\n");
	}

	public Map<String, String> getPokemonByID(String id) {

		// If this doesn’t work, do it like the rest; with a query.

//		try {
//			GetAttributesRequest request = new GetAttributesRequest();
//			request.setDomainName(DOMAIN_NAME);
//			request.setItemName(id);
//			GetAttributesResponse response = service.getAttributes(request);
//			GetAttributesResult result = response.getGetAttributesResult();
//			return toAttibuteMap(result);
//		}
//		catch (Exception ex) {
//			throw new SimpleDBOperationFailedException("Get failed on domain=" + domainName + " and item=" + itemName, ex);
//		}
		
		Map<String, String> answer = new HashMap<String, String>();
		
		String selectExpression = "select * from '" + DOMAIN_NAME + "' where ID = '" + id + "'";
		System.out.println("Selecting: " + selectExpression + "\n");
		SelectRequest selectRequest = new SelectRequest(selectExpression);
		
		for(Item item : sdb.select(selectRequest).getItems()){
			System.out.println("Item Name: " + item.getName());
			for(Attribute attribute : item.getAttributes()){
				System.out.println("Attribute Name: " + attribute.getName());
				System.out.println("Attribute Value: " + attribute.getValue());
				answer.put(attribute.getName(), attribute.getValue());
			}
		}
		
		return answer;	
	}
	
	
	public Map<String, String> getPokemonByName(String name) {
		
		Map<String, String> answer = new HashMap<String, String>();
		name = name.replaceAll("\t", "");

		// could not figure out these symbols
//		if(name.contains("♂") || name.contains("♂") || name.contains("♀") || name.contains("♀")){
//			System.out.println("contains symbols");
//		}else{
//			System.out.println("doesn't contain symbols");
//		}
//		name = name.replaceAll("\u2642", "0x2462");
//		name = name.replaceAll("\u2640", "0x2640");
		
		
		String selectExpression = "select * from " + DOMAIN_NAME + " where Name = '" + name + "'";
		System.out.println("Selecting: " + selectExpression + "\n");
		SelectRequest selectRequest = new SelectRequest(selectExpression);
		
		for(Item item : sdb.select(selectRequest).getItems()){
			System.out.println("Item Name: " + item.getName());
			for(Attribute attribute : item.getAttributes()){
				System.out.println("Attribute Name: " + attribute.getName());
				System.out.println("Attribute Value: " + attribute.getValue());
				answer.put(attribute.getName(), attribute.getValue());
			}
		}
		if(answer.isEmpty()){
			System.out.println("answer is empty");
			String selectExpression2 = "select * from " + DOMAIN_NAME + " where ID = '" + name + "'";
			System.out.println("Selecting: " + selectExpression2 + "\n");
			SelectRequest selectRequest2 = new SelectRequest(selectExpression2);

			for(Item item : sdb.select(selectRequest2).getItems()){
				System.out.println("Item Name: " + item.getName());
				for(Attribute attribute : item.getAttributes()){
					System.out.println("Attribute Name: " + attribute.getName());
					System.out.println("Attribute Value: " + attribute.getValue());
					answer.put(attribute.getName(), attribute.getValue());
				}
			}
		}
		
		return answer;	
	}


	private Map<String, String> toAttibuteMap(GetAttributesResult getAttributesResult) {
		Map<String, String> attributeMap = new HashMap<String, String>();
		List<Attribute> attributes = getAttributesResult.getAttributes();
		for (Attribute attribute : attributes) {
			String name = attribute.getName();
			String value = attribute.getValue();
			attributeMap.put(name, value);
		}
		return attributeMap;
	}


	private Map<String, String> toAttibuteMap(Item item) {
		Map<String, String> attributeMap = new HashMap<String, String>();
		List<Attribute> attributes = item.getAttributes();
		for (Attribute attribute : attributes) {
			String name = attribute.getName();
			String value = attribute.getValue();
			attributeMap.put(name, value);
		}
		return attributeMap;

	}
}
