package com.lucianofernandes.carros.enums;

public enum ECombustivel {
	
	ALCOOL("Álcool"),
    GASOLINA("Gasolina"),
    GAS("Gás natural"),
    FLEX("Flex");
	
	private final String nome;

	private ECombustivel(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
