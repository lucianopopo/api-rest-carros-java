package com.lucianofernandes.carros.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lucianofernandes.carros.dtos.RestResponseDTO;
import com.lucianofernandes.carros.enums.ResponseStatusEnum;

public abstract class SystemResource {
private <T extends Object> ResponseEntity<RestResponseDTO<T>> retornarResponse(final T response) {
		
		RestResponseDTO<T> restResponse = new RestResponseDTO<>();
		if (response == null || (response instanceof List<?> && ((List<?>)response).isEmpty())) {
			restResponse.setStatus(ResponseStatusEnum.SEM_RESULTADOS);
		} else {
			restResponse.setStatus(ResponseStatusEnum.OK);
		}
		
		restResponse.setResultado(response);
		return ResponseEntity.status(HttpStatus.OK).body(restResponse);
	}

	/*
	 * HTTP 200
	 */
	public <T extends Object> ResponseEntity<RestResponseDTO<T>> retornarSucesso(final T response) {
		return retornarResponse(response);
	}
}
