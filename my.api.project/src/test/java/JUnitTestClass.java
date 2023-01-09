
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
	public void getSingleUser_test_1() {
		Test1 newTest = new Test1();
		newTest.test_1();
	}

	@Test
	public void verifiesTokenReturnValue_test_2() {
		Test2 newTest = new Test2();
		newTest.setUp();
		newTest.verifiesTokenReturnValue();
	}

	@Test
	public void responseCodeOf204_test_3() {
		Test3 newTest = new Test3();
		newTest.setUp();
		newTest.responseCodeOf204();
	}

	@Test
	public void patchResult_test_4() {
		Test4 newTest = new Test4();
		newTest.setUp();
		newTest.patchResult();
	}

	@Test
	public void putMorpheus2_test_5() {
		test5 newTest = new test5();
		newTest.putMorpheus2();
	}

	@Test
	public void test6() {
		Test6 newTest = new Test6();
		newTest.CanDeserialize_Test_6();
	}

	@Test
	public void test7() {
		Test7 newTest = new Test7();
		newTest.canDeserializeUsers();
	}
}
