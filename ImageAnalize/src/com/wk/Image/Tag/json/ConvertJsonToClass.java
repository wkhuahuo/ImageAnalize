package com.wk.Image.Tag.json;

import com.google.gson.Gson;

public class ConvertJsonToClass {
	public static ImageKeys convertbyGson(String str){
		System.out.println(str);
		Gson gson = new Gson();
        ImageKeys imgkeys = gson.fromJson(
                str, ImageKeys.class);
        return imgkeys;
	}
	public static BaiduTrans convertTransResultbyGson(String str){
		System.out.println(str);
		Gson gson = new Gson();
		BaiduTrans baiTrans = gson.fromJson(str, BaiduTrans.class);
		
		
		return baiTrans;
		
	}
}
