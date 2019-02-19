package br.com.sandbox.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sandbox.model.PerfilEnum;
import br.com.sandbox.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	public Optional<Usuario> buscarPorEmail(String email) {
		Usuario usuario = new Usuario(1L, "fred@gmail.com", "1234", PerfilEnum.ROLE_ADMIN);
		return Optional.ofNullable(usuario);
	}
}
