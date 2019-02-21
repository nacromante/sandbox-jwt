package  br.com.sandbox.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.sandbox.model.Usuario;

@Component
public class BodyRequest {

	
	
	private static final String API_URL = "http://192.168.3.147:5001/api/login";
//	private static final String API_URL = "http://localhost:3001/api/login";
 
	public ResponseEntity<String> send(Usuario user){
		try {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(API_URL);

		
		httppost.addHeader(new BasicHeader(
				  "Accept", "application/json"));
		httppost.addHeader(new BasicHeader(
				  "Content-Type", "application/json;charset=utf-8"));

		httppost.setEntity(new StringEntity("{\r\n" + 
				"  \"username\": \"" + user.getEmail() + "\"," + 
				"  \"password\": \"" + user.getSenha() + "\"," + 
				"  \"app_id\": \"APP_MEDICOS_GERAL\"\r\n" + 
				"}"));
		
		HttpResponse response = httpclient.execute(httppost);
		String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
		if(response.getStatusLine().getStatusCode() == 200) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		if(response.getStatusLine().getStatusCode() == 400 || response.getStatusLine().getStatusCode() == 401) {
			 return new ResponseEntity<String>(responseString, HttpStatus.UNAUTHORIZED);
		}
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED); 
 
	}
	
}
