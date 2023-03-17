package com.examen.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.examen.springdemo.entity.Departamento;
import com.examen.springdemo.entity.Empleado;
import com.examen.springdemo.entity.Empleado2;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public EmpleadoServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Empleado> getEmpleados() {

		logger.info("in getEmpleados(): Calling REST API " + crmRestUrl);

		// make REST call

		ResponseEntity<List<Empleado>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Empleado>>() {
				});

		// get the list of customers from response

		List<Empleado> empleados = responseEntity.getBody();

		logger.info("in getEmpleados(): empleados" + empleados);

		return empleados;

	}

	@Override
	public void saveEmpleado(Empleado2 theEmpleado) {

		logger.info("in saveEmpleado(): Calling REST API " + crmRestUrl);

		int empleadoId = theEmpleado.getId();
		// make REST call

		if (empleadoId == 0) {
			// add employee
			Empleado emp = new Empleado();
			Departamento dep =new Departamento();
			dep.setId(theEmpleado.getDepartamento());
			emp.setNombre(theEmpleado.getNombre());
			emp.setEmail(theEmpleado.getEmail());
			emp.setSalario(theEmpleado.getSalario());
			emp.setDepartamento(dep);
			restTemplate.postForEntity(crmRestUrl, emp, String.class);
		} else {
			// update employee 
			Empleado emp = new Empleado();
			Departamento dep =new Departamento();
			dep.setId(theEmpleado.getDepartamento());
			emp.setId(empleadoId);
			emp.setNombre(theEmpleado.getNombre());
			emp.setEmail(theEmpleado.getEmail());
			emp.setSalario(theEmpleado.getSalario());
			emp.setDepartamento(dep);
			restTemplate.put(crmRestUrl, emp);
		}

		logger.info("in saveEmpleado(): success");

	}

	@Override
	public Empleado getEmpleado(int theId) {

		logger.info("in getEmpleado(): Calling REST API " + crmRestUrl);

		// make REST call

		Empleado theEmpleado = restTemplate.getForObject(crmRestUrl + "/" + theId, Empleado.class);

		logger.info("in saveEmpleado(): theEmpleado=" + theEmpleado);

		return theEmpleado;
	}

	@Override
	public void deleteEmpleado(int theId) {
		
		logger.info("in deleteEmpleado(): Calling REST API " + crmRestUrl);

		// make REST call

		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteEmpleado(): deleted empleado theId="+ theId);

	}
}
