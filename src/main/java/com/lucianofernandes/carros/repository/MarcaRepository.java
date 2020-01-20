package com.lucianofernandes.carros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucianofernandes.carros.domain.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	Optional<Marca> findByNomeMarca(String nomeMarca);
}
