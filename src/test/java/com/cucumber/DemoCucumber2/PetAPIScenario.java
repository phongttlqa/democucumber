package com.cucumber.DemoCucumber2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import pageobject.PetAPI;

public class PetAPIScenario {
	PetAPI petapi;
	
	@Before
	public void beforeTest() {
		RestAssured.baseURI = "http://petstore.swagger.io/v2/pet";
		petapi = new PetAPI();
	}
	
	@After
	public void afterTest() {
		RestAssured.reset();
	}
	
	
	@Given("I provide petID {string}")
	public void i_provide_pet_id(String string) {
	    petapi.buildRequestGetPetByID(string);
	}

	@When("Isend request to get Pet by ID")
	public void isend_request_to_get_pet_by_id() {
	    petapi.sendGetPetByIDRequest();
	}

	@Then("I get Pet")
	public void i_get_pet() {
	    petapi.verifyGetPetSuccess();
	}

	@Given("I provide a new pet {string} and {string} and {string}")
	public void i_provide_a_new_pet_and_and(String string, String string2, String string3) {
	    petapi.buildCreateApiRequest(string, string2, string3);
	}

	@When("Isend request to create a new Pet")
	public void isend_request_to_create_a_new_pet() {
	   petapi.sendCreateRequest();
	}

	@Then("I have a new Pet create")
	public void i_have_a_new_pet_create() {
	    petapi.verifyCreateSuccess();
	}

}
