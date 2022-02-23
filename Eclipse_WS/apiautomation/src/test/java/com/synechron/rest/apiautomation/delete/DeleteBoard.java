package com.synechron.rest.apiautomation.delete;

import io.restassured.RestAssured;

public class DeleteBoard {

	
	public static void main(String[] args) {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
			given().
				queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
				queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				queryParam("name","MyRestAssuredAPIBoard12356").
				header("Content-Type", "application/json").
			when().
				delete("/1/boards/6215d2576e5aa86e1abb805f").
			then().
				assertThat().statusCode(200);
		
		System.out.println("Completed");
	}
}
