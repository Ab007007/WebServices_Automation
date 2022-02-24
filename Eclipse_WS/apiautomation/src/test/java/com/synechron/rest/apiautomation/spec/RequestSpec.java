package com.synechron.rest.apiautomation.spec;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.synechron.rest.apiautomation.tests.GlobalVariables;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RequestSpec extends GlobalVariables
{
	RequestSpecification reqSpec;
	RequestSpecBuilder reqBuilder;
	
	public static String boardID ;
	public static String boardIdentification ;
	
	public static String boardName = "TestNGBoard";
	
	@BeforeTest
	public void setGlobals(){
		baseURI = uri;
		basePath = "/1/boards/";
		reqBuilder = new RequestSpecBuilder();
		reqBuilder.addQueryParam("key", key);
		reqBuilder.addQueryParam("token", token);
		reqBuilder.addQueryParam("name", boardName);
		reqBuilder.setContentType("text/plain");
		
		reqSpec = reqBuilder.build();
	}
	
	
	@Test(priority = 2)
	public void getBoardTest()
	{
		System.out.println("Get Board Started");
		given().
			spec(reqSpec).
		when().
			get(boardIdentification).
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
				spec(reqSpec).
			when().
				post().then();
		
		//System.out.println(response.asPrettyString());
		boardID = validateResponse.extract().path("id");
		String tempboardIdentification = validateResponse.extract().path("shortUrl");
		System.out.println(">>>>>>>>>>>>>>>>>> "+tempboardIdentification );
		boardIdentification = tempboardIdentification.split("/")[tempboardIdentification.split("/").length-1];
		System.out.println("Created board id " + boardIdentification);
		System.out.println("Create Completed");
	}
	
	@Test(priority = 3)
	public void updateBoard() {
		
			given().
				spec(reqSpec).
			when().
				put(boardID).
			then().
				assertThat().statusCode(200);
		
		System.out.println("Update Completed");
	}
	
	@Test(priority = 4)
	public void deleteBoard() {
		
			given().
				spec(reqSpec).	
			when().
				delete(boardID).
			then().
				assertThat().statusCode(200);
		
		System.out.println("Delete Completed");
	}
}
