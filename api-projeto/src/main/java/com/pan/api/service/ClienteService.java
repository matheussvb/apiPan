package com.pan.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.api.beans.Cliente;
import com.pan.api.exception.ServiceException;
import com.pan.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	private static Logger logger = (Logger) LoggerFactory.getLogger(ClienteService.class);

	@Autowired
	private ClienteRepository clienteRespository;

	public Cliente buscarCpf(String cpf) throws ServiceException {

		logger.info(ClienteService.class + " buscarCpf ");
		Cliente cliente = clienteRespository.findByCpf(cpf);

		if (cliente == null) {
			logger.info(ClienteService.class + " ServiceException ");
			throw new ServiceException("Não existe cliente para esse cpf");
		}
		return cliente;
	}

	public Cliente atualizarCliente(String cpf, Cliente cAntigo) throws ServiceException {
		// TODO Auto-generated method stub
		logger.info(ClienteService.class + " atualizarCliente ");
		Cliente cliente = clienteRespository.findByCpf(cpf);

		if (cliente == null) {
			logger.info(ClienteService.class + " ServiceException ");
			throw new ServiceException("Não existe cliente para esse cpf");
		}
		clienteRespository.save(cAntigo);

		return cAntigo;
	}

}
