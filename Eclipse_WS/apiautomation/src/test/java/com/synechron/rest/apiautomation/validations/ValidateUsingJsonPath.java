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
import io.restassured.response.ValidatableResponse;

public class ValidateUsingJsonPath extends GlobalVariables {
	@BeforeTest
	public void setGlobals(){
		baseURI = uri;
		basePath = "/1/boards/";
	}
	
	@Test(priority = 2)
	public void getBoardTest()
	{
		System.out.println("Get Board Started");
		   ValidatableResponse vResponse = 
			    given().
				  	param("key", key).
				  	param("token", token).
				when().
					get("OZdccU3E").
				then();
		   
		   // print id
		  String id =  vResponse.extract().path("id");  
		  System.out.println("ID " + id);
		  
		  // print Background image selected Array
		  List<Map<String, ?>> backgroundImg = vResponse.extract().path("prefs.backgroundImageScaled");
		  System.out.println("backgroundImg " + backgroundImg);
		  
		  //first element in the array
		  Map<String, ?> firstEleinArray = vResponse.extract().path("prefs.backgroundImageScaled[0]");
		  System.out.println("firstEleinArray " + firstEleinArray);
		 
		  //All url's in the BackGroundImage selected
		  int sizeofList = vResponse.extract().path("prefs.backgroundImageScaled.size()");
		  for (int i = 0; i < sizeofList ; i++)
		  {
			  String url = vResponse.extract().path("prefs.backgroundImageScaled[" + i +"].url");
			  System.out.println(url);
		  }
	  		
		// find the node with some value
		  Map<String, ?> nodeWithValue = vResponse.extract().path("prefs.backgroundImageScaled.find { it.width == 480 }");
		  System.out.println("nodeWithValue " + nodeWithValue);
		 
		// find the node with some value
		  String urlWithCondition = vResponse.extract().path("prefs.backgroundImageScaled.find { it.width == 480 }.url");
		  System.out.println("urlWithCondition " + urlWithCondition);
		
		  
		// find the node with Min value  on width 
		  Integer minWidth = vResponse.extract().path("prefs.backgroundImageScaled.min { it.width }.width");
		  System.out.println("minWidth " + minWidth);
		
		// find the node with Max value  on width 
		  Integer maxWidth = vResponse.extract().path("prefs.backgroundImageScaled.max { it.width }.width");
		  System.out.println("maxWidth " + maxWidth);
		
		// find the node with Max value  on width 
		  List<Integer> allWidth = vResponse.extract().path("prefs.backgroundImageScaled.findAll { it.width > 1000 }");
		  System.out.println("allWidth " + allWidth);
		 
		  
		  
		  
		  
		  
		  
		  
		  
		  
	}
}
