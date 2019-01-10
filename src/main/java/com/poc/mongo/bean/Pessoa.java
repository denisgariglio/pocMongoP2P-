package com.poc.mongo.bean;

public class Pessoa extends BaseEntity{

	private static final long serialVersionUID = -6228368562747792911L;
	
	private String nome;	
	private String cpf;	
	private String cidade;
	
	public Pessoa() {
	
	}
	
	public Pessoa(String nome, String cpf, String cidade) {
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
