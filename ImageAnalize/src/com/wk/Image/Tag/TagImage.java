package com.wk.Image.Tag;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

	
public class TagImage {
	
    public static void main(String[] args) 
    {
        HttpClient httpclient = HttpClients.createDefault();
        try
        {
        	String tagImgUri = "https://api.projectoxford.ai/vision/v1.0/tag";
        	HttpPost request = RequestHeader.getHeader(tagImgUri);
            // Request body
        	// String imgURL = "{\"url\":\"http://image.tianjimedia.com/uploadImages/2015/194/31/0HIE0OVD9FSI.jpg\"}" ;//bizhi
        	
        		String imgURL = "{\"url\":\"http://imga1.pic21.com/bizhi/131129/04564/s10.jpg\"}" ;//成功,雪
        	//	String imgURL = "{\"url\":\"http://imga1.pic21.com/bizhi/131118/04004/s01.jpg\"}" ;//成功,花
        	//	String imgURL = "{\"url\":\"http://pic.58pic.com/58pic/15/23/95/48P58PICVrF_1024.jpg\"}" ;//鱼
        	//	String imgURL = "{\"url\":\"http://m2.quanjing.com/2m/nature008/nature1336052.jpg\"}";//鸟
        	
        	
            StringEntity reqEntity = new StringEntity(imgURL);
            request.setEntity(reqEntity);
            
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
            	 //内容类型  
                System.out.println(entity.getContentType());  
               
                String content = EntityUtils.toString(entity);//获取微软API返回的内容
         //       System.out.println("content: "+content);
                Analyze  analyze= new Analyze();//分析内容
                String poem = analyze.returnPoem(content);
                System.out.println(poem);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("main ERROR");
        }
    }

	
}
