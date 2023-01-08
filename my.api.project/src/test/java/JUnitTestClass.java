
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.time.LocalDateTime;

import org.json.simple.JSONObject;

public class JUnitTestClass {

	@Before
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
	}

	@Test
	public void getSingleUser_test_1() { // This test passes

		Response response = RestAssured.get("https://reqres.in/api/users/2");
		response.then().statusCode(200).body("data.id", equalTo(2)).body("data.email",
				equalTo("janet.weaver@reqres.in"));
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);

	}

	@Test
	public void verifiesTokenReturnValue_test_2() { // Success, Finished with 2

		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");

		given().log().uri().log().body().contentType(ContentType.JSON).body(request.toString()).when()
				.post("/api/login").then().log().status().log().body().statusCode(200)
				.body("token", is("QpwL5tke4Pnpja7X4"));
	}

	/*
	 * The HTTP 204 No Content success status response code indicates that a request
	 * has succeeded, but that the client doesn't need to navigate away from its
	 * current page.
	 */
	@Test
	public void responseCodeOf204_test_3() {

		JSONObject request = new JSONObject();
		given().body(request.toJSONString()).when().delete("https://reqres.in/api/users/2").then().statusCode(204)
				.log();
	}

	@Test
	public void patchResult_test_4() {// This functions

		JSONObject request = new JSONObject();
		request.put("name", "morpheus2");
		Response response = RestAssured.given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(request.toJSONString()).when().patch("api/users/2");// .then().statusCode(200).log().body();

		request.values().stream().forEach(System.out::println);
		response.then().log().all();

		String responseTime = response.then().extract().path("updatedAt");
		String nameChanged = response.then().extract().path("name");
		long timeItTook = response.getTime();

//		System.out.println(timeItTook);

		System.out.println(responseTime);
//		System.out.println(nameChanged);
		System.out.println(java.time.LocalDateTime.now());

		assertEquals("morpheus2", nameChanged, "The name should be morpheus2"); // make sure the name was changed
//		assertEquals(responseTime, java.time.LocalDateTime.now());// make sure that the time is current
	}

	@Test
	public void putMorpheus2_test_5() {// connection refused problem.... Now this works... Difficulty with time
								// assertion

		JSONObject request = new JSONObject();
		request.put("name", "morpheus2");

		Response response = RestAssured.given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(request.toJSONString()).when().patch("api/users/2");// .then().statusCode(200).log().body();

		request.values().stream().forEach(System.out::println);

		response.then().log().body();

		String responseTime = response.then().extract().path("updatedAt");
		String nameChanged = response.then().extract().path("name");

//		responseTime.compareTo(nameChanged)
		System.out.println("ResponseTime " + responseTime);
//		int number = Integer.parseInt(responseTime);

		LocalDateTime time = java.time.LocalDateTime.now();
		assertEquals("morpheus2", nameChanged, "The name should be morpheus2"); // make sure the name was changed
//		Assert.assertTrue();// make sure that the time is current

	}

//	(GET single user). Deserialize the user data into an object.

	@Test
	public void deserializeDataIntoObject_test_6() throws JsonProcessingException {

		Response response = RestAssured.get("https://reqres.in/api/users/2");

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(response);
		System.out.println(jsonString);

	}
}
