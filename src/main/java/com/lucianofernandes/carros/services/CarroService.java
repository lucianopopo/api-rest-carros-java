package com.lucianofernandes.carros.services;

import java.util.List;

import com.lucianofernandes.carros.domain.Carro;

public interface CarroService {
	public Carro buscarPorId(Integer id);
	public Carro salvarCarro(Carro carro);
	public Carro atualizarCarro(Integer id, Carro carro);
	public void validarCadastroCarro(Carro carro);
	public List<Carro> buscarTodosPorMarca(String nomeMarca);
	public List<Carro> buscarTodos();
	public void deletar(Integer id);
}
