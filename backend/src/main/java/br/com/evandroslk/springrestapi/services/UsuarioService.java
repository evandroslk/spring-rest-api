package br.com.evandroslk.springrestapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evandroslk.springrestapi.dto.UsuarioDTO;
import br.com.evandroslk.springrestapi.entities.Usuario;
import br.com.evandroslk.springrestapi.repositories.UsuarioRepository;
import br.com.evandroslk.springrestapi.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioDTO> findAll() {
		List<Usuario> lista = repository.findAll();
		return lista.stream().map(x -> new UsuarioDTO(x))
				.collect(Collectors.toList());
	}

	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario usuario = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
		return new UsuarioDTO(usuario);
	}

}
