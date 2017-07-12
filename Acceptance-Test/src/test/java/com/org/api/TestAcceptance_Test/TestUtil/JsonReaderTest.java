package com.org.api.TestAcceptance_Test.TestUtil;

import org.junit.Assert;
import org.junit.Test;

import com.org.api.Acceptance_Test.util.JsonReader;

import net.minidev.json.JSONObject;

public class JsonReaderTest {
	@Test
	public void Test_ParseJson(){
		JSONObject obj=new JSONObject();
		obj=JsonReader.parseJson("Test");
		System.out.println(obj.toString());
		Assert.assertEquals(obj.getAsString("Id"), "11712");
		Assert.assertEquals(obj.getAsString("Name"), "Siddhesh");
		Assert.assertEquals(obj.getAsString("NetWorth"), "millions@2020");
	}
	@Test
	public void Test_setRequestField(){
		JSONObject obj=new JSONObject();
		obj=JsonReader.parseJson("Test");
		obj=JsonReader.setRequestField("NetWorth", "billions@2025");
		System.out.println(obj.toString());
		Assert.assertEquals(obj.getAsString("NetWorth"), "billions@2025");
	}
}
