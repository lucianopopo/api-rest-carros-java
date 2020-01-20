package com.lucianofernandes.carros.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.lucianofernandes.carros.domain.Carro;
import com.lucianofernandes.carros.domain.Marca;
import com.lucianofernandes.carros.exceptions.BusinessException;
import com.lucianofernandes.carros.exceptions.RecursoNaoEncontradoException;
import com.lucianofernandes.carros.repository.CarroRepository;
import com.lucianofernandes.carros.repository.MarcaRepository;
import com.lucianofernandes.carros.services.MarcaService;
import com.lucianofernandes.carros.utils.CollectionUtils;


@PropertySource("classpath:ValidationMessages.properties")
@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Value("${marca.nao.encontrada}")
	private String msgErroMarcaInexistente;
	
	@Value("${marca.deletar.com.carros}")
	private String msgErroDeletarComCarros;

	@Override
	public Marca buscarPorId(Integer id) {
		return marcaRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(msgErroMarcaInexistente));
	}

	@Override
	public Marca salvarMarca(Marca marca) {
		return marcaRepository.save(marca);
	}


	@Override
	public Marca atualizarMarca(Integer id, Marca marcaAtualizada) {
		Marca marcaEncontrada = buscarPorId(id);
		marcaEncontrada.setNomeMarca(marcaAtualizada.getNomeMarca());
		marcaEncontrada.setLogo(marcaAtualizada.getLogo());
		return marcaRepository.save(marcaEncontrada);
	}

	@Override
	public Marca buscarPorNome(String nomeMarca) {
		return marcaRepository.findByNomeMarca(nomeMarca)
				.orElseThrow(() -> new RecursoNaoEncontradoException(msgErroMarcaInexistente));
	}

	@Override
	public Boolean deletar(Integer id) {
		Marca marcaEncontrada = buscarPorId(id);
		List<Carro> carrosDaMarca = carroRepository.findAllByNomeMarca(marcaEncontrada.getNomeMarca());
		if(carrosDaMarca.isEmpty()) {
			marcaRepository.delete(marcaEncontrada);
		} else {
			throw new BusinessException(msgErroDeletarComCarros);
		}
		return true;
	}

	@Override
	public List<Marca> buscarTodos() {
		return CollectionUtils.getListFromIterable(marcaRepository.findAll());
	}

}
