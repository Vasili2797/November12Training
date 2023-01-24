
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JUnitTestClass {
	private String index = "https://reqres.in";

	@Before
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
	}

	@Test
	public void getSingleUser_test_1() {

		Response response = RestAssured.get("https://reqres.in/api/users/2");

		response.then().statusCode(200).body("data.id", equalTo(2)).body("data.email",
				equalTo("janet.weaver@reqres.in"));
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);
	}

	@Test
	public void verifiesTokenReturnValue() {
		
		 JSONObject request = new JSONObject();
		 request.put("email", "eve.holt@reqres.in");
		 request.put("password", "cityslicka");

	        given()
	                .contentType(ContentType.JSON)
	                .body(request.toString())
	                .when()
	                .post("/api/login")
	                .then()
	                .statusCode(200)
	                .body("token", is("QpwL5tke4Pnpja7X4"));

	        assertEquals(200, given()
	                .contentType(ContentType.JSON)
	                .body(request.toString())
	                .when()
	                .post("/api/login").then()
	                .extract().statusCode());
	}

	@Test
	public void responseCodeOf204_test_3() {
		JSONObject request = new JSONObject();
        
        assertEquals(given()
                .body(request.toJSONString())
                .when().delete("https://reqres.in/api/users/2").then()
                .extract().statusCode(), 204);
	}

	@Test
	public void patchResult_test_4() {
		JSONObject request = new JSONObject();
		request.put("name", "morpheus2");

		Response response = RestAssured.given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(request.toJSONString()).when().patch("api/users/2");
		
		String responseTime = response.then().extract().path("updatedAt");
		String nameChanged = response.then().extract().path("name");
		long timeItTook = response.getTime();
		
		assertEquals("morpheus2", nameChanged, "The name should be morpheus2");
	}

	@Test
	public void putMorpheus2_test_5() {
		JSONObject request = new JSONObject();
		request.put("name", "morpheus2");

		Response response = RestAssured.given().header("Content-Type", "application/json").contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(request.toJSONString()).when().patch("api/users/2");// .then().statusCode(200).log().body();

		String responseTime = response.then().extract().path("updatedAt");
		String nameChanged = response.then().extract().path("name");

		assertEquals("morpheus2", nameChanged, "The name should be morpheus2");
	}

	@Test
	public void test6() {
		var route = "/api/users/2";

		var expectedCode = 200;

		var expectedID = 2;
		var expectedEmail = "janet.weaver@reqres.in";
		var expectedFirstName = "Janet";
		var expectedLastName = "Weaver";
		var expectedAvatar = "https://reqres.in/img/faces/2-image.jpg";

		var expectedURL = "https://reqres.in/#support-heading";
		var expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";

		Response response = RestAssured.given().baseUri(index).contentType("application/json").when().get(route).then()
				.statusCode(expectedCode).extract().response();

		User user = response.as(User.class);

		assertEquals(user.getData().getId(), expectedID, "id expected");
		assertEquals(user.getData().getEmail(), expectedEmail, "email expected");
		assertEquals(user.getData().getFirst_name(), expectedFirstName, "first name expected");
		assertEquals(user.getData().getLast_name(), expectedLastName, "last name expected");
		assertEquals(user.getData().getAvatar(), expectedAvatar, "avatar expected");

		assertEquals(user.getSupport().getURL(), expectedURL, "url expected");
		assertEquals(user.getSupport().getText(), expectedText, "text expected");
	}

	@Test
	public void test7() {
		var route = "/api/users?page=2";
		var expectedCode = 200;

		var expectedPage = 2;
		var expectedPerPage = 6;
		var expectedTotal = 12;
		var expectedTotalPages = 2;
		var expectedURL = "https://reqres.in/#support-heading";
		var expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";

		Response response = RestAssured.given().baseUri(index).contentType("application/json").when().get(route).then()
				.statusCode(expectedCode).extract().response();

		UserList userList = response.as(UserList.class);

		assertEquals(userList.getPage(), expectedPage, "page expected");
		assertEquals(userList.getPer_page(), expectedPerPage, "per page expected");
		assertEquals(userList.getTotal(), expectedTotal, "total expected");
		assertEquals(userList.getTotal_pages(), expectedTotalPages, "total pages expected");

		assertEquals(userList.getSupport().getURL(), expectedURL, "url expected");
		assertEquals(userList.getSupport().getText(), expectedText, "text expected");
	}
}
