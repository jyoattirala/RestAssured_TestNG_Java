package com.reqres;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JsonUtil;
import utils.Payload;
import utils.Resources;
import utils.TestConfig;

public class PostRequests extends TestConfig {

	@Test
	public void verifyUsersRegistration() {
		try {
			given().header("Content-Type", "application/json").body(Payload.getUserDetailsWithEmail()).when()
					.post(Resources.getRegisterEndPoint()).then().statusCode(201).log().all();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}
	}

	@Test
	public void verifyUsersEntryAndResponseconsistId() {
		try {
			Response res = given().header("Content-Type", "application/json").body(Payload.getUserDetailsWithName())
					.when().post(Resources.getUserEntryEndPoint()).then().statusCode(201).log().all().extract()
					.response();
			JsonPath js = JsonUtil.rawToJson(res);
			String id = js.get("id");
			if (id.length() == 3) {
				Reporter.log("id generated");
			} else {
				Reporter.log("id length is not 3 digits");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown Test case failed :" + e.getMessage(), e);
		}

	}

}
