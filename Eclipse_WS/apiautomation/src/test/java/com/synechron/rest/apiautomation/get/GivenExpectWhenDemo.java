package com.synechron.rest.apiautomation.get;

import io.restassured.RestAssured;

public class GivenExpectWhenDemo {

	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given().
			param("key", "c5f676759b86029624f7dcb31ccf655e").
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		expect().
			statusCode(200).
		when().
			get("/1/boards/OZdccU3E");
	}
}
