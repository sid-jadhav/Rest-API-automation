package com.org.api.Acceptance_Test.StepDefinations;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import java.util.logging.Logger;

import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.api.Acceptance_Test.RestAssuredConfiguration;
import com.org.api.Acceptance_Test.common.EndPoint;
import com.org.api.Acceptance_Test.common.Printer;
import com.org.api.Acceptance_Test.util.EndPointReader;
import com.org.api.Acceptance_Test.util.JsonReader;

import org.hamcrest.*;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import net.minidev.json.JSONObject;
public class GetMethod {
	Response resp;
	JsonReader json=new JsonReader();
	JSONObject jobj= new JSONObject();
	private final static Logger LOGGER = Logger.getLogger(GetMethod.class.getName());
	Printer print=new Printer();
	@Before
	public void init(){
		LOGGER.info("init function started");
	}
	
	@Given("^A request for \"([^\"]*)\"$")
	public void a_request_for(String resqName) throws Throwable {
		LOGGER.info("The Acceptance test starte "+resqName+" API");
		print.WriteRequest(resqName);
		
	}

	@SuppressWarnings("deprecation")
	@When("^\"([^\"]*)\" is called$")
	public void is_called(String Endp) throws Throwable {
		resp=when().get(EndPoint.GetEndPoint);
		print.WriteResponse(resp.asString());
		Assert.assertEquals(200, resp.getStatusCode());
	}

	@SuppressWarnings("deprecation")
	@Then("^response feild \"([^\"]*)\" is \"([^\"]*)\"$")
	public void response_feild_is(String fieldName, String fieldValue) throws Throwable {
	    Assert.assertEquals(resp.path(fieldName),fieldValue);
	}
	//This will read the json from the file
	@Given("^a maximal json for \"([^\"]*)\"$")
	public void a_maximal_json_for(String fileName){
		jobj=json.parseJson(fileName);
	}

	@Given("^request field \"([^\"]*)\" is \"([^\"]*)\"$")
	public void request_field_is(String fieldName, String fieldValue){
		jobj=json.setRequestField(fieldName, fieldValue);
		System.out.println(jobj.toString());
	}
	
	@When("^post \"([^\"]*)\" is called$")
	public void post_is_called(String Endp) {
		//This method sets the URI
		EndPointReader end=new EndPointReader();
		RestAssuredConfiguration config= end.configEndPoint(Endp);
		print.WriteRequest(Endp);
		resp=given().
				contentType(ContentType.JSON).body(jobj).
				when().post(EndPoint.GetEndPoint);
		print.WriteResponse(resp.asString());
		Assert.assertEquals(200, resp.getStatusCode());
	}
	
}
