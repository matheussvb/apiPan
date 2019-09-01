package com.pan.api.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pan.api.beans.Municipio;

@Service
public class MunicipioService {

	private static Logger logger = (Logger) LoggerFactory.getLogger(MunicipioService.class);

	@Autowired
	private RestTemplate restTemplate;

	public MunicipioService() {
		// TODO Auto-generated constructor stub

	}

	public List<Municipio> buscarMunicipio(String id) {
		// TODO Auto-generated method stub

		logger.info(MunicipioService.class + " buscarMunicipio ");

		ResponseEntity<Municipio[]> responseEntity = restTemplate.getForEntity(
				"https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + id + "/municipios", Municipio[].class);

		return Arrays.asList(responseEntity.getBody());
	}

}
