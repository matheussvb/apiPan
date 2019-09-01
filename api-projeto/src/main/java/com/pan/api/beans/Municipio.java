package com.pan.api.beans;

import java.io.Serializable;

import org.springframework.stereotype.Component;
@Component
public class Municipio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2122637729510972225L;

	public Municipio() {
		// TODO Auto-generated constructor stub
	}

	private Long id;
	private String nome;
	private Microrregiao microrregiao;

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

	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
	}

}
