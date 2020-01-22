package com.lucianofernandes.carros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lucianofernandes.carros.domain.Carro;


public interface CarroRepository extends JpaRepository<Carro, Integer>{

	// Busca lista de Carros de uma determinada Marca
	@Query(value = "SELECT DISTINCT c.carro_id, c.modelo, c.marca_id, c.preco, c.cor, c.ano, c.cambio, c.combustivel, c.carroceria, c.blindagem, c.opcionais FROM carro_tb AS c "
			+ "INNER JOIN marca_tb AS m "
			+ "ON m.marca_id = c.marca_id "
			+ "WHERE m.nome_marca = :nomeMarca", nativeQuery = true)
	List<Carro> findAllByNomeMarca(@Param("nomeMarca") String nomeMarca);
}
