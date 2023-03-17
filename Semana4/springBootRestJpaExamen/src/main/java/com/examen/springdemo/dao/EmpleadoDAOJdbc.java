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
public class EmpleadoDAOJdbc implements EmpleadoDAO {
	DepartamentoDAOJdbc depa;
	@Autowired
	DataSource dataSource;

	@Override
	public List<Empleado> getEmpleados() {

		System.out.println("PASO POR List EmpleadoDAOJdbc");
		List<Empleado> empleados = new ArrayList<>();

		// create sql statement
		String sql = "select * from empleado order by id";
		

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String email = myRs.getString("email");
				Double salario = myRs.getDouble("salario");
				int iddepartamento = myRs.getInt("iddepartamento");
				//Departamento departamento = depa.getDepartamento(2);
				// create new student object
				Empleado tempEmpleado = new Empleado(id, nombre, email,salario,getDepartamento(iddepartamento));

				// add it to the list of students
				empleados.add(tempEmpleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;

	}

	@Override
	public Empleado saveEmpleado(Empleado theEmpleado) {
		System.out.println("PASO POR save EmpleadoDAOJdbc");
		String sql = null;
		if(theEmpleado.getId() == 0)
			sql = "insert into empleado " + "(nombre,email,salario, iddepartamento) " + "values (?, ?, ?,?)";
		else
			sql = "update empleado " + "set nombre=?, email=?, salario=?,iddepartamento=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, theEmpleado.getNombre());
			ps.setString(2, theEmpleado.getEmail());
			ps.setDouble(3, theEmpleado.getSalario());
			ps.setInt(4, theEmpleado.getDepartamento().getId());
			
			//id para where del update
			if(theEmpleado.getId() != 0)
				ps.setInt(5, theEmpleado.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return theEmpleado;

	}

	@Override
	public Empleado getEmpleado(int theId) {
		System.out.println("PASO POR get EmpleadoDAOJdbc");
		Empleado theEmpleado = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String email = myRs.getString("email");
				double salario = myRs.getDouble("salario");
				int iddepartamento = myRs.getInt("iddepartamento");

				// use the studentId during construction
				theEmpleado = new Empleado(theId, nombre, email, salario,getDepartamento(iddepartamento));
			} else {
				System.out.println("Could not find customer id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theEmpleado;
	}

	private PreparedStatement crearStatementGetCustomer(Connection myConn, int empleadoId) throws SQLException {
		String sql = "select * from empleado where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, empleadoId);
		return ps;
	}

	@Override
	public void deleteEmpleado(int theId) {
		System.out.println("PASO POR delete EmpleadoDAOJdbc");
		// create sql to delete student
		String sql = "delete from empleado where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// set params
			myStmt.setInt(1, theId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public  Departamento getDepartamento(int theId) {
		System.out.println("PASO POR get departamento");
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
	
	private  PreparedStatement crearStatementGetDepartamento(Connection myConn, int departamentoId) throws SQLException {
		String sql = "select * from departamento where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, departamentoId);
		return ps;
	}
	

}
