<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Empleados</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Empleados</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Empleado"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Email</th>
					<th>Salario</th>
					<th>Departamento</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempEmpleado" items="${empleados}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/empleado/showFormForUpdate">
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/empleado/delete">
						<c:param name="empleadoId" value="${tempEmpleado.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempEmpleado.nombre} </td>
						<td> ${tempEmpleado.email} </td>
						<td> ${tempEmpleado.salario} </td>
						<td> ${tempEmpleado.departamento.getNombre()} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this empleado?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









