import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Test3 { //Success, Finished With 3

	

	@Before
	public void setUp() {
		RestAssured.baseURI = "https://reqres.in/";
	}
	
	/*
	 * The HTTP 204 No Content success status response code indicates that a request
	 * has succeeded, but that the client doesn't need to navigate away from its
	 * current page.
	 */
	@Test
	public void responseCodeOf204() {

		JSONObject request = new JSONObject();
        given()
                .body(request.toJSONString())
                .when().delete("https://reqres.in/api/users/2").then()
                .statusCode(204).log();
	}
}
