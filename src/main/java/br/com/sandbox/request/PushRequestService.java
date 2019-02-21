package  br.com.sandbox.request;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*import hsd.firebase.interceptors.HeaderRequestInterceptor;*/

@Service
public class PushRequestService {

//	private static final String API_URL = "http://192.168.3.147:5001/api/login";
	private static final String API_URL = "http://localhost:3000/api/login";
	
	@Async
	public ResponseEntity<String> send(HttpEntity<String> entity) {
		RestTemplate restTemplate = new RestTemplate();
 
		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors. add(new HeaderRequestInterceptor("Accept", "application/json"));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json;charset=utf-8"));
		restTemplate.setInterceptors(interceptors);
 
//		String firebaseResponse = restTemplate.postForObject(API_URL, entity, String.class);
		ResponseEntity<String> out = restTemplate.exchange(API_URL, HttpMethod.POST, entity, String.class);
//		return CompletableFuture.completedFuture(firebaseResponse);
		return out;
	}
	
}
