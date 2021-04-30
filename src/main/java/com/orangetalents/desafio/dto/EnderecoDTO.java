package com.orangetalents.desafio.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

public class EnderecoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer cidadeId;
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	@NotEmpty(message="Preenchimento obrigatório")
	private String complemento;
	@NotEmpty(message="Preenchimento obrigatório")
	private String bairro;
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer usuarioId;
	
	public EnderecoDTO() {
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
