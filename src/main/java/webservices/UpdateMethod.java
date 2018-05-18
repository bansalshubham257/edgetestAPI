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
import test.UpdateRequestBuilder;


public class UpdateMethod {
	
	
public static Response updateTask(String id) throws JsonProcessingException {
		
	HttpURLConnection connection = null;
    
	String APIKey = "twp_SDZ6AUr388xggL8m3etJyGpLyq3r";
    String TeamworkURL = "https://edgetest.teamwork.com";       
    
    Request obj = UpdateRequestBuilder.buildRequest();
    String json = new ObjectMapper().writeValueAsString(obj); 
    System.out.println(json);
    
    Response response = null;
    
    try {
        URL url = new URL( TeamworkURL + "/tasks/" + id + ".json" );
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
             
        String userpassword = APIKey + ":" + "";
        String encodedAuthorization = Base64Coder.encodeString( userpassword );
        connection.setRequestProperty("Authorization", "Basic "
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
             
        System.out.println( streamToString( responseStream) );
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