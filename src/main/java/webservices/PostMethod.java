package webservices;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojoclasses.request.Request;
import pojoclasses.response.Response;
import test.CreateRequestBuilder;


public class PostMethod {
	
	
public static Response createSubTask(String id) throws JsonProcessingException {
		
	String APIKey = "twp_SDZ6AUr388xggL8m3etJyGpLyq3r";
    String TeamworkURL = "https://edgetest.teamwork.com";
    String action = "/tasks/" + id + ".json";       

    Request obj = CreateRequestBuilder.buildRequest();
    String json = new ObjectMapper().writeValueAsString(obj); 
    System.out.println(json);
    
    Response response = null;
         
    try {
    	
    	System.out.println();
        URL url = new URL( TeamworkURL + action );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
             
        String userpassword = APIKey + ":xxx";
        String encodedAuthorization = Base64Coder.encodeString( userpassword );
             
        connection.setRequestProperty("Authorization", "BASIC "
                    + encodedAuthorization);
 
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(json);
        osw.flush();
        osw.close();
 
        if (connection.getResponseCode() != 201) {
        /* error  */
        System.out.println(connection.getResponseCode());
        System.out.println( streamToString(connection.getErrorStream()) );
        }
 
        InputStream responseStream = connection.getInputStream();
        System.out.println( streamToString(responseStream) );
        response = new ObjectMapper().readValue(streamToString(responseStream), Response.class);
  
    } catch(Exception e) {
        System.out.println( "Error Received:" + e.getMessage() );
    }
    
    return response;
  }
     
  public static String streamToString(InputStream in) throws IOException {
    StringBuilder out = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    for(String line = br.readLine(); line != null; line = br.readLine()) 
    out.append(line);
    br.close();
    return out.toString();
  }
}