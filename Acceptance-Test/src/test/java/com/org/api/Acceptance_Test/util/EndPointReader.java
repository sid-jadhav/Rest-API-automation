package com.org.api.Acceptance_Test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.jayway.restassured.RestAssured;
import com.org.api.Acceptance_Test.RestAssuredConfiguration;

public class EndPointReader {

	public static void main(String[] args) {
		configEndPoint("VerifyCard");
	}
	//This method reads the data file and configure the URI
	public static RestAssuredConfiguration configEndPoint(String APIName){
		String method=search(APIName+".method");
		String BaseURI=search(APIName+".BaseURI");
		String port=search(APIName+".port");
		String basePath=search(APIName+".basePath");
		RestAssuredConfiguration rest=new RestAssuredConfiguration(BaseURI,port,basePath);
		System.out.println(RestAssured.baseURI);
		System.out.println(RestAssured.port);
		System.out.println(RestAssured.basePath);
		return rest;
	}
	public static String search(String BasePath){
//		String BasePath="VerifyCard.BasePath";
		File file= new File("EndPointProperties.txt");
		FileReader in;
		String find=new String();
		try {
			in = new FileReader(file);
			BufferedReader br= new BufferedReader(in);
			find=br.readLine();
			while(!find.contains(BasePath)){
				find=br.readLine();
			}
//			System.out.println(find);
//			System.out.println(find.substring(BasePath.length()+1, find.length()));
			return find.substring(BasePath.length()+1, find.length());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return find.substring(BasePath.length()+1, find.length());
	}

}
