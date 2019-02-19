package br.com.sandbox.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 306411570471828345L;

	private Long id;
	private String email;
	private String senha;
	private PerfilEnum perfil;

	public Usuario() {
	}

	

}
