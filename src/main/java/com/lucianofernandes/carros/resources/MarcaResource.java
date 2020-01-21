package com.lucianofernandes.carros.resources;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucianofernandes.carros.dtos.MarcaDTO;
import com.lucianofernandes.carros.dtos.RestResponseDTO;
import com.lucianofernandes.carros.services.MarcaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Classe de resource com os End-points para Marca
 * 
 * @author luciano.fernandes
 */
@Api(value = "MarcaResource", tags = {"Marca, Resource"})
@RestController
@RequestMapping(value = "/api-carros/marca")
public class MarcaResource extends SystemResource{
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MarcaService marcaService;
	
	/**
	 * Retorna uma Marca a partir do Id
	 */
	@ApiOperation(
			value = "Retorna uma Marca a partir do Id.",
			notes = "Método que retorna um objeto do tipo Marca passando o Id como parâmetro.",
			tags = {"buscar, marca"})
	@GetMapping("/{id}")
	public ResponseEntity<RestResponseDTO<MarcaDTO>> buscarMarca(@PathVariable Integer id) {
		MarcaDTO marcaDto = mapper.map(marcaService.buscarPorId(id), MarcaDTO.class);
		return retornarSucesso(marcaDto);
	}
	
}
