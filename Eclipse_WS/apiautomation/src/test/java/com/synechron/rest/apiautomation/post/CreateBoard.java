package com.synechron.rest.apiautomation.post;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBoard {

	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.trello.com";
		Response response = RestAssured.
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("name","MyRestAssuredAPIBoard123").
				header("Content-Type", "application/json").
			when().
				post("/1/boards");
		
		System.out.println(response.asPrettyString());
		
		System.out.println("Completed");
	}
}
