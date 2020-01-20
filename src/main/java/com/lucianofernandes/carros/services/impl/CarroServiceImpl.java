package com.lucianofernandes.carros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.lucianofernandes.carros.domain.Carro;
import com.lucianofernandes.carros.domain.Marca;
import com.lucianofernandes.carros.exceptions.RecursoNaoEncontradoException;
import com.lucianofernandes.carros.repository.CarroRepository;
import com.lucianofernandes.carros.repository.MarcaRepository;
import com.lucianofernandes.carros.services.CarroService;
import com.lucianofernandes.carros.utils.CollectionUtils;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class CarroServiceImpl implements CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Value("${carro.nao.encontrado}")
	private String msgErroCarroInexistente;
	
	@Value("${marca.nao.encontrada}")
	private String msgErroMarcaInexistente;
	

	@Override
	public Carro buscarPorId(Integer id) {
		return carroRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(msgErroCarroInexistente));
	}

	@Override
	public Carro salvarCarro(Carro carro) {
		return carroRepository.save(carro);
	}

	@Override
	public Carro atualizarCarro(Integer id, Carro carro) {
		Carro carroEncontrado = buscarPorId(id);
		Marca marcaEncontrada = marcaRepository.findById(carro.getCarroId()).orElseThrow(() -> new RecursoNaoEncontradoException(msgErroMarcaInexistente));
		carroEncontrado.setMarca(marcaEncontrada);
		carroEncontrado.setModelo(carro.getModelo());
		carroEncontrado.setPreco(carro.getPreco());
		carroEncontrado.setCor(carro.getCor());
		carroEncontrado.setAno(carro.getAno());
		carroEncontrado.setCambio(carro.getCambio());
		carroEncontrado.setCombustivel(carro.getCombustivel());
		carroEncontrado.setCarroceria(carro.getCarroceria());
		carroEncontrado.setBlindagem(carro.getBlindagem());
		carroEncontrado.setOpcionais(carro.getOpcionais());
		return carroRepository.save(carro);
	}


	@Override
	public List<Carro> buscarTodosPorMarca(String nomeMarca) {
		return CollectionUtils.getListFromIterable(carroRepository.findAllByNomeMarca(nomeMarca));
	}

	@Override
	public List<Carro> buscarTodos() {
		return CollectionUtils.getListFromIterable(carroRepository.findAll());
	}

	@Override
	public Boolean deletar(Integer id) {
		Carro carroEncontrado = buscarPorId(id);
		carroRepository.delete(carroEncontrado);
		return true;
	}

}
