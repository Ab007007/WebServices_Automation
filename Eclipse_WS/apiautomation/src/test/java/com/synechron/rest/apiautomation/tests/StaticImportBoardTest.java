package com.synechron.rest.apiautomation.tests;

import static org.hamcrest.CoreMatchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class StaticImportBoardTest extends GlobalVariables
{
	
	public static String boardID ;
	public static String boardName = "TestNGBoard";
	
	@BeforeTest
	public void setGlobals(){
		baseURI = uri;
		basePath = "/1/boards/";
	}
	
	
	@Test(priority = 2)
	public void getBoardTest()
	{
		System.out.println("Get Board Started");
		given().
			param("key", key).
			param("token", token).
		when().
			get("OZdccU3E").
		then().
			assertThat().statusCode(200).
			body("id", equalTo(boardID)).and().
			body("name",equalTo(boardName));
		System.out.println("Get Board Completed");
	}

	
	@Test(priority = 1)
	public void createBoard() {
		
		ValidatableResponse validateResponse = 
			given().
				queryParam("key", key).
				queryParam("token", token).
				queryParam("name",boardName).
				header("Content-Type", "application/json").
			when().
				post().then();
		
		//System.out.println(response.asPrettyString());
		boardID = validateResponse.extract().path("id");
		
		System.out.println("Create Completed");
	}
	
	@Test(priority = 3)
	public void updateBoard() {
		
			given().
				queryParam("key", key).
				queryParam("token", token).
				queryParam("name",boardName).
				header("Content-Type", "application/json").
			when().
				put(boardID).
			then().
				assertThat().statusCode(200);
		
		System.out.println("Update Completed");
	}
	
	@Test(priority = 4)
	public void deleteBoard() {
		
			given().
				queryParam("key", key).
				queryParam("token", token).
				queryParam("name",boardName).
				header("Content-Type", "application/json").
			when().
				delete(boardID).
			then().
				assertThat().statusCode(200);
		
		System.out.println("Delete Completed");
	}
}
