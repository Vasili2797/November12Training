import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.File;
import java.io.IOException;

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

        Response response = 
                RestAssured.given().
                    baseUri(index).
                    contentType("application/json").
                when().
                    get(route).
                then().
                    statusCode(expectedCode).
                extract().
                    response();

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