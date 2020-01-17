package com.lucianofernandes.carros.services.impl;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.lucianofernandes.carros.domain.Carro;
import com.lucianofernandes.carros.services.CarroService;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class CarroServiceImpl implements CarroService {

	@Override
	public Carro buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carro salvarCarro(Carro carro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carro atualizarCarro(Integer id, Carro carro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarCadastroCarro(Carro carro) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Carro> buscarTodosPorMarca(String nomeMarca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carro> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub

	}

}
