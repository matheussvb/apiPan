package com.pan.api.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Regiao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6607958510635115252L;

	private String id;
	private String sigla;
	private String nome;

	public Regiao() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
