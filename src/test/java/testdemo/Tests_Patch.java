package testdemo;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Tests_Patch {

	@Test
	public void test_3_patch() {

		JSONObject request = new JSONObject();
		request.put("name", "Hello");
		request.put("job", "Teacher");


		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		
		when().
		patch("https://reqres.in/api/users/2").
		
		then().
		statusCode(200).
		log().all();
	}

}
