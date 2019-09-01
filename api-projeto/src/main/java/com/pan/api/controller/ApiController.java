package com.pan.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pan.api.beans.Cliente;
import com.pan.api.beans.Endereco;
import com.pan.api.beans.Estados;
import com.pan.api.beans.Municipio;
import com.pan.api.exception.ServiceException;
import com.pan.api.response.Response;
import com.pan.api.service.ClienteService;
import com.pan.api.service.EnderecoService;
import com.pan.api.service.EstadosService;
import com.pan.api.service.MunicipioService;

@RestController
@RequestMapping("/api/pan/")
public class ApiController {

	private static Logger logger = (Logger) LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EstadosService estadosService;

	@Autowired
	private MunicipioService municipioService;

	@PutMapping(path = "/atualizar_endereco/{id}", name = "atualizarEndereco")
	public ResponseEntity<Response<Endereco>> atualizarEndereco(@PathVariable("id") long id,
			@RequestBody Endereco enderecoAntigo) throws ServiceException {

		logger.info(ApiController.class + " atualizarEndereco ");

		Response<Endereco> response = new Response<Endereco>();
		response.setData(enderecoService.atualizaEndereco(id, enderecoAntigo));

		logger.info(ApiController.class + " return atualizarEndereco");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/buscar_cliente_cpf/{cpf}", name = "buscarCpf")
	public ResponseEntity<Response<Cliente>> buscarCpf(@PathVariable("cpf") String cpf) throws ServiceException {

		logger.info(ApiController.class + " buscarCpf");

		Response<Cliente> response = new Response<Cliente>();
		Cliente cliente = clienteService.buscarCpf(cpf);
		response.setData(cliente);

		logger.info(ApiController.class + " return buscarCpf");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/buscar_endereco_cep_cliente/{cep}", name = "buscarCep")
	public ResponseEntity<Response<List<Endereco>>> buscarCep(@PathVariable("cep") String cep) throws ServiceException {

		logger.info(ApiController.class + " buscarCep ");

		Response<List<Endereco>> response = new Response<List<Endereco>>();
		List<Endereco> endereco = enderecoService.buscarCep(cep);
		response.setData(endereco);

		logger.info(ApiController.class + " return buscarCep ");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/buscar_via_cep/{cep}", name = "buscarViaCep")
	public ResponseEntity<Response<Endereco>> buscarViaCep(@PathVariable("cep") String cep) throws ServiceException {

		logger.info(ApiController.class + " buscarViaCep ");

		Response<Endereco> response = new Response<Endereco>();
		Endereco endereco = enderecoService.buscarCepViaCep(cep);
		response.setData(endereco);

		logger.info(ApiController.class + " return buscarViaCep ");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/buscar_estados/", name = "buscarEstados")
	public ResponseEntity<Response<List<Estados>>> buscarEstados() throws ServiceException {

		logger.info(ApiController.class + " buscarEstados ");

		Response<List<Estados>> response = new Response<List<Estados>>();
		List<Estados> estados = estadosService.buscarEstados();
		response.setData(estados);

		logger.info(ApiController.class + " return buscarEstados ");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping(path = "/buscar_municipios/{id}", name = "buscarMunicipios")
	public ResponseEntity<Response<List<Municipio>>> buscarMunicipios(@PathVariable("id") String id)
			throws ServiceException {

		logger.info(ApiController.class + " buscarMunicipios ");

		Response<List<Municipio>> response = new Response<List<Municipio>>();
		List<Municipio> municipios = municipioService.buscarMunicipio(id);
		response.setData(municipios);

		logger.info(ApiController.class + " return buscarMunicipios ");

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
