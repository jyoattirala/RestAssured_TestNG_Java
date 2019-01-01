package com.reqres;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Payload;
import utils.Resources;
import utils.TestConfig;

public class PutRequests extends TestConfig {

	@Test
	public void verifyUpdateUserDetails() {
		try {
			given().header("Content-Type", "application/json").body(Payload.getUserDetailsWithName()).when()
					.put(Resources.getUser2EndPoint()).then().statusCode(200).log().all();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}
	}

}
