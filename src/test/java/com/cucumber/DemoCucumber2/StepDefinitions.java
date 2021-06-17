package com.cucumber.DemoCucumber2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.GoogleSearch;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
	WebDriver driver;
	GoogleSearch ggPage ;
	
	@Before
	public void beforeScenario() {
		driver = new ChromeDriver();
		ggPage = new GoogleSearch(driver);
	}
	
	@After
	public void afterScenario() {
		driver.quit();
	}
	
	@Given("I am staying google.com.vn")
	public void i_am_staying_google_com_vn() {
		driver.get("https://www.google.com.vn/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@When("I provide {string} keyword into the search box field")
	public void i_provide_keyword_into_the_search_box_field(String string) {
		ggPage.txtSearchBox.sendKeys(string);
	}

	@When("I click button search")
	public void i_click_button_search() {
		ggPage.btnSearch.submit();
	}

	@Then("I should see the {string} on search reesult box")
	public void i_should_see_the_on_search_reesult_box(String string) {
		System.out.println("AAAAAAAAAAAAAAAAA"  + ggPage.lbResult.getText());
		assert ggPage.lbResult.getText().contains(string) : "Result failed!";
	}
}
