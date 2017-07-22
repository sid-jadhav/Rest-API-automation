package com.org.api.Acceptance_Test.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import net.minidev.json.JSONObject;

public class writeToWord {
	public static JSONObject obj=new JSONObject();
	public static void write(){
		try{
			int j=0;
			FileOutputStream fout=new FileOutputStream("Sid1.docx");
			XWPFDocument doc =new XWPFDocument();
			XWPFParagraph para= doc.createParagraph();
			para.setAlignment(ParagraphAlignment.LEFT);
			XWPFRun paraRun=para.createRun();
			String s=obj.toString();
			for(int i=0;i<s.length()-1;i++){
				while(s.charAt(i)!=',' && i!=s.length()-1){
					i++;
				}
				paraRun.setTextPosition(i);
				System.out.println(s.substring(j, i));
				paraRun.setText(s.substring(j, i)+"\n");
				paraRun.addCarriageReturn();
				j=i+1;
			}
			doc.write(fout);
			fout.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		
		obj=JsonReader.parseJson("Test");
		write();
	}
	
}
