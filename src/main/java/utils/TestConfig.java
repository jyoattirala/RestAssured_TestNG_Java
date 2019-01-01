package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class TestConfig {

	Properties prop = new Properties();

	@BeforeMethod

	public void preCondition() throws IOException {
		// BaseURL or Host
		FileInputStream fis = new FileInputStream("./src/main/resources/config.properties");
		prop.load(fis);
		RestAssured.baseURI = prop.getProperty("HOST");
	}

}
