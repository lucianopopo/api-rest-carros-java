package com.lucianofernandes.carros.enums;

public enum ECambio {
	
	AUTOMATICA("Automática"),
    AUTOMATIZADA("Automatizada"),
    CVT("CVT"),
    SEMIAUTOMATICA("Semi-automática"),
    MANUAL("Manual");
	
	private final String nome;

	private ECambio(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
