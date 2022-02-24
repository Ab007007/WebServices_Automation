package com.synechron.rest.apiautomation.filters;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.synechron.rest.apiautomation.tests.GlobalVariables;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FilterDemo  extends GlobalVariables{

	public static PrintStream ps;
	public static StringWriter sw;
	
	public static PrintStream resps;
	public static StringWriter ressw;
	@BeforeTest
	public void setGlobals(){
		sw = new StringWriter();
		ps = new PrintStream(new WriterOutputStream(sw), true);
		
		ressw = new StringWriter();
		resps = new PrintStream(new WriterOutputStream(ressw), true);
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
			filter(new RequestLoggingFilter(ps)).
			filter(new ResponseLoggingFilter(resps)).
		when().
			get("OZdccU3E").
		then().log().body();
		 System.err.println(sw.toString()); 
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 
		 System.err.println(ressw.toString()); 
		System.out.println("Get Board Completed");
	}
}
