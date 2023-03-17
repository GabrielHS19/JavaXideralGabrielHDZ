package com.examen.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.springdemo.dao.DepartamentoDAO;
import com.examen.springdemo.entity.Departamento;
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDAO repository;
	

	@Override
	public List<Departamento> listaDepartamento() {
		return repository.getDepartamentos();
		
	}

}
