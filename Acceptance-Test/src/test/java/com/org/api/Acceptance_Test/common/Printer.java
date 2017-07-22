package com.org.api.Acceptance_Test.common;

import com.jayway.restassured.RestAssured;

import gherkin.formatter.model.Scenario;

public class Printer<D> {
	public void WriteRequest(String resqName){
		System.out.println("***************"+resqName+"***************");
		System.out.println(RestAssured.baseURI+RestAssured.port+RestAssured.basePath);
	}
	public <D> void WriteResponse(D resp){
		System.out.println(resp);
	}
}
