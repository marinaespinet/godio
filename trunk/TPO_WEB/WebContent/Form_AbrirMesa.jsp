<%@page import="Interfaces.*"%>
<%@page import="DTO.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="./CheckLogin.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Abrir Mesa</title>
        <script type="text/javascript">
            function validarForm(formulario) {
              if(formulario.cantidad.value.length ==0 ) { 
                formulario.cantidad.focus();   
                alert('Debe ingresar la cantidad de comensales'); 
                return false; 
              }             
              return true;
            }
        </script>

</head>
<body>


<%
		//List<Integer> lasMesasConPedidosDelMozo = BusinessDelegate.getInstancia().getMesasConPedidosAbiertosPorMozo(4);
%>

	<form class="formulario" id="formulario" action="Controller3?action=doAbrirMesa" method="POST"
			onsubmit="return validarForm(this);">
	<table cellspacing="3" cellpadding="3" border="1" width="60%">	
	<input type="hidden" name="id" value="1">

	<tr>
		<td><b>Cantidad de comensales:</b> 
	  <td><input type="text" size="5" name="cantidad" value="1"></td>
	</tr>
	
	<tr>
		<td colspan="2"><input type="submit" value="Abrir mesa"></td>
	</tr>
	</table>
	</form>
	<p>
	<p>
	<a href="index.jsp" target="_self">volver</a> 
</body>
</html>