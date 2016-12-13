package com.wk.Image.Analyze;
// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)

//// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
	import java.net.URI;
	import org.apache.http.HttpEntity;
	import org.apache.http.HttpResponse;
	import org.apache.http.client.HttpClient;
	import org.apache.http.client.methods.HttpGet;
	import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
	import org.apache.http.util.EntityUtils;

public class ListDomainSpecificModels {

	
	
	    public static void main(String[] args) 
	    {
	        HttpClient httpclient = HttpClients.createDefault();

	        try
	        {
	            URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/vision/v1.0/models");


	            URI uri = builder.build();
	            HttpGet request = new HttpGet(uri);
	            request.setHeader("Ocp-Apim-Subscription-Key", "d13e2d7ca1664dc39f27c43b5023ecb4");


	            // Request body
	            StringEntity reqEntity = new StringEntity("{\"url\":\"https://tse3.mm.bing.net/th?id=OIP.M7032491d74cbbd164aeecd58f3b35caaH1&pid=Api\"}","UTF-8");
	        //    request.setEntity(reqEntity);
	            

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
