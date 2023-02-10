package br.com.evandroslk.springrestapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.evandroslk.springrestapi.dto.UsuarioDTO;
import br.com.evandroslk.springrestapi.entities.Telefone;
import br.com.evandroslk.springrestapi.entities.Usuario;
import br.com.evandroslk.springrestapi.repositories.UsuarioRepository;
import br.com.evandroslk.springrestapi.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

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
		Usuario usuario = convertDtoToEntity(dto);
		return new UsuarioDTO(usuarioRepository.save(usuario), usuario.getTelefones());
	}

	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario usuario = convertDtoToEntity(dto);
			usuario = usuarioRepository.save(usuario);
			return new UsuarioDTO(usuario, usuario.getTelefones());
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

	public Usuario convertDtoToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setLogin(usuarioDTO.getLogin());

		String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);

		usuario.setNome(usuarioDTO.getSenha());
		List<Telefone> telefones = usuarioDTO.getTelefones().stream().map(telDto -> {
			Telefone telefone = new Telefone();
			telefone.setId(telDto.getId());
			telefone.setNumero(telDto.getNumero());
			telefone.setUsuario(usuario);
			return telefone;
		}).collect(Collectors.toList());
		usuario.setTelefones(telefones);
		return usuario;
	}
}
