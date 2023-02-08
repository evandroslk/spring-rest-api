package br.com.evandroslk.springrestapi.dto;

import br.com.evandroslk.springrestapi.entities.Telefone;

public class TelefoneDTO {

	private Long id;
	private String numero;

	public TelefoneDTO(Telefone telefone) {
		this.id = telefone.getId();
		this.numero = telefone.getNumero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
