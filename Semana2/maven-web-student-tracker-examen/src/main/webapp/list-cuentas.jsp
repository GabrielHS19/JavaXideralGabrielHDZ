<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Banco mundial</title>
	<!-- Se referencian las hojas de estilos  -->
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Banco mundial</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- Se coloca un nuevo boton para añadir cuenta  -->
			
			<input type="button" value="Añadir Cuenta" 
				   onclick="window.location.href='add-cuenta-form.jsp'; return false;"
				   class="add-cuenta-button"
			/>
			<!-- Se define una tabla para mostrar los resultados  -->
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Email</th>
					<th>Saldo</th>
					<th>Accion</th>
				</tr>
				
				<!-- Se define una etiqueta foreach para recorrer las cuentas existentes  -->
				
				<c:forEach var="tempCuenta" items="${CUENTA_LIST}">
					
					<!-- se configura un enlace para cada cuenta -->
					<!--  se configura un link para la opcion de recibir una cuenta -->
					<c:url var="tempLink" value="CuentaControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="cuentaId" value="${tempCuenta.id}" />
					</c:url>

					<!--  se configura un link para la opcion de eliminar cuenta-->
					<c:url var="deleteLink" value="CuentaControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="cuentaId" value="${tempCuenta.id}" />
					</c:url>
					
					<!-- Se rescatan los valores de la cuenta -->
																		
					<tr>
						<td> ${tempCuenta.nombre} </td>
						<td> ${tempCuenta.apellido} </td>
						<td> ${tempCuenta.email} </td>
						<td> ${tempCuenta.balance} $</td>
						<td> 
							<a href="${tempLink}">Actualizar</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Eliminar</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








