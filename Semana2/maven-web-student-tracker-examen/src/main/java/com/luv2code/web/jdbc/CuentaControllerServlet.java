package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//se define la ruta del servlet
@WebServlet("/CuentaControllerServlet")
public class CuentaControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CuentaDbUtil cuentaDbUtil;
	
	@Resource(name="jdbc/web_cuenta_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// se crea el cuenta db util y se le asigna un datasource que es un pool de conexiones
		try {
			cuentaDbUtil = new CuentaDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// se pasa la etiqueta command como parametro para conocer la orden
			String theCommand = request.getParameter("command");
			
			// si el comando no tiene valor se coloca por default la opcion de list,para enlistar cuentas
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// se elige el metodo necesario
			switch (theCommand) {
			
			case "LIST":
				listCuentas(request, response);
				break;
				
			case "ADD":
				addCuenta(request, response);
				break;
				
			case "LOAD":
				loadCuenta(request, response);
				break;
				
			case "UPDATE":
				updateCuenta(request, response);
				break;
			
			case "DELETE":
				deleteCuenta(request, response);
				break;
				
			default:
				listCuentas(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
	
	//se crea el metodo para borrar una cuenta

	private void deleteCuenta(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// se lee el id de la cuenta student id del request
		String theCuentaId = request.getParameter("cuentaId");
		
		// se elimina la cuenta de la base de datos
		cuentaDbUtil.deleteCuenta(theCuentaId);
		
		// envia de vuelta a la lista de cuentas
		listCuentas(request, response);
	}

	private void updateCuenta(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// se lee la infoamcion de la cuenta del request
		int id = Integer.parseInt(request.getParameter("cuentaId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		Double balance = Double.parseDouble(request.getParameter("balance"));
		
		// se crea un nuevo objeto de cuenta
		Cuenta theCuenta = new Cuenta(id, nombre, apellido, email,balance);
		
		// se añade el objeto a la base de datos
		cuentaDbUtil.updateCuenta(theCuenta);
		
		// envia de vuelta a la lista de cuentas
		listCuentas(request, response);
		
	}

	private void loadCuenta(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// se lee la infoamcion de la cuenta del request
		String theCuentaId = request.getParameter("cuentaId");
		
		// se obtiene al estudiante de la base de datos 
		Cuenta theCuenta = cuentaDbUtil.getCuenta(theCuentaId);
		
		// se coloca a la cuenta en el request
		request.setAttribute("THE_CUENTA", theCuenta);
		
		// se redirige al jsp de update cuenta
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-cuenta-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addCuenta(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// se lee la infoamcion de la cuenta del request
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		Double balance = Double.parseDouble(request.getParameter("balance"));
		
		// se crea un nuevo objeto de cuenta
		Cuenta theCuenta = new Cuenta(nombre, apellido, email,balance);
		
		// se añade la cuenta a la base de datos
		cuentaDbUtil.addCuenta(theCuenta);
				
		// envia de vuelta a la lista de cuentas
		listCuentas(request, response);
	}

	private void listCuentas(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// se obtienen las cuentas de la base de datos
		List<Cuenta> cuentas = cuentaDbUtil.getCuentas();
		
		// se añaden las cuentas al request
		request.setAttribute("CUENTA_LIST", cuentas);
				
		// se envia al jsp de lista cuentas para visualizar la informacion
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-cuentas.jsp");
		dispatcher.forward(request, response);
	}

}













