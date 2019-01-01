package com.reqres;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import utils.Resources;
import utils.TestConfig;

public class GetRequests extends TestConfig {

	 @Test
	public void verifyListOfUserSuccessResponse() {
		try {
			given().when().get(Resources.getUsersPage2EndPoint()).then().assertThat().statusCode(200);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}
	}

	 @Test
	public void verifyListOfUsersJsonValues() {
		try {
			given().log().all().when().get(Resources.getUsersPage2EndPoint()).then().assertThat().statusCode(200).log().all()
					.and().contentType(ContentType.JSON).and().body("data[0].id", equalTo(4)).and()
					.body("data[0].first_name", equalTo("Eve")).and().body("data[0].last_name", equalTo("Holt"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}

	}

	 @Test
	public void verifyAllTheFirstNameValuesFromResponsePayload() {
		try {
			given().log().all().when().get(Resources.getUsersPage2EndPoint()).then().assertThat().statusCode(200).log().all()
					.and().contentType(ContentType.JSON).and()
					.body("data.first_name", hasItems("Eve", "Charles", "Tracey"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}
	}

	 @Test
	public void verifyAllTheLasNameValuesFromResponsePayload() {
		try {
			given().log().all().when().get(Resources.getUsersPage2EndPoint()).then().assertThat().statusCode(200).log().all()
					.and().contentType(ContentType.JSON).and()
					.body("data.last_name", hasItems("Holt", "Morris", "Ramos"));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}
	}

	 @Test
	public void verifyResponseHeaderValue() {
		try {
			Response res = given().log().all().when().get(Resources.getUsersPage2EndPoint()).then().assertThat()
					.header("X-Powered-By", "Express").log().all().extract().response();	
			// Get all the headers
			Headers allHeaders = res.headers();
			for (Header header : allHeaders) {
				Reporter.log("Key: " + header.getName() + " Value: " + header.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}
	}

}
