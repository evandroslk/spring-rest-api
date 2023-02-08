package br.com.evandroslk.springrestapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.evandroslk.springrestapi.entities.Telefone;
import br.com.evandroslk.springrestapi.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String senha;
	private String nome;
	private List<TelefoneDTO> telefones = new ArrayList<>();

	public UsuarioDTO() {

	}

	public UsuarioDTO(Usuario entidade) {
		this.id = entidade.getId();
		this.login = entidade.getLogin();
		this.senha = entidade.getSenha();
		this.nome = entidade.getNome();
	}

	public UsuarioDTO(Usuario entidade, List<Telefone> telefones) {
		this(entidade);
		telefones.forEach(tel -> this.telefones.add(new TelefoneDTO(tel)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

}
