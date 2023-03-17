package com.examen.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examen.springdemo.entity.Departamento;

@Repository
public class DepartamentoDAOJpa implements DepartamentoDAO {
	
    // define field for entitymanager
    private EntityManager entityManager;
    
    // set up constructor injection
    @Autowired
    public DepartamentoDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Departamento> getDepartamentos() {
		TypedQuery<Departamento> theQuery = entityManager.createQuery("from Departamento", Departamento.class);
		List<Departamento> departamentos = theQuery.getResultList();
		return departamentos;
	}



}
