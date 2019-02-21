package br.com.sandbox.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sandbox.model.PerfilEnum;
import br.com.sandbox.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	//
	public Optional<Usuario> buscarPorEmail(String email) {
//		String passEncode = new BCryptPasswordEncoder().encode("155");
		Usuario usuario = new Usuario(1L, email, null, PerfilEnum.ROLE_ADMIN);
		
		
		
//		String passEncode = new BCryptPasswordEncoder().encode(user.getSenha());
//		Usuario usuario = new Usuario(1L, user.getEmail(), passEncode, PerfilEnum.ROLE_ADMIN);
		return Optional.ofNullable(usuario);
	}
}
