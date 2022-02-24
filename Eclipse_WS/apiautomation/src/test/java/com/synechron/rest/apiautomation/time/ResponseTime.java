package com.synechron.rest.apiautomation.time;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.synechron.rest.apiautomation.tests.GlobalVariables;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseTime extends GlobalVariables
{
	RequestSpecification reqSpec;
	RequestSpecBuilder reqBuilder;
	
	ResponseSpecification resSpec ; 
	ResponseSpecBuilder resBuilder;
	
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
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectHeader("Server", "globaledge-envoy");
		resBuilder.expectStatusCode(200);
		//resBuilder.expectBody("id", containsString("1"));
		resBuilder.expectBody("name", equalTo(boardName));
		
		resSpec = resBuilder.build();
	}
	
	
	@Test
	public void getBoardTest()
	{
		System.out.println("Get Board Started");
		long time = given().
			spec(reqSpec).
		when().
			get("OZdccU3E").
		timeIn(TimeUnit.MILLISECONDS);
		System.out.println("Get Board Completed with a response time " + time);
	}

	
	
}
