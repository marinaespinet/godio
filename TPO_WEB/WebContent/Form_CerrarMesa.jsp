<%@page import="Interfaces.*"%>
<%@page import="DTO.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cerrar Mesa</title>
</head>
<body>


<%
		%>

<form class="formulario" id="formulario" action="Controller3?action=doCerrarMesa" method="POST"
			onsubmit="return validarForm(this);">
	<table cellspacing="3" cellpadding="3" border="1" width="60%">	
	<input type="hidden" name="id" value="1">

	<tr>
		<td><b>Seleccione mesa:</b> 
	  <td><input type="text" size="5" name="mesa" value="1"></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="Cerrar mesa"></td>
	</tr>
	</table>
	</form>
	<p>
	<p>
	<a href="index.jsp" target="_self">volver</a> 

</body></html>