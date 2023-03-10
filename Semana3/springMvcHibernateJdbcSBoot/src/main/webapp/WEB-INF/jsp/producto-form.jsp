<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Añadir Producto</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-producto-style.css">
</head>

<body>


	<div id="wrapper">
		<div id="header">
			<h2>Centro comercial - Inventario</h2>
		</div>
	</div>

	<div id="container">
		<h3>Añadir Producto</h3>
	
		<form:form action="saveProducto" modelAttribute="producto" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Precio:</label></td>
						<td><form:input path="precio" /></td>
					</tr>

					<tr>
						<td><label>Stock:</label></td>
						<td><form:input path="stock" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/producto/list">Regresar</a>
		</p>
	
	</div>

</body>

</html>










