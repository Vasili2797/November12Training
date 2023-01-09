import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;

public class Test2 {// connection refused
	@Before
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
	}

//2. (POST login - successful) Write a test that verifies the token return value.
	@Test
	public void verifiesTokenReturnValue() { //Success, Finished with 2
		
		 JSONObject request = new JSONObject();
		 request.put("email", "eve.holt@reqres.in");
		 request.put("password", "cityslicka");

	        given()
//	                .log().uri()
//	                .log().body()
	                .contentType(ContentType.JSON)
	                .body(request.toString())
	                .when()
	                .post("/api/login")
	                .then()
//	                .log().status()
//	                .log().body()
	                .statusCode(200)
	                .body("token", is("QpwL5tke4Pnpja7X4"));

	        assertEquals(200, given()
	                .contentType(ContentType.JSON)
	                .body(request.toString())
	                .when()
	                .post("/api/login").then()
	                .extract().statusCode());
	}

}
