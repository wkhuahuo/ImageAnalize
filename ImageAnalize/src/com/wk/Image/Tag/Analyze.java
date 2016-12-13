package com.wk.Image.Tag;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.wk.Image.Analyze.Translate.Translate;
import com.wk.Image.DataBase.FileDataBase;
import com.wk.Image.Tag.json.BaiduTrans;
import com.wk.Image.Tag.json.ConvertJsonToClass;
import com.wk.Image.Tag.json.ImageKey;
import com.wk.Image.Tag.json.ImageKeys;
import com.wk.Image.Tag.json.TransResult;

public class Analyze {
	
	static String MagicStr = "千山鸟飞绝，万径人踪灭。孤舟说笠翁，独钓寒江雪。";
	public  String returnPoem(String content){		
        
		System.out.println(content);
		
	    Map<String,String> zhTags =new HashMap<String, String>();//存储键值对
	    zhTags = getzhTagMap(content);
	    for(String str : zhTags.keySet()){
	    	System.out.println("Result key: "+str+" value:"+zhTags.get(str));
	    }
	    String poem = analyze(zhTags);
	  
		return poem;
	}
	
	private String analyze(Map<String, String> zhTags) {//分析算法得到最匹配诗句

		Map<String,Poem> poemMap = readFromDataBase();
		Map<String,String> resultMap = new HashMap<>();
		try{
		for(String key : zhTags.keySet()){
			Poem tmpPoem = poemMap.get(key);
			if(tmpPoem !=null){
				resultMap.putAll( tmpPoem.getPoems());
			}
		}}catch(Exception e){
			System.out.println("tmpPoem 为空");
			e.printStackTrace();
		}
		double maxConfidence =0.0;
		String maxpomContent ="对不起，无匹配";
		if(resultMap != null){
			for(String resultKey : resultMap.keySet()){
				Double tmp = Double.valueOf(resultMap.get(resultKey));
				if(tmp>maxConfidence){
					maxConfidence = tmp;
					maxpomContent = resultKey;
				}
			}
		}else{
			System.out.println("对不起，无匹配");
			
		}
		
		return maxpomContent;
	}

	private Map<String, Poem> readFromDataBase() {
		FileDataBase filedata = new FileDataBase();
		return filedata.initFileDataBase();
	}

	private Map<String, String> getzhTagMap(String content) {
		Map<String,String> enTags =new HashMap<String, String>();//存储键值对
		enTags = getenTagMap(content);
		Map<String,String> zhTags = transEnTags(enTags);
		return zhTags;
	}
	private Map<String, String> transEnTags(Map<String, String> enTags) {
		 Set<String> keys =  enTags.keySet();
		 Map<String, String> zhTags = new HashMap<>();
		 
		 String ci = new String();
		 for(String key: keys){
			 //enTags.remove(key);
			 ci = translateCi(key);
			 System.out.println("key: "+key+" ci: "+ci);
			 zhTags.put(ci, enTags.get(key));
		 }
		return zhTags;
	}
	public static Map<String,String> analyzeEntity(){
		
		
		return null;
		
		
	}
	
	
	
	private String translateCi(String json){
		Translate trans = new Translate();
		String result = trans.translateWord(json);
		
		System.out.println(result);
		
		BaiduTrans baiduTrans = ConvertJsonToClass.convertTransResultbyGson(result);
		List<TransResult> transResultList = baiduTrans.getTrans_result();
		
		StringBuffer strB = new StringBuffer();
		for(TransResult transResult : transResultList){
			strB.append(transResult.getDst());
		}
		 
		 return strB.toString();
	}
	private Map<String,String> getenTagMap(String json){
		////解析Json字符串：content
		Map<String,String> enTag = new HashMap<>();
		ImageKeys imgKeys = ConvertJsonToClass.convertbyGson(json);
		List<ImageKey> keyList = imgKeys.getKeyList();
		for(ImageKey key: keyList ){
			
			enTag.put(key.getName(), key.getConfidence());
		}
		return enTag;
		
	}
	
	
}
