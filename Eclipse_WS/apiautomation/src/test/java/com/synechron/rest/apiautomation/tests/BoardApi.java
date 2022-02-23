package com.synechron.rest.apiautomation.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BoardApi {
	
	public static String boardID ;
	@BeforeTest
	public void setGlobals(){
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.basePath = "/1/boards/";
	}
	
	
	@Test(priority = 2)
	public void getBoardTest()
	{
		System.out.println("Get Board Started");
		RestAssured.
		given().
			param("key", "c5f676759b86029624f7dcb31ccf655e").
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("OZdccU3E").
		then().
			assertThat().statusCode(200);
		
		System.out.println("Get Board Completed");
	}

	
	@Test(priority = 1)
	public void createBoard() {
		
		ValidatableResponse validateResponse = RestAssured.
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("name","MyRestAssuredAPIBoard123").
				header("Content-Type", "application/json").
			when().
				post().then();
		
		//System.out.println(response.asPrettyString());
		boardID = validateResponse.extract().path("id");
		
		System.out.println("Create Completed");
	}
	
	@Test(priority = 3)
	public void updateBoard() {
		RestAssured.
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("name","MyRestAssuredAPIBoard12356").
				header("Content-Type", "application/json").
			when().
				put(boardID).
			then().
				assertThat().statusCode(200);
		
		System.out.println("Update Completed");
	}
	
	@Test(priority = 4)
	public void deleteBoard() {
		RestAssured.
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("name","MyRestAssuredAPIBoard12356").
				header("Content-Type", "application/json").
			when().
				delete(boardID).
			then().
				assertThat().statusCode(200);
		
		System.out.println("Delete Completed");
	}
}
