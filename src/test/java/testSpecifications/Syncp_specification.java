package testSpecifications;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojopack.Createuserpayload;
import pojopack.Pojopayload;
import utilities.API_Enum;
import utilities.utils;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class Syncp_specification {
	
	
	static RequestSpecification requestSpec;
	static Response  responseSpec;
	API_Enum resourceAPI;
	static String usernamefromresponse;
	
	Createuserpayload userpayload=new Createuserpayload();
	
	
	@Given("^user details payload with username \"([^\"]*)\"$")
    public void userDetailsPayloadWithUsernameSomething(String username) throws Throwable {
	    
		requestSpec=given().spec(utils.requestSpecification()).body(userpayload.AdminuserCreationpayload(username, "sarathnewcompany")).header("User-Agent", "Syncplicity Sdk Client 4.0.0 (Sdk 4)").contentType("application/Json");
		
	}
	
	 @Then("^extract the username and validate the same$")
	    public void extractTheUsernameAndValidateTheSame() throws Throwable {
		 
		  usernamefromresponse = utils.getjsonvaluesFromXML(responseSpec, "ArrayOfCompany.Company.Owner.EmailAddress");
		  System.out.println(usernamefromresponse);
		  
	        
	    }
	

	
	@Given("Add syncpoint payload with basic authentication with different syncpoint names {string} {string}")
	public void add_syncpoint_payload_with_basic_authentication_with_different_syncpoint_names(String Name, String Type) throws IOException {
		
		requestSpec=given().spec(utils.requestSpecification()).auth().basic(usernamefromresponse, "t3stP@ss").contentType("application/json")
		.body(Pojopayload.realpayload());
		

	}

	@When("{string} call we use {string} http method to create a syncpoints")
	public void call_we_use_http_method_to_create_a_syncpoints(String resource, String httpmethod) {
		
		
		
		resourceAPI=API_Enum.valueOf(resource);
		
		if(httpmethod.equalsIgnoreCase("POST")) {
			
			responseSpec = requestSpec.when().post(resourceAPI.getresoruce());	
		}
		
		else if (httpmethod.equalsIgnoreCase("GET")) {
			
			responseSpec=requestSpec.when().get(resourceAPI.getresoruce());	
		}  
		
	}
	
	
	@Then("validate the status code as {string}")
	public void validate_the_status_code_as(String expectedcode) {
		
		//System.out.println("1test");
		assertEquals(String.valueOf(responseSpec.getStatusCode()), expectedcode);    
				
	}
	
	
	@Then("validate the response body for the syncpointId")
	public void validate_the_response_body_for_the_syncpoint_id() {
		
		String syncpointid = utils.getjsonvaluesFromXML(responseSpec, "ArrayOfSyncPoint.SyncPoint.Id");
		
		System.out.println(syncpointid);
	    
	}




	
}
