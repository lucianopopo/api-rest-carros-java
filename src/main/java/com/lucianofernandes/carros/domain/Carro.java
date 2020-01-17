package com.lucianofernandes.carros.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "{carro.model}")
@Entity
@Table(name = "carro_tb")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carro_id")
	private Integer carroId;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private Marca marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "preco")
	private BigDecimal preco;
	
	@Column(name = "cor")
	private String cor;
	
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "cambio")
	private String cambio;
	
	@Column(name = "combustivel")
	private String combustivel;
	
	@Column(name = "carroceria")
	private String carroceria;
	
	@Column(name = "blindagem")
	private Boolean blindagem;
	
	@Column(name = "opcionais")
	private String opcionais;

	public Integer getCarroId() {
		return carroId;
	}

	public Marca getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getCor() {
		return cor;
	}

	public Integer getAno() {
		return ano;
	}

	public String getCambio() {
		return cambio;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public Boolean getBlindagem() {
		return blindagem;
	}

	public String getOpcionais() {
		return opcionais;
	}

	public void setCarroId(Integer carroId) {
		this.carroId = carroId;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public void setBlindagem(Boolean blindagem) {
		this.blindagem = blindagem;
	}

	public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}

}
