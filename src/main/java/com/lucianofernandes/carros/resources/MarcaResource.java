package com.lucianofernandes.carros.resources;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucianofernandes.carros.domain.Marca;
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
	 * 
	 * @param id
	 */
	@ApiOperation(
			value = "Retorna uma Marca a partir do Id.",
			notes = "Método que retorna um objeto do tipo Marca passando o Id como parâmetro.",
			tags = {"buscar, marca, id"})
	@GetMapping("/id/{id}")
	public ResponseEntity<RestResponseDTO<MarcaDTO>> buscarMarca(@PathVariable Integer id) {
		MarcaDTO marcaDto = mapper.map(marcaService.buscarPorId(id), MarcaDTO.class);
		return retornarSucesso(marcaDto);
	}
	
	/**
	 * Retorna uma Marca a partir do Nome da Marca
	 * 
	 * @param nomeMarca
	 */
	@ApiOperation(
			value = "Retorna uma Marca a partir do Nome da Marca.",
			notes = "Método que retorna um objeto do tipo Marca passando o Nome da Marca como parâmetro.",
			tags = {"buscar, marca, nome"})
	@GetMapping("/nome/{nomeMarca}")
	public ResponseEntity<RestResponseDTO<MarcaDTO>> buscarMarcaPorNome(@PathVariable String nomeMarca) {
		MarcaDTO marcaDto = mapper.map(marcaService.buscarPorNome(nomeMarca), MarcaDTO.class);
		return retornarSucesso(marcaDto);
	}
	
	/**
	 * Retorna uma lista com todas as Marcas cadastradas
	 */
	@ApiOperation(
			value = "Retorna uma lista com todas as Marcas cadastradas.",
			notes = "Método que retorna uma lista de objetos do tipo Marca.",
			tags = {"buscar, marca"})
	@GetMapping()
	public ResponseEntity<RestResponseDTO<List<MarcaDTO>>> buscarTodasMarcas(){
		List<MarcaDTO> listaMarcaDto = Arrays.asList(mapper.map(marcaService.buscarTodos(), MarcaDTO[].class));
		return retornarSucesso(listaMarcaDto);
	}
	
	/**
	 * Salva uma nova Marca na base de dados
	 *
	 * @param marcaDto
	 */
	@ApiOperation(
			value = "Salva os dados da Marca.", 
			notes = "Faz a gravação dos dados da Marca no banco de dados.", 
			tags = {"marca, cadastrar"})
	@PostMapping
	public ResponseEntity<RestResponseDTO<String>> cadastrarNovaMarca(@RequestBody @Valid MarcaDTO marcaDto){
		marcaService.salvarMarca(mapper.map(marcaDto, Marca.class));
		return retornarSucesso("Marca cadastrada com sucesso!");
	}
	
	/**
	 * Atualiza uma Marca cadastrada
	 *
	 * @param marcaDto
	 * @param id
	 */
	@ApiOperation(
			value = "Atualiza uma Marca cadastrada.", 
			notes = "Atualiza os dados da Marca no banco de dados passando o Id como parâmetro.", 
			tags = {"marca, atualizar"})
	@PutMapping("/{id}")
	public ResponseEntity<RestResponseDTO<String>> atualizarMarcaExistente(@RequestBody @Valid MarcaDTO marcaDto, @PathVariable Integer id){
		marcaService.atualizarMarca(id, mapper.map(marcaDto, Marca.class));
		return retornarSucesso("Marca atualizada com sucesso!");
	}
	
	/**
	 * Apaga um objeto Marca cadastrado
	 * 
	 * @param id
	 */
	@ApiOperation(
			value = "Apaga um objeto Marca cadastrado.",
			notes = "Apaga os dados de um objeto do tipo Marca cadastrado.",
			tags = {"deletar, marca"})
	@DeleteMapping("/{id}")
	public ResponseEntity<RestResponseDTO<Boolean>> deletarMarcaExistente(@PathVariable Integer id){
		return retornarSucesso(marcaService.deletar(id));
	}
	
}
