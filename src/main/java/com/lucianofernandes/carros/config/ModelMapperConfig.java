package com.lucianofernandes.carros.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper mapper() {
		ModelMapper mapper = new ModelMapper();

		return mapper;
	}
}