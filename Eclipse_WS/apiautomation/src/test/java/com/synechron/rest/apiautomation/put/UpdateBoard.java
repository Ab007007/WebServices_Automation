package com.synechron.rest.apiautomation.put;

import io.restassured.RestAssured;

public class UpdateBoard {

	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("name","MyRestAssuredAPIBoard12356").
				header("Content-Type", "application/json").
			when().
				put("/1/boards/6215cb50f14e7d6d4dc7ce36").
			then().
				assertThat().statusCode(200);
		
		System.out.println("Completed");
	}
}
