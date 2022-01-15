package testdemo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_POST {

	@Test
	public void test_1_post() {


		JSONObject request = new JSONObject();
		request.put("name", "HelloWorld");
		request.put("job", "Teacher");

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		
		when().
		post("https://reqres.in/api/users").
		
		then().
		statusCode(201)
		.log().all(); 

	}




}
