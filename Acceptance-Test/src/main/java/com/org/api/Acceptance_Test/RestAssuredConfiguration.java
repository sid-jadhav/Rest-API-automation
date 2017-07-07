package com.org.api.Acceptance_Test;

import java.util.logging.Logger;

import com.jayway.restassured.RestAssured;
import com.org.api.Acceptance_Test.StepDefinations.GetMethod;

import cucumber.api.java.Before;


public class RestAssuredConfiguration {
	private final static Logger LOGGER = Logger.getLogger(RestAssuredConfiguration.class.getName());
	public void Configure(){
		LOGGER.info(getClass().getName()+ " Configure");
		RestAssured.baseURI="http://localhost";
		RestAssured.port=3000;
		RestAssured.basePath="/posts";
	}
	public RestAssuredConfiguration(String baseURI,String port,String basePath){
		LOGGER.info(getClass().getName()+ " Configure");
		RestAssured.baseURI=baseURI;
		RestAssured.port=Integer.parseInt(port);;
		RestAssured.basePath=basePath;
	}
}
