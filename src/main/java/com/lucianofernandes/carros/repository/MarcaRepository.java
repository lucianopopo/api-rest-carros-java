package com.lucianofernandes.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucianofernandes.carros.domain.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	Marca findByNomeMarca(String nomeMarca);
}
