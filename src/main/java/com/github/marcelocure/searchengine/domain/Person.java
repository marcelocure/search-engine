package com.github.marcelocure.searchengine.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Person implements Serializable{
	private int id;
	private String nome;
	private String cpf;
	private String logradouro;
	private int numero;
	private String complemento;
	private String telefoneResidencial;
	private String telefoneCelular;
	public Person() {
		
	}

	public Person(int id, String nome, String cpf, String logradouro,
			int numero, String complemento, String telefoneResidencial,
			String telefoneCelular) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nome=" + nome + ", cpf=" + cpf
				+ ", logradouro=" + logradouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", telefoneResidencial="
				+ telefoneResidencial + ", telefoneCelular=" + telefoneCelular
				+ "]";
	}
}