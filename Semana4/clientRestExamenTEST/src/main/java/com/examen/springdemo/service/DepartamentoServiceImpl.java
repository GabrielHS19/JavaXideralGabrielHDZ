package com.examen.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.examen.springdemo.entity.Departamento;
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());
	

	@Override
	public List<Departamento> listaDepartamento() {
		logger.info("in getDepartamentos(): Calling REST API " + crmRestUrl);

		// make REST call

		ResponseEntity<List<Departamento>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Departamento>>() {
				});

		// get the list of customers from response

		List<Departamento> departamentos = responseEntity.getBody();

		logger.info("in getDepartamentos(): departamentos" + departamentos);

		return departamentos;
		
	}
	

}
