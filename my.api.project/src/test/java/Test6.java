import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class Test6 {

	private String index = "https://reqres.in";

	@Test
	public void CanDeserialize_Test_6() {
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
}