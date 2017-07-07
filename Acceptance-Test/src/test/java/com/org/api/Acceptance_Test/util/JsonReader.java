package com.org.api.Acceptance_Test.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class JsonReader {
	public static JSONObject obj=new JSONObject();
	@SuppressWarnings("deprecation")
	public static JSONObject parseJson(String fileName){
		JSONParser parser=new JSONParser();
		try {
			FileReader file=new FileReader("C:\\Users\\LENOVO\\RESTapiSID\\Acceptance-Test\\src\\test\\resources\\Requests\\"+fileName+".json");
			obj =(JSONObject) parser.parse(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public static JSONObject setRequestField(String fieldName,String fieldValue){
		obj.put(fieldName, fieldValue);
		return obj;
	}
}
