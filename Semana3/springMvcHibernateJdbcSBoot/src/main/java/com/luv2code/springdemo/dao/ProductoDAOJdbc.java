package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Producto;

@Repository
public class ProductoDAOJdbc implements ProductoDAO{

	//se declara el datasource que servirá para hacer las transacciones
	@Autowired
	DataSource dataSource;

	@Override
	//metodo que obtiene una lista de pr
	public List<Producto> getProductos() {
		System.out.println("PASÓ POR ProductoDAOJdbc");
		List<Producto> productos = new ArrayList<>();

		//se crea una sentencia de sql
		String sql = "select * from producto order by nombre";
		//mediante el ty with resource que sirve para cerrar los recursos usados
				//se crea una conexion a base de datos, un statement que sirve para
				//procesar una sentencia de sql y un resultset para obtener dichos reaultados
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			//se recorre el resulset para obtener los valores de las cuentas
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				Double precio = myRs.getDouble("precio");
				int stuck = myRs.getInt("stock");
				Date fecha = myRs.getDate("fecha");

				//se crea un objeto con los valores y se añade a un arraylist
				Producto tempProducto = new Producto(id, nombre, precio,stuck, fecha);

				// add it to the list of students
				productos.add(tempProducto);
			}
			//se define un catch por posibles errores
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}

	@Override
	//metodo que guarda un producto o lo actualiza dependiendo del caso
	public void saveProducto(Producto theProducto) {
		String sql = null;
		
		//se valida que el id esté vacio para crear un nuevo objeto
		if(theProducto.getId() == 0) {
			// se crea una sentencia de sql para insertar un registro
			sql = "insert into producto " + "(nombre, precio, stock,fecha) " + "values (?, ?, ?,?)";
			//se añade la fecha al producto
			Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
			theProducto.setFecha(fecha);
			//se ocupa el try with resource para cerrar las conexiones despues
			try (Connection myConn = dataSource.getConnection(); 
					PreparedStatement ps = myConn.prepareStatement(sql);
						
				) {
				
                    //se obtienen los datos para ejecutar el preparedstatement
					ps.setString(1, theProducto.getNombre());
					ps.setDouble(2, theProducto.getPrecio());
					ps.setInt(3, theProducto.getStock());
					ps.setDate(4, theProducto.getFecha());
					//id para where
					if(theProducto.getId() != 0)
						ps.setInt(5, theProducto.getId());

					ps.execute();
					
				}catch (SQLException e){
					e.printStackTrace();
				}
		}
		else {
			//si el id no está vacion entonces se hace un update
			//se crea la sentencia de sql para actualizar
			sql = "update producto " + "set nombre=?, precio=?, stock=? " + "where id=?";
			//se ocupa el try with resource para cerrar las conexiones despues
			try (Connection myConn = dataSource.getConnection(); 
					PreparedStatement ps = myConn.prepareStatement(sql);
						
				) {

					ps.setString(1, theProducto.getNombre());
					ps.setDouble(2, theProducto.getPrecio());
					ps.setInt(3, theProducto.getStock());
					
					//id para where
					if(theProducto.getId() != 0)
						ps.setInt(4, theProducto.getId());

					ps.execute();
					//se obtiene la excepcion si es que hay alguna
				}catch (SQLException e){
					e.printStackTrace();
				}
		}

		
		
	}

	@Override
	//metodo que obtiene un producto en base a una id
	public Producto getProducto(int theId) {
		Producto theProducto = null;
		//se ocupa el try with resource para cerrar las conexiones despues
		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetProducto(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			//se obtienen los valores de la cuenta para ser ejecutados por el preparedstatement
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				Double precio = myRs.getDouble("precio");
				int stock = myRs.getInt("stock");

				// se crea el objeto que se obtuvo mediante el id
				theProducto = new Producto(theId, nombre, precio, stock);
			} else {
				System.out.println("No se encontró el producto id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theProducto;
	}

	//se crea el metodo que devolverá el preparedstatement usado en getProducto y que recibe como parametro
		//una conexion y el id del producto a obtener
	private PreparedStatement crearStatementGetProducto(Connection myConn, int productoId) throws SQLException {
		String sql = "select * from producto where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, productoId);
		return ps;
	}

	@Override
	public void deleteProducto(int theId) {
		// se crea la sentencia sql para eliminar un producto mediante su id
				String sql = "delete from producto where id=?";
				//se ocupa el try with resource para cerrar las conexiones despues
				try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql);) {

					// set params
					myStmt.setInt(1, theId);

					// execute sql statement
					myStmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

}
