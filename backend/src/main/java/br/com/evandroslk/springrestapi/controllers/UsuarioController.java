package br.com.evandroslk.springrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evandroslk.springrestapi.dto.UsuarioDTO;
import br.com.evandroslk.springrestapi.dto.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {

		List<UsuarioDTO> lista = service.findAll();
		return ResponseEntity.ok().body(lista);

	}

}