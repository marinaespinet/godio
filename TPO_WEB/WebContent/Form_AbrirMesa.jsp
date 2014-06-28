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
<title>Agregar plato a pedido</title>
        <script type="text/javascript">
            function validarForm(formulario) {
              if(formulario.nroPlato.value.length ==0 ) { 
                formulario.nroPlato.focus();   
                alert('Debe ingresar el plato'); 
                return false; 
              }             
              if(formulario.cant.value.length==0) { //comprueba que no esté vacío
                formulario.cant.focus();
                alert('Debe ingresar la cantidad');
                return false;
              }   
              return true;
            }
        </script>

</head>
<body>


<%
		List<Integer> lasMesasConPedidosDelMozo = BusinessDelegate.getInstancia().getMesasConPedidosAbiertosPorMozo(4);
%>

	<form class="formulario" id="formulario" action="Controller3?action=doAgregarPlato" method="POST"
			onsubmit="return validarForm(this);">
	<table cellspacing="3" cellpadding="3" border="1" width="60%">	
	<input type="hidden" name="id" value="1">
	

	<td><b>Mesa:</b> 
		  <td>
		  	  <select name="mesa" form="formulario">
		  	<%for(Integer elId: lasMesasConPedidosDelMozo) {  
		  		%><option value="<%=elId %>"><%=elId%></option><% } 
		  	%>
		</select>
		  
		  </td>
		</tr>
		
	
	  </td>
	</tr>

	<tr>
		<td><b>Nro. Plato a agregar:</b> 
	  <td><input type="text" size="5" name="nroPlato" value="1"></td>
	</tr>
	<tr>
		<td><b>Cant:</b> 
	  <td><input type="text" size="5" name="cant" value="2"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Agregar plato"></td>
	</tr>
	</table>
	</form>
	<p>
	<p>
	<a href="index.jsp" target="_self">volver</a> 
</body>
</html>