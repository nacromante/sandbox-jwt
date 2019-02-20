package br.com.sandbox.security.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sandbox.model.PerfilEnum;
import br.com.sandbox.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	public Optional<Usuario> buscarPorEmail(String email) {
		String passEncode = new BCryptPasswordEncoder().encode("1234");
		Usuario usuario = new Usuario(1L, "fred@gmail.com", passEncode, PerfilEnum.ROLE_ADMIN);
		return Optional.ofNullable(usuario);
	}
}
