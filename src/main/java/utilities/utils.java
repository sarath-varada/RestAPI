package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.json.JSONObject;
import org.json.XML;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class utils {
	
	static Properties prop;
	static RequestSpecification request;
	static ResponseSpecification response;
	
	
	
	
	
	public static Properties loadproperties() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\EclipseWorkSpace\\MyNewAPI_Project\\src\\main\\java\\cofiguration\\config.properties");
		prop.load(fis);
		return prop;
	}
	
	
	public static RequestSpecification requestSpecification() throws IOException {
		
		
		FileOutputStream fis=new FileOutputStream("logging.txt");
		
		PrintStream log=new PrintStream(fis);
		
		request=new RequestSpecBuilder().setBaseUri(utils.loadproperties().getProperty("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return request;
	}
	
	public static ResponseSpecification responseSpecification() {
		
		response=new ResponseSpecBuilder().expectStatusCode(200).build();
		return response;
	}
	
	public static String jsonparse(String resp, String key) {
		
		JsonPath js=new JsonPath(resp);
		String value=js.get(key);
		
		return value;
		
		
	}
	
	
	public static String getjsonvaluesFromXML(Response response, String key) {
		
		JSONObject js = XML.toJSONObject(response.asString());
		JsonPath json=new JsonPath(js.toString());
	     return json.getString(key);	
	}

}
