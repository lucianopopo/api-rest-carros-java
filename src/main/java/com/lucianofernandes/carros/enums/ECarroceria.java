package com.lucianofernandes.carros.enums;

public enum ECarroceria {
	
    CONVERSIVEL("Conversível"),
    CUPE("Cupê"),
    HATCH("Hatchback"),
    SEDA("Sedã"),
    PERUA("Perua/SW"),
    PICAPE("Picape");
	
	private final String nome;

	private ECarroceria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
