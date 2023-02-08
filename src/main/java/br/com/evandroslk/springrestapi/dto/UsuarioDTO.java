package br.com.evandroslk.springrestapi.dto;

import java.io.Serializable;

import br.com.evandroslk.springrestapi.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String login;
	private String senha;
	private String nome;

	public UsuarioDTO() {

	}

	public UsuarioDTO(Usuario entidade) {
		this.id = entidade.getId();
		this.login = entidade.getLogin();
		this.senha = entidade.getSenha();
		this.nome = entidade.getNome();
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

}
