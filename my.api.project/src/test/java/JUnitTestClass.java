/*
 * API descriptions are on this page:
https://reqres.in/

Using RestAssured ...
1. (GET single user) Write a test that verifies the email address for employee id 2 is 'janet.weaver@reqres.in' 

2. (POST login - succesful) Write a test that verifies the token return value.

3. (DELETE) 
a. Write a test that verifies the response code of 204. 
b. Lookup response code 204 and add it to your test as a comment.

4. (PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

5. (PUT) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

6. (GET single user). Deserialize the user data into an object.

7. (GET list users). Deserialize the user data into a collection of objects.

Use REST Assured to deserialize data.
Use Junit as the test framework.
 * 
 * */

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.hamcrest.Matcher;
import org.json.simple.JSONObject;

public class JUnitTestClass {

//	1. (GET single user) Write a test that verifies the email address for employee id 2 is 'janet.weaver@reqres.in' 

	@Test
	public void test_1() { // This test passes

		given().get("https://reqres.in/api/users/2").then().statusCode(200).body("data.id", equalTo(2))
				.body("data.email", equalTo("janet.weaver@reqres.in"));

	}

//	2. (POST login - succesful) Write a test that verifies the token return value.
	@Test
	public void verifiesTokenReturnValue() {

		var baseURL = "https://reqres.in/";
		Response response = RestAssured.post(baseURL + "api/login");
//		response.prettyPrint();
//		Response response2 = RestAssured.get("");

		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");
		System.out.println(request.toJSONString());
//		
		get("https://reqres.in/api/login").then().contentType(ContentType.ANY).equals("QpwL5tke4Pnpja7X4");
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("/users").then();
	}

	/*
	 * The HTTP 204 No Content success status response code indicates that a request
	 * has succeeded, but that the client doesn't need to navigate away from its
	 * current page.
	 */

	@Test
	public void responseCodeOf204() {

//		JSONObject request = new JSONObject();
//		request.put("name", "John");
//		request.put("job", "Programmer");
//		baseURI = "https://reqres.in/api";
//		
//		given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString())
//		.when().post("/users").then().statusCode(DEFAULT_PORT).log().all();

		var baseURL = "https://reqres.in/";
		Response response = RestAssured.get(baseURL + "api/users/2");
		given().get(baseURL + "api/users/2").then().statusCode(204);
	}

//	(PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.
	@Test
	public void patchResult() {// This functions

		JSONObject request = new JSONObject();
		request.put("name", "morpheus2");

		baseURI = "https://reqres.in/";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("api/users/2").then().statusCode(200).log().all();
	}

//	(PUT) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

	@Test
	public void putMorpheus2() {
		String requestBody = "{\n" +
	            "  \"title\": \"foo\",\n" +
	            "  \"body\": \"baz\",\n" +
	            "  \"userId\": \"1\",\n" +
	            "  \"id\": \"1\" \n}";
		Response response = given().header("Content-Type","application/json")
				.and().body(requestBody).when().put("").then().extract().response();
		System.out.println(response);
	}

}
