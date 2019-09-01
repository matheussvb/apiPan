package com.pan.api.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Microrregiao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4437850978746814723L;

	private Long id;
	private String nome;

	private Mesorregiao mesorregiao;

	public Microrregiao() {
		// TODO Auto-generated constructor stub
	}

	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
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

}
