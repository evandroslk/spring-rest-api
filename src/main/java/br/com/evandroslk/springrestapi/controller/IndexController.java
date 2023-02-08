package br.com.evandroslk.springrestapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/usuarios")
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@GetMapping
	public ResponseEntity<Void> init(@RequestParam(value = "nome", required = true, defaultValue = "Nome não informado") String nome) {
		LOGGER.info("Parâmetro sendo recebido: {} ", nome);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
