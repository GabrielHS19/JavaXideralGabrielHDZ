<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Agregar Empleado</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/add-empleado-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Agregar empleados</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Empleado</h3>

		<form:form action="saveEmpleado" modelAttribute="empleado2"
			method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label>Salario:</label></td>
						<td><form:input path="salario" /></td>
					</tr>

					<tr>
						<div>
						<label>Departamento:</label>
						<!--<form:input path="departamento" />-->
							<select name="departamento" path="departamento"
								onchange="ShowSelected();">
								<option value="1">Ventas</option>
								<option value="2">Finanzas</option>
								<option value="3">Marketing</option>
								<option value="4">Recursos humanos</option>
								<option value="5">Tecnologias</option>
								<option value="6">Operaciones</option>
							</select>
						</div>
					</tr>
					<tr>
						<td><label></label></td>

						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>

			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/empleado/list">Back
				to List</a>
		</p>

	</div>
</body>
<script type="text/javascript">
	function ShowSelected() {

		/* Para obtener el texto */
		var combo = document.getDepartamento("departamento");
		var selected = combo.options[combo.selectedIndex].text;
		alert(selected);
	}
</script>
</html>










