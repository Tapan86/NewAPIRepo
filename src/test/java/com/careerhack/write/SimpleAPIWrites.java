package com.careerhack.write;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class SimpleAPIWrites {
	
	@Test(enabled = false)
	public void simpleWrite() {
		
		Response resp = given().
				body("{\"id\":6, "
						+ "\"title\":\"SQL Basic\", "
						+ "\"author\":\"Rajib Miah\"}").
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");
		int sCode = resp.getStatusCode();
	System.out.println(sCode);	
	System.out.println(resp.asString());	
	}
	
	@Test
	public void patchTitle() {
		
		Response resp = given().
					body("{\"title\":\"SQL Advanced\"}").
				when().
					contentType(ContentType.JSON).
					patch("http://localhost:3000/posts/6");
		int sCode = resp.getStatusCode();
		System.out.println(sCode);	
		System.out.println(resp.asString());	
	}

}
