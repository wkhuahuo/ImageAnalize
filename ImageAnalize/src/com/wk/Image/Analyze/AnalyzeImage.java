package com.wk.Image.Analyze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
public class AnalyzeImage {
	public static void main(String[] args) 
    {
        HttpClient httpclient = HttpClients.createDefault();

        try
        {
       //     URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/vision/v1.0/analyze");
        	URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/vision/v1.0/describe");
       // 	URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/vision/v1.0/generateThumbnail");
            builder.setParameter("visualFeatures", "Categories");

            builder.setParameter("language", "en");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
       //     request.setHeader("Ocp-Apim-Subscription-Key", "d13e2d7ca1664dc39f27c43b5023ecb4");
            request.setHeader("Ocp-Apim-Subscription-Key", "d13e2d7ca1664dc39f27c43b5023ecb4");

            // Request body
            StringEntity reqEntity = new StringEntity("{\"url\":\"https://portalstoragewuprod.blob.core.chinacloudapi.cn/vision/Analysis/1-1.jpg\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
   
}
