<!DOCTYPE html>
<html>

<head>
	<title>Actualizar cuenta</title>
	
<!-- Se referencian las hojas de estilos  -->

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-cuenta-style.css">	
</head>

<!-- Se crean los inputs de informacion  -->
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Banco Mundial</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar cuenta</h3>
		
		<form action="CuentaControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="cuentaId" value="${THE_CUENTA.id}" />
			
			<!--  Se crean los input de informacion con la informacion de la cuenta a modificar -->
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" 
								   value="${THE_CUENTA.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellidos:</label></td>
						<td><input type="text" name="apellido" 
								   value="${THE_CUENTA.apellido}" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" 
								   value="${THE_CUENTA.email}" /></td>
					</tr>
					
					<tr>
						<td><label>Balance:</label></td>
						<td><input type="number" name="balance" 
								   value="${THE_CUENTA.balance}" /></td>
					</tr>
					<!-- Se define el submit para guardar cambios  -->
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="CuentaControllerServlet">Regresar a la lista</a>
		</p>
	</div>
</body>

</html>











