package com.pan.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pan.api.beans.Endereco;
import com.pan.api.exception.ServiceException;
import com.pan.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	private static Logger logger = (Logger) LoggerFactory.getLogger(EnderecoService.class);

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private RestTemplate restTemplate;

	public Endereco atualizaEndereco(long id, Endereco enderecoAntigo) throws ServiceException {
		// TODO Auto-generated method stub

		logger.info(EnderecoService.class + " atualizaEndereco ");

		Endereco endereco = enderecoRepository.findById(id);
		if (endereco == null) {
			logger.info("Não existe endereço informado");
			throw new ServiceException("Não existe endereço cadastrado");
		}
		enderecoRepository.save(enderecoAntigo);

		return enderecoAntigo;
	}

	public List<Endereco> buscarCep(String cep) throws ServiceException {
		List<Endereco> endereco = enderecoRepository.findByCep(cep);
		
		logger.info(EnderecoService.class + " buscarCep ");

		if (endereco == null) {
			throw new ServiceException("Não existe endereço cadastrado para esse CEP");
		}
		return endereco;
	}

	public Endereco buscarCepViaCep(String cep) throws ServiceException {
		
		logger.info(EnderecoService.class + " buscarCepViaCep ");
		
		Endereco endereco = restTemplate.getForObject("https://viacep.com.br/ws/" + cep + "/json", Endereco.class);
		// Endereco endereco = enderecoRepository.findByCep(cep);

		if (endereco == null) {
			throw new ServiceException("Não existe endereço cadastrado para esse CEP");
		}
		return endereco;
	}

}
