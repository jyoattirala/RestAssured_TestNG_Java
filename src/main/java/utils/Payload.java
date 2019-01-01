package utils;

public class Payload {

	public static String getUserDetailsWithEmail() {
		String payLoad = "{" + "\"email\":" + " " + "\"sydney@fife\"," + "\"password\":" + " " + "\"pistol\"" + "}";
		return payLoad;
	}
	
	public static String getUserDetailsWithName() {
		String payLoad = "{" + "\"name\":" + " " + "\"morpheus\"," + "\"job\":" + " " + "\"leader\"" + "}";
		return payLoad;
	}

}
