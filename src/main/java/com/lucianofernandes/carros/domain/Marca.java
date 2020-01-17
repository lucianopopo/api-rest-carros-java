package com.lucianofernandes.carros.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
