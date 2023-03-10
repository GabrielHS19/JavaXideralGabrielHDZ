<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Productos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Inventario de Productos </h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Añadir Producto"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Stock</th>
					<th>Fecha de registro</th>
					<th>Acciones</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProducto" items="${productos}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/producto/showFormForUpdate">
						<c:param name="productoId" value="${tempProducto.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/producto/delete">
						<c:param name="productoId" value="${tempProducto.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempProducto.nombre} </td>
						<td> ${tempProducto.precio} </td>
						<td> ${tempProducto.stock} </td>
						<td> ${tempProducto.fecha} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Estás seguro de que deseas eliminar este producto?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









