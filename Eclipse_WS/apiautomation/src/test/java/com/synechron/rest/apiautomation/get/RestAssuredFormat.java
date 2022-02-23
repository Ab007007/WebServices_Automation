package com.synechron.rest.apiautomation.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RestAssuredFormat {

	public static void main(String[] args) {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.param("key", "c5f676759b86029624f7dcb31ccf655e");
		reqSpec.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");
		
		Response response = reqSpec.get("https://api.trello.com/1/boards/OZdccU3E");
		response.prettyPrint();
		
		ValidatableResponse validateRes = response.then();
		validateRes.statusCode(200);
	
		
	}
}
