package com.lucianofernandes.carros.services.impl;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.lucianofernandes.carros.domain.Marca;
import com.lucianofernandes.carros.services.MarcaService;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class MarcaServiceImpl implements MarcaService {

	@Override
	public Marca buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca salvarMarca(Marca marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca atualizarMarca(Integer id, Marca marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca buscarPorNome(String nomeMarca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Integer id) {
		// TODO Auto-generated method stub

	}

}
