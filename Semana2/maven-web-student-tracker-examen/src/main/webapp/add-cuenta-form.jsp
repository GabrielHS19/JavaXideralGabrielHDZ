<!DOCTYPE html>
<html>
<!-- Se referencian las hojas de estilos  -->
<head>
	<title>Añadir cuenta</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-cuenta-style.css">	
</head>



<body>
	<div id="wrapper">
		<div id="header">
			<h2>Banco Mundial</h2>
		</div>
	</div>
	
	<!-- Se define el boton para añadir cuenta   -->
	<div id="container">
		<h3>Añadir Cuenta</h3>
		
		<!-- Se definen los inputs para leer datos    -->
		
		<form action="CuentaControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="nombre" /></td>
					</tr>

					<tr>
						<td><label>Apellidos:</label></td>
						<td><input type="text" name="apellido" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label>Balance:</label></td>
						<td><input type="number" name="balance" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<!-- Se declara una linea de codigo para volver a la pantalla principal   -->
		
		<p>
			<a href="CuentaControllerServlet">Regresar a la lista</a>
		</p>
	</div>
</body>

</html>











