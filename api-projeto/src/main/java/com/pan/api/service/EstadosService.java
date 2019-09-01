package com.pan.api.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pan.api.beans.Estados;
import com.pan.api.exception.ServiceException;

@Service
public class EstadosService {
	private static Logger logger = (Logger) LoggerFactory.getLogger(EstadosService.class);
	@Autowired
	private RestTemplate restTemplate;

	public EstadosService() {
		// TODO Auto-generated constructor stub

	}

	public List<Estados> buscarEstados() throws ServiceException {

		logger.info(EstadosService.class + " buscarEstados ");

		ResponseEntity<Estados[]> responseEntity = restTemplate
				.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados/", Estados[].class);

		List<Estados> listEstados = Arrays.asList(responseEntity.getBody());

		Collections.sort(listEstados, new Comparator<Estados>() {
			@Override
			public int compare(Estados o1, Estados o2) {
				// TODO Auto-generated method stub

				return o1.getNome().compareTo(o2.getNome());

			}
		});

		logger.info(EstadosService.class + " buscarEstados " + " lista ordenada ");

		return listEstados;
	}

}
