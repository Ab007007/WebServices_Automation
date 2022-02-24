package com.synechron.rest.apiautomation.logs;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.synechron.rest.apiautomation.tests.GlobalVariables;

import io.restassured.response.Response;

public class PrintLogs  extends GlobalVariables 
{
	@BeforeTest
	public void setGlobals(){
		baseURI = uri;
		basePath = "/1/boards/";
	}
	
	
	@Test(priority = 2)
	public void getBoardTest()
	{
		System.out.println("Get Board Started");
		System.out.println("Get Board Started");
		   given().log().all().
			param("key", key).
			param("token", token).
		when().
			get("OZdccU3E").
		then().log().body();
		System.out.println("Get Board Completed");
	}
}
