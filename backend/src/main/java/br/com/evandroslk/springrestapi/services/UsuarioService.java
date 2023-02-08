package br.com.evandroslk.springrestapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.evandroslk.springrestapi.dto.UsuarioDTO;
import br.com.evandroslk.springrestapi.entities.Usuario;
import br.com.evandroslk.springrestapi.repositories.TelefoneRepository;
import br.com.evandroslk.springrestapi.repositories.UsuarioRepository;
import br.com.evandroslk.springrestapi.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	public List<UsuarioDTO> findAll() {
		List<Usuario> lista = usuarioRepository.findAll();
		return lista.stream().map(x -> new UsuarioDTO(x, x.getTelefones()))
				.collect(Collectors.toList());
	}

	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		Usuario usuario = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
		return new UsuarioDTO(usuario, usuario.getTelefones());
	}

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		copyDtoToEntity(dto, usuario);
		return new UsuarioDTO(usuarioRepository.save(usuario));
	}

	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			copyDtoToEntity(dto, usuario);
			return new UsuarioDTO(usuarioRepository.save(usuario));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	@Transactional
	public void delete(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	private void copyDtoToEntity(UsuarioDTO dto, Usuario usuario) {
		usuario.setNome(dto.getNome());
		usuario.setLogin(dto.getLogin());
		usuario.setSenha(dto.getSenha());
	}

}
