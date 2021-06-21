package pageobject;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetAPI {
	private Response response = null;
	private JsonPath path = null;
	private RequestSpecification requestSpecification;
	
	public void buildRequestGetPetByID(String id) {
		RequestSpecBuilder builder =  new RequestSpecBuilder();
		builder.setBasePath(id);
		builder.setContentType("application/json");
		requestSpecification = builder.build();
		requestSpecification = RestAssured.given().spec(requestSpecification);
		requestSpecification.log().all();
	}

	public void sendGetPetByIDRequest() {
		response = requestSpecification.when().get();
	}
	
	public void verifyGetPetSuccess() {
		path = response.jsonPath();
		Assert.assertEquals("Status Check Failed!", 200, response.getStatusCode());
	}

	
	public void buildCreateApiRequest(String petid, String petname, String petstatus) {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType("application/json");
		builder.setBody("{\"id\":\"" + petid + "\", \"name\":\"" + petname + "\" , \"status\":\"" + petstatus + "\"}");
		requestSpecification = builder.build();
		requestSpecification = RestAssured.given().spec(requestSpecification);
		requestSpecification.log().all();
	}
	
	public void sendCreateRequest() {
		response = requestSpecification.when().post();
	}
	
	public void verifyCreateSuccess() {
		path =  response.jsonPath();
		Assert.assertEquals("Status Check Failed!", 200, response.getStatusCode());
	}
	
}
