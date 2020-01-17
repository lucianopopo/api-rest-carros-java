package com.lucianofernandes.carros.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "{marca.model}")
@Entity
@Table(name = "marca_tb")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marca_id")
	private Integer marcaId;
	
	@Column(name = "nome_marca")
	private String nomeMarca;
	
	@Column(name = "logo")
	private String logo;

	public Integer getMarcaId() {
		return marcaId;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public String getLogo() {
		return logo;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
}
