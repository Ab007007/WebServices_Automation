package com.synechron.rest.apiautomation.get;

import org.hamcrest.CoreMatchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ValidationsDemo {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
			given().
				params("key", "c5f676759b86029624f7dcb31ccf655e").
				params("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
			when().
				get("/1/boards/OZdccU3E").
			then().
				assertThat().statusCode(200).and().
					contentType(ContentType.JSON).and().
					body("id", CoreMatchers.equalTo("621361a123899b38145e5225")).and().
					body("name",CoreMatchers.equalTo("MyFirstBoard")).and().
					body("desc" , CoreMatchers.containsString("BRAINSTORM"));	
		System.out.println("Test completed successfully");	
	}

}
