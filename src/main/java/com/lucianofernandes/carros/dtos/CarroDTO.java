package com.lucianofernandes.carros.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lucianofernandes.carros.domain.Marca;

public class CarroDTO {
	@NotNull(message = "{carro.marca.vazio}")
	private Marca marca;
	
	@NotBlank(message = "{carro.modelo.vazio}")
	private String modelo;
	
	@NotNull(message = "{carro.preco.vazio}")
	private BigDecimal preco;
	
	@NotBlank(message = "{carro.cor.vazio}")
	private String cor;
	
	@NotNull(message = "{carro.ano.vazio}")
	private Integer ano;
	
	@NotBlank(message = "{carro.cambio.vazio}")
	private String cambio;
	
	@NotBlank(message = "{carro.combustivel.vazio}")
	private String combustivel;
	
	@NotBlank(message = "{carro.carroceria.vazio}")
	private String carroceria;
	
	@NotNull(message = "{carro.blindagem.vazio}")
	private Boolean blindagem;
	
	@NotBlank(message = "{carro.opcionais.vazio}")
	private String opcionais;

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
