import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class Test1 { // Success Finished With 1
//	1. (GET single user) Write a test that verifies the email address for employee id 2 is 'janet.weaver@reqres.in' 

	@Test
	public void test_1() { // This test passes

		Response response = RestAssured.get("https://reqres.in/api/users/2");

		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());

		response.then().statusCode(200).body("data.id", equalTo(2)).body("data.email",
				equalTo("janet.weaver@reqres.in"));
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 200);

	}
}
