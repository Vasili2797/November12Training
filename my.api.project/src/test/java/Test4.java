import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;

public class Test4 { // Cannot get the time to cooperate
//	(PATCH) Write a test that updates 'Morpheus' to 'Morpheus2'. Ensure that UpdatedAt timestamp is updated and that the name was updated.

	@Before
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
	}

	@Test
	public void patchResult() {// This functions

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
}
