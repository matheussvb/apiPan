package com.pan.api.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Mesorregiao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 183802716769053631L;
	private Long id;
	private String nome;
	@JsonProperty(value = "UF")
	private Uf uf;

	public Mesorregiao() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}
