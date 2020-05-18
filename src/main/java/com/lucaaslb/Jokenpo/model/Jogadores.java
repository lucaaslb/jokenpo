package com.lucaaslb.Jokenpo.model;

public class Jogadores {

	private int numero;
	private String ferramenta;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFerramenta() {
		return ferramenta;
	}

	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}

	public Jogadores(int numero, String ferramenta) {

		this.numero = numero;
		this.ferramenta = ferramenta;
	}

}
