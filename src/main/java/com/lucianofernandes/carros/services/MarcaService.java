package com.lucianofernandes.carros.services;

import com.lucianofernandes.carros.domain.Marca;

public interface MarcaService {
	public Marca buscarPorId(Integer id);
	public Marca salvarMarca(Marca marca);
	public Marca atualizarMarca(Integer id, Marca marca);
	public Marca buscarPorNome(String nomeMarca);
	public void deletar(Integer id);
}
