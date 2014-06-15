<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferencia de Stock</title>
</head>
<body>


	<form class="formulario" action="Controller2?action=doStockTransfer" method="POST">
	<table cellspacing="3" cellpadding="3" border="1" width="60%">	
	<input type="hidden" name="id" value="1">
	
	<tr>
		<td><b>Prod Id:</b> 
	  <td><input type="text" name="nombre" value="1"></td>
	</tr>
	<tr>
		<td><b>Area Id:</b> 
	  <td><input type="text" name="apellido" value="1"></td>
	</tr>
	<tr>
		<td><b>Suc Id:</b> 
	  <td><input type="text" size="50" name="direccion" value="1"></td>
	</tr>
	<tr>
		<td><b>Motivo:</b> 
	  <td><input type="text" size="50" name="direccion" value="motivo test"></td>
	</tr>
	<tr>
		<td><b>Cant:</b> 
	  <td><input type="text" size="50" name="direccion" value="2"></td>
	</tr>
	<tr>
		<td><b>Lote:</b> 
	  <td><input type="text" size="50" name="direccion" value="lote 10"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Transferir Stock"></td>
	</tr>
	</table>
	</form>
</body>
</html>