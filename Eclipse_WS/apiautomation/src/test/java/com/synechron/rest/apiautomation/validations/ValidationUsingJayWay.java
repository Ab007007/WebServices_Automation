package com.synechron.rest.apiautomation.validations;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.synechron.rest.apiautomation.tests.GlobalVariables;

import io.restassured.response.Response;

public class ValidationUsingJayWay extends GlobalVariables
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
		  Response response = given().
			param("key", key).
			param("token", token).
		when().
			get("OZdccU3E").
		then().extract().response();
			
	// Printing complete root	  
	 Map<String, ?> rootElement = JsonPath.read(response.asString(),"$");
	 System.out.println("ROOT " + rootElement);
	 
	 // print id
	 String id = JsonPath.read(response.asString(),"$.id");
	 System.out.println("ID " + id);
	 
	 // print Background image selected Array
	List<Map<String, ?>> backgroundImg = JsonPath.read(response.asString(),"$.prefs.backgroundImageScaled");
	 System.out.println("backgroundImg " + backgroundImg);
	 
	 
	 //first element in the array
	 Map<String, ?> firstEleinArray = JsonPath.read(response.asString(),"$.prefs.backgroundImageScaled[0]");
	 System.out.println("firstEleinArray " + firstEleinArray);
	 
	 //All url's in the BackGroundImage selected
	 List<String> urls = JsonPath.read(response.asString(), "$.prefs.backgroundImageScaled[*].url");
	 System.out.println("URLs in  BackGroundImage" + urls);
	 System.out.println(" URLs in BackGroundImage size " + urls.size());
	
	 //Search all urls from the response
	 
	 List<String> allurls = JsonPath.read(response.asString(), "$..url");
	 System.out.println("All URLs " + allurls);
	 System.out.println("All URLs size " + allurls.size());
	 
	 // Applying Filter : get all width which is less than 1000 
	 //$.prefs.backgroundImageScaled[?(@.width<1000)].width
	 
	 List<String> widthWithFilter = JsonPath.read(response.asString(),"$.prefs.backgroundImageScaled[?(@.width<1000)].width");
	 System.out.println("widthWithFilter " + widthWithFilter);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		System.out.println("Get Board Completed");
	}
}
