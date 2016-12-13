package com.wk.Image.Tag;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;

public class RequestHeader {
	public static  HttpPost getHeader(String str){
		 URIBuilder builder = null;
		 URI uri = null;
		 HttpPost request = null;
		try {
			builder = new URIBuilder(str);
			uri = builder.build();
			request = new HttpPost(uri);
	        request.setHeader("Content-Type", "application/json");
	        request.setHeader("Ocp-Apim-Subscription-Key", "d13e2d7ca1664dc39f27c43b5023ecb4");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;
	}
}
