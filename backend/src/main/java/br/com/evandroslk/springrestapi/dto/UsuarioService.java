package br.com.evandroslk.springrestapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evandroslk.springrestapi.entities.Usuario;
import br.com.evandroslk.springrestapi.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioDTO> findAll() {
		List<Usuario> lista = repository.findAll();
		return lista.stream().map(x -> new UsuarioDTO(x))
				.collect(Collectors.toList());
	}

}
