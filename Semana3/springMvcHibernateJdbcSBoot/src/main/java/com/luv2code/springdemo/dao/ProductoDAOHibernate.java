package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Producto;

@Repository
public class ProductoDAOHibernate implements ProductoDAO {

	// se define el  entitymanager
		private EntityManager entityManager;

		// se configura la inyección de constructor
		@Autowired
		public ProductoDAOHibernate(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
			
	@Override
	public List<Producto> getProductos() {
		
		System.out.println("PASO POR ProductoDAOHibernate");
		// se declara el session factory
		Session currentSession = entityManager.unwrap(Session.class);
				
		// se crea el query sql para ordenar por nombre
		Query<Producto> theQuery = 
				currentSession.createQuery("from Producto order by nombre",
						Producto.class);
		
		// se ejecuta el query y se obtiene el resultado
		List<Producto> productos = theQuery.getResultList();
				
		// se devuelve la tabla de productos		
		return productos;
	}

	@Override
	public void saveProducto(Producto theProducto) {
        
		// se obtiene el hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		//se guarda o se actualiza el producto
		currentSession.saveOrUpdate(theProducto);
		
	}

	@Override
	public Producto getProducto(int theId) {

		// se obtiene el hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// se obtiene el producto mediante el id del producto
		Producto theProducto = currentSession.get(Producto.class, theId);
		//se devuelve el producto
		return theProducto;
	}

	@Override
	public void deleteProducto(int theId) {

		// se obtiene el hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// se ejecuta el query en donde se borra el producto
		Query theQuery = 
				currentSession.createQuery("delete from Producto where id=:productoId");
		theQuery.setParameter("productoId", theId);
		
		//se ejecuta el query
		theQuery.executeUpdate();		
	}

}











