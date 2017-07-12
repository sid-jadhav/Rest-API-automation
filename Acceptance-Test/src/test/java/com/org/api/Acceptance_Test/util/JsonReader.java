package com.org.api.Acceptance_Test.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonReader {
	public static JSONObject obj=new JSONObject();
	//This method will return object of json that we have to send in the request
	@SuppressWarnings("deprecation")
	public static JSONObject parseJson(String fileName){
		JSONParser parser=new JSONParser();
		try {
			FileReader file=new FileReader("C:\\Users\\LENOVO\\git\\Rest-API-Automation\\Acceptance-Test\\src\\test\\resources\\Requests\\"+fileName+".json");
			obj =(JSONObject) parser.parse(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
	//This method will set the fields of the json
	public static JSONObject setRequestField(String fieldName,String fieldValue){
		obj.put(fieldName, fieldValue);
		return obj;
	}
//	public static void main(String[] args){
//		JSONObject obj= parseJson("VerifyCardRequest");
//	}
}
