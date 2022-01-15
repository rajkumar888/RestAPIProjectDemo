package testdemo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Tests_POST2 {

	@Test
	public void test_1_post() {


		JSONObject request = new JSONObject();
		request.put("firstname", "HelloWorld");
		request.put("lastname", "Teacher");
		request.put("totalprice", 4444);
		request.put("depositpaid", true);
//		request.put("bookingdates.checkin", "2022-02-03");
//		request.put("bookingdates.checkout", "2022-02-04");
		request.put("additionalneeds", "Breakfast");
			
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		
		when().
		post("https://restful-booker.herokuapp.com/booking").
		
		then().
		statusCode(201)
		.log().all(); 

	}




}
