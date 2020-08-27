package com.careerhack.read;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class SimpleAPIReads {
	
	@Test(enabled=false)
	public void simpleGet() {
		
		Response resp = when().
				get("http://api.openweathermap.org/data/2.5/weather?q=Astoria&appid=ea683a6926611b7adaad247c0b1b4709");
		System.out.println(resp.asString());	
	}
	
	@Test(enabled=false)
	public void simpleGetParam() {
		
		Response resp = given().
				param("q","Astoria").
				param("appid","ea683a6926611b7adaad247c0b1b4709").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		int sCode = resp.getStatusCode();
		System.out.println("Status Code is: "+sCode);
		Assert.assertEquals(sCode, 200);
		System.out.println(resp.asString());	
	}
	
	@Test(enabled=true)
	public void simpleGetParamThen() {
		
				given().
					param("q","Astoria").
					param("appid","ea683a6926611b7adaad247c0b1b4709").
				when().
					get("http://api.openweathermap.org/data/2.5/weather").
				then().
					assertThat().statusCode(201);		
	}
	
	
	@Test(enabled=false)
	public void readDBJson() {
		Response resp = when().
				get("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}

}
