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

import com.lucianofernandes.carros.domain.Carro;
import com.lucianofernandes.carros.dtos.CarroDTO;
import com.lucianofernandes.carros.dtos.RestResponseDTO;
import com.lucianofernandes.carros.services.CarroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Classe de resource com os End-points para Carro
 * 
 * @author luciano.fernandes
 */
@Api(value = "CarroResource", tags = {"Carro, Resource"})
@RestController
@RequestMapping(value = "/api-carros/carro")
public class CarroResource extends SystemResource{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CarroService carroService;
	
	/**
	 * Retorna um Carro a partir do Id
	 * 
	 * @param id
	 */
	@ApiOperation(
			value = "Retorna um Carro a partir do Id.",
			notes = "Método que retorna um objeto do tipo Carro passando o Id como parâmetro.",
			tags = {"buscar, carro, id"})
	@GetMapping("/{id}")
	public ResponseEntity<RestResponseDTO<CarroDTO>> buscarCarro(@PathVariable Integer id){
		CarroDTO carroDTO = mapper.map(carroService.buscarPorId(id), CarroDTO.class);
		return retornarSucesso(carroDTO);
	}
	
	/**
	 * Retorna uma lista de Carros a partir do Nome da Marca
	 * 
	 * @param nomeMarca
	 */
	@ApiOperation(
			value = "Retorna uma lista de Carros a partir do Nome da Marca.",
			notes = "Método que retorna uma lista de objetos do tipo Carro passando o Nome da Marca como parâmetro.",
			tags = {"buscar, carro, nome da marca"})
	@GetMapping("/marca/{nomeMarca}")
	public ResponseEntity<RestResponseDTO<List<CarroDTO>>> buscarPorMarca(@PathVariable String nomeMarca) {
		List<CarroDTO> listaCarros = Arrays.asList(mapper.map(carroService.buscarTodosPorMarca(nomeMarca), CarroDTO[].class ));
		return retornarSucesso(listaCarros);
	}
	
	/**
	 * Retorna uma lista com todos os Carros cadastrados
	 */
	@ApiOperation(
			value = "Retorna uma lista com todos os Carros cadastrados.",
			notes = "Método que retorna uma lista de objetos do tipo Carro.",
			tags = {"buscar, carro"})
	@GetMapping()
	public ResponseEntity<RestResponseDTO<List<CarroDTO>>> buscarTodos(){
		List<CarroDTO> listaCarros = Arrays.asList(mapper.map(carroService.buscarTodos(),CarroDTO[].class ));
		return retornarSucesso(listaCarros);
	}
	
	/**
	 * Salva um novo Carro na base de dados
	 *
	 * @param carroDto
	 */
	@ApiOperation(
			value = "Salva os dados do Carro.", 
			notes = "Faz a gravação dos dados do Carro no banco de dados.", 
			tags = {"carro, cadastrar"})
	@PostMapping
	public ResponseEntity<RestResponseDTO<String>> cadastrarNovoCarro(@RequestBody @Valid CarroDTO carroDto){
		carroService.salvarCarro(mapper.map(carroDto, Carro.class));
		return retornarSucesso("Carro cadastrado com sucesso!");
	}
	
	/**
	 * Atualiza um Carro cadastrado
	 *
	 * @param carroDto
	 * @param id
	 */
	@ApiOperation(
			value = "Atualiza um Carro cadastrado.", 
			notes = "Atualiza os dados do Carro no banco de dados passando o Id como parâmetro.", 
			tags = {"carro, atualizar"})
	@PutMapping("/{id}")
	public ResponseEntity<RestResponseDTO<String>> atualizarCarroExistente(@RequestBody @Valid CarroDTO carroDto, @PathVariable Integer id){
		carroService.atualizarCarro(id, mapper.map(carroDto, Carro.class));
		return retornarSucesso("Carro atualizado com sucesso!");
	}
	
	/**
	 * Apaga um objeto Carro cadastrado
	 * 
	 * @param id
	 */
	@ApiOperation(
			value = "Apaga um objeto Carro cadastrado.",
			notes = "Apaga os dados de um objeto do tipo Carro cadastrado.",
			tags = {"deletar, carro"})
	@DeleteMapping("/{id}")
	public ResponseEntity<RestResponseDTO<Boolean>> deletarCarroExistente(@PathVariable Integer id){
		return retornarSucesso(carroService.deletar(id));
	}
}
