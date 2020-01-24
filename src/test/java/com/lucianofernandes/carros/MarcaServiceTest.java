package com.lucianofernandes.carros;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.lucianofernandes.carros.domain.Marca;
import com.lucianofernandes.carros.repository.MarcaRepository;
import com.lucianofernandes.carros.services.impl.MarcaServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MarcaServiceTest {
	private Marca marca1 = new Marca();
	private Marca marca2 = new Marca();
	private Marca marcaVazio = new Marca();
	private List<Marca> listaMarcas = new ArrayList<>();
	private Integer id;
	private String nome;

	@Mock
	MarcaRepository marcaRepositoryMock;
	
	@InjectMocks
	MarcaServiceImpl marcaService;
	
	@Before
    public void init() {
		marca1.setMarcaId(1);
		marca1.setNomeMarca("Teste");
		marca1.setLogo("teste.jpg");
		
		marca2.setMarcaId(2);
		marca2.setNomeMarca("Teste 2");
		marca2.setLogo("teste2.jpg");
		
		listaMarcas.add(marca1);
		listaMarcas.add(marca2);
    }
	
	@Test
	public void testBuscarPorId_MarcaExistente() {
		id = 1;
		when(marcaRepositoryMock.findById(id))
		.thenReturn(Optional.of(marca1));
		
		assertEquals("Teste", marcaService.buscarPorId(id).getNomeMarca());
		assertEquals("teste.jpg", marcaService.buscarPorId(id).getLogo());
	}
	
	@Test
	public void testBuscarPorId_MarcaInexistente() {
		when(marcaRepositoryMock.findById(333))
		.thenReturn(Optional.of(marcaVazio));
		
		assertNotNull("Marca não encontrada.", marcaService.buscarPorId(333));
	}
	
	@Test
	public void testBuscarPorNome_MarcaExistente() {
		nome = "Teste 2";
		id = 2;
		when(marcaRepositoryMock.findByNomeMarca(nome))
		.thenReturn(Optional.of(marca2));
		
		assertEquals(id, marcaService.buscarPorNome(nome).getMarcaId());
		assertEquals("teste2.jpg", marcaService.buscarPorNome(nome).getLogo());
	}
	
	@Test
	public void testBuscarPorNome_MarcaInexistente() {
		nome = "Teste 2";
		when(marcaRepositoryMock.findByNomeMarca(nome))
		.thenReturn(Optional.of(marcaVazio));
		
		assertNotNull("Marca não encontrada.", marcaService.buscarPorNome(nome));
	}
	
	@Test
	public void testBuscarTodos_ListaMarcas() {
		when(marcaRepositoryMock.findAll())
		.thenReturn(listaMarcas);
		
		assertEquals("Teste", marcaService.buscarTodos().get(0).getNomeMarca());
		assertEquals("Teste 2", marcaService.buscarTodos().get(1).getNomeMarca());
	}
	
}
