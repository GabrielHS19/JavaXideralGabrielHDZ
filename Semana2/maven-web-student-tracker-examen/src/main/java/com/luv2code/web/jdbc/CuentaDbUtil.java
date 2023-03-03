package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CuentaDbUtil {
	
	//se define un data source que servirá para la conexion a la base de datos

	private DataSource dataSource;
	
	//se crea el constructor de la clase

	public CuentaDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	// se crea el metodo para regresar un array de cuentas
	public List<Cuenta> getCuentas(){
		//se define el array de cuentas y la linea de sql para hacer la seleccion
		List<Cuenta> cuentas = new ArrayList<>();
		//se crea una sentencia de sql
		String sql = "select * from cuentas order by apellido";
		//mediante el ty with resource que sirve para cerrar los recursos usados
		//se crea una conexion a base de datos, un statement que sirve para
		//procesar una sentencia de sql y un resultset para obtener dichos reaultados
		try(Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {
	
			//se recorre el resulset para obtener los valores de las cuentas
			while (myRs.next()) {
				
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				Double balance = myRs.getDouble("balance");
				
				//se crea un objeto con los valores y se añade a un arraylist
				Cuenta tempCuenta = new Cuenta(id, nombre, apellido, email,balance);

				cuentas.add(tempCuenta);				
			}
			
			
		}
		//se define un catch por posibles errores
		catch(SQLException e) {
			e.printStackTrace();
		}
	//se devuelve el arraylist
		return cuentas;		
	}

    //se define un metodo para añadir cuenta que recibe como parametro un objeto cuenta
	public void addCuenta(Cuenta theCuenta) throws Exception {

		// se crea una sentencia de sql para insertar un registro
					String sql = "insert into cuentas "
							   + "(nombre, apellido, email,balance) "
							   + "values (?, ?, ?,?)";
					
			//mediante el ty with resource se crea una conexion a base de datos y 
			// un Preparedstatement que sirve para procesar una sentencia de sql
					
		try(Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql);) {
			
			// se obtienen los valores de la cuenta para ser ejecutados por el preparedstatement
			ps.setString(1, theCuenta.getNombre());
			ps.setString(2, theCuenta.getApellido());
			ps.setString(3, theCuenta.getEmail());
			ps.setDouble(4, theCuenta.getBalance());
			
			// se ejecuta el sql insert
			ps.execute();
		}

	}
	
	//se define un metodo para obtener cuenta que recibe como parametro el id de la cuenta

	public Cuenta getCuenta(String theCuentaId) throws Exception {
		
		//se declara una variable de referencia cuenta 

		Cuenta theCuenta = null;
		
		//se castea el id de cuenta String a Int
		
		int cuentaId = Integer.parseInt(theCuentaId);
		
		//mediante el ty with resource se crea una conexion a base de datos, se crea  
		// un Preparedstatement que recibe una sentencia de preparedstatement generada por un metodo y
		// se define el reaultset que ejecuta el query
		
		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCuenta(myConn, cuentaId);
				ResultSet myRs = myStmt.executeQuery()) {
			
			//se recorre el resulset y se guardan en variables los datos respectivos

			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String email = myRs.getString("email");
				Double balance = myRs.getDouble("balance");
				
				// se crea una cuenta con los datos recopilados y con el id pasado por el parametro
				theCuenta = new Cuenta(cuentaId, nombre, apellido, email,balance);
			}
			else {
				throw new Exception("Could not find student id: " + cuentaId);
			}				
			
			return theCuenta;
		}
		
	}
	
	//se crea el metodo que devolverá el preparedstatement usado en getcuenta y que recibe como parametro
	//una conexion y el id de la cuenta a obtener
	
	private PreparedStatement crearStatementGetCuenta(Connection myConn, int cuentaId) throws SQLException {
		//se crea la sentencia de sql que obtendra la cuenta
		String sql = "select * from cuentas where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		//se añade al prepare statement el id de la cuenta
		ps.setInt(1, cuentaId);
		//se retorna el prepared statement
		return ps;
	}
	
	//se declara un metodo para actualizar a una cuenta que recibe como parametro una cuenta

	public void updateCuenta(Cuenta theCuenta) throws Exception {
		
		//se crea una sentencia sql para actualizar una cuenta
		String sql = "update cuentas "
				+ "set nombre=?, apellido=?, email=?,balance=? "
				+ "where id=?";
		
		//mediante el ty with resource se crea una conexion a base de datos, se crea  
	    // un Preparedstatement que recibe la sentencia sql
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			//se obtiene los valores de la cuenta para agregarlos al preparedstatement
			myStmt.setString(1, theCuenta.getNombre());
			myStmt.setString(2, theCuenta.getApellido());
			myStmt.setString(3, theCuenta.getEmail());
			myStmt.setDouble(4, theCuenta.getBalance());
			myStmt.setInt(5, theCuenta.getId());
			
			// se ejecuta el preparedstatement
			myStmt.execute();
		}
	}

	//se define un metodo para eliminar una cuenta que recibe como parametro el id de la cuenta a
	//eliminar
	public void deleteCuenta(String theCuentaId) throws Exception {

		//se define una sentencia sql que elimina la cuenta por medio de su id
		String sql = "delete from cuentas where id=?";
		
		//mediante el ty with resource se crea una conexion a base de datos, se crea  
	    // un Preparedstatement que recibe la sentencia sql
		try(Connection myConn = dataSource.getConnection();
				 PreparedStatement myStmt = myConn.prepareStatement(sql);) {
			
			// se castea el ide de la cuenta de String a int
			int cuentaId = Integer.parseInt(theCuentaId);
			
			// se asigna al preparedstatement el id de la cuenta
			myStmt.setInt(1, cuentaId);
			
			// se ejecuta el preparedstatement (sql)
			myStmt.execute();
		}
	}
}















