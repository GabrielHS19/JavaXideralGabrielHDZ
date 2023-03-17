package com.examen.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.examen.springdemo.entity.Departamento;
import com.examen.springdemo.entity.Empleado;

@Repository
public class DepartamentoDAOJdbc {
	
	@Autowired
	DataSource dataSource;
	
	public Departamento getDepartamento(int theId) {
		Departamento theDepartamento = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetDepartamento(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				// use the studentId during construction
				theDepartamento = new Departamento(theId, nombre);
			} else {
				System.out.println("Could not find departamento id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theDepartamento;
	}
	
	private PreparedStatement crearStatementGetDepartamento(Connection myConn, int departamentoId) throws SQLException {
		String sql = "select * from departamento where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, departamentoId);
		return ps;
	}

	

}
