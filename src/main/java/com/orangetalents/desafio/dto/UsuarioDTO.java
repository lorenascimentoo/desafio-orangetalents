package com.orangetalents.desafio.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório")
	private String email;
	@NotEmpty(message="Preenchimento obrigatório")
	private String cpf;
	@NotEmpty(message="Preenchimento obrigatório")
	private String dtnasc;
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
	
	public UsuarioDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
}
