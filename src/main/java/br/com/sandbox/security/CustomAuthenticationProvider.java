package br.com.sandbox.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import br.com.sandbox.model.PerfilEnum;
import br.com.sandbox.model.Usuario;
import br.com.sandbox.request.BodyRequest;

@Component
public class CustomAuthenticationProvider
  /*implements AuthenticationProvider */{
	
	@Autowired
	private BodyRequest bodyRequest;
	
 
//    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Usuario user = new Usuario(null, name, password, PerfilEnum.ROLE_ADMIN);
        ResponseEntity<String> out = bodyRequest.send(user); 
        List<GrantedAuthority> auts = new ArrayList<>();
        GrantedAuthority grand = new SimpleGrantedAuthority(PerfilEnum.ROLE_ADMIN.toString());
        auts.add(grand);
        if (HttpStatus.OK.equals(out.getStatusCode())) {
            // use the credentials
            // and authenticate against the third-party system
        	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("fred@gmail.com", "1234", auts);
//        	auth.setAuthenticated(true);
            return auth;
        } else {
            return null;
        }
    }
 
//    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}