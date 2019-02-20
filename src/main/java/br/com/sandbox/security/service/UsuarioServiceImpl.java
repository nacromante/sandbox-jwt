package br.com.sandbox.security.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sandbox.model.PerfilEnum;
import br.com.sandbox.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	public Optional<Usuario> buscarPorEmail(String email) {
		String pwdEncode = new BCryptPasswordEncoder().encode("1234");
		Usuario usuario = new Usuario(1L, "fred@gmail.com",pwdEncode , PerfilEnum.ROLE_ADMIN);
		if(email.equals(usuario.getEmail()))
			return Optional.ofNullable(usuario);
		return Optional.ofNullable(null);
	}
}
