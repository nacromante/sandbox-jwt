package br.com.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class SandboxJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxJwtApplication.class, args);
	}
	
	
//	 @Bean
//	 public static NoOpPasswordEncoder passwordEncoder() {
//	  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	 }

}
