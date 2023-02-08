package br.com.evandroslk.springrestapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evandroslk.springrestapi.model.Usuario;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios() {

		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setLogin("usuario1@gmail.com");
		usuario.setNome("Usuário 1");
		usuario.setSenha("3333");

		Usuario usuario2 = new Usuario();
		usuario2.setId(2L);
		usuario2.setLogin("teste@gmail.com");
		usuario2.setNome("Teste Sistema");
		usuario2.setSenha("1010");

		List<Usuario> usuarios = Arrays.asList(usuario, usuario2);

		return new ResponseEntity<>(usuarios, HttpStatus.OK);

	}

}
