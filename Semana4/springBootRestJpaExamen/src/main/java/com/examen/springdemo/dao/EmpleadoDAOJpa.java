package com.examen.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examen.springdemo.entity.Empleado;

@Repository
public class EmpleadoDAOJpa implements EmpleadoDAO {
	
    // define field for entitymanager
    private EntityManager entityManager;
    
    // set up constructor injection
    @Autowired
    public EmpleadoDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Empleado> getEmpleados() {
		// create a query
        TypedQuery<Empleado> theQuery = entityManager.createQuery("from Empleado", Empleado.class);

        // execute query and get result list
        List<Empleado> empleados = theQuery.getResultList();

        // return the results
        return empleados;
	}

	@Override
	public Empleado saveEmpleado(Empleado theEmpleado) {
		Empleado empleado = entityManager.merge(theEmpleado);
		return empleado;
	}

	@Override
	public Empleado getEmpleado(int theId) {
		Empleado theEmpleado = entityManager.find(Empleado.class, theId);
		return theEmpleado;
	}

	@Override
	public void deleteEmpleado(int theId) {
		Empleado theEmpleado = entityManager.find(Empleado.class, theId);
        // remove employee
        entityManager.remove(theEmpleado);
		
	}

}
