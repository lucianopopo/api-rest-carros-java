package com.lucianofernandes.carros.dtos;

import javax.validation.constraints.NotBlank;

public class MarcaDTO {
	@NotBlank(message = "{marca.nome.marca.vazio}")
	private String nomeMarca;
	
	@NotBlank(message = "{marca.logomarca.vazio}")
	private String logo;

	public String getNomeMarca() {
		return nomeMarca;
	}

	public String getLogo() {
		return logo;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
