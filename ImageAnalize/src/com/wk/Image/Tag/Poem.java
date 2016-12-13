package com.wk.Image.Tag;

import java.util.HashMap;
import java.util.Map;

public class Poem {
	
	public Poem(String str){
		String[] s = str.split("#");
		for(String temp :s){
			if(temp.trim().length() ==0) continue;
			String[] strs = temp.split("_");
			if(strs.length ==2){
				poems.put(strs[1], strs[0]);
			}
		}
	}
	private Map<String,String> poems = new HashMap<>();

	public void put(String sentence,String confidence){
		poems.put(sentence, confidence);
	}
	public Map<String,String> getPoems(){
		return this.poems;
	}
	
	
	
}
