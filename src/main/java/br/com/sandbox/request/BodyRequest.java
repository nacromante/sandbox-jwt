package  br.com.sandbox.request;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import br.com.sandbox.exception.ServiceDownException;
import br.com.sandbox.model.Usuario;
import br.com.sandbox.security.dto.JwtAuthenticationDto;

@Component
public class BodyRequest {

	
	@Autowired
	PushRequestService androidPushNotificationsService;
 
	public ResponseEntity<String> send(Usuario user){
		try {
		JSONObject body = new JSONObject();
		
		body.put("username", user.getEmail());
		body.put("password", user.getSenha());
		body.put("app_id", "APP_MEDICOS_GERAL");
 
 
		HttpEntity<String> request = new HttpEntity<>(body.toString());
 
		ResponseEntity<String> out = androidPushNotificationsService.send(request);
		
//		CompletableFuture.allOf(pushNotification).join();
// 
//			String firebaseResponse = pushNotification.get();
			System.out.println("ENVIO COM SUCESSO BODY >>>>>>>>>>>>>>>>>>>>>>>>>>"+out.getBody());
			System.out.println("ENVIO COM SUCESSO status >>>>>>>>>>>>>>>>>>>>>>>>>>"+out.getStatusCodeValue());
//			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		return out;
		} catch (JSONException e) {
			throw new ServiceDownException("Service API autentication not found");
		} 
 
	}
	
}
