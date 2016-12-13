package com.wk.Image.Analyze.Translate;

import java.io.UnsupportedEncodingException;

public class Translate {
	public String translateWord(String word){
		final String APP_ID = "20161210000033789";
		final String SECURITY_KEY = "7XwNrFj7BptvBQHaxr6k";
		TransApi transApi = new TransApi(APP_ID, SECURITY_KEY);
		
		String query = word;
		return  transApi.getTransResult(query, "en", "zh"); 
		
	}
	public static void baiduTranslate(String world){
		
		Translate trans = new Translate();
		String ci = trans.translateWord("swim");
		String hanzi = null;
		try {
			 hanzi = new String(ci.getBytes(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println(hanzi);
	}
}
