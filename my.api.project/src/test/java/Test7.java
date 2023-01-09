import static org.testng.Assert.assertEquals;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test7 {
	private String index = "https://reqres.in";

	@Test
	public void canDeserializeUsers() {
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
