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
<title>Transferencia de Stock</title>
        <script type="text/javascript">
            function validarForm(formulario) {
              if(formulario.motivo.value.length ==0 ) { 
                formulario.motivo.focus();   
                alert('Debe ingresar el motivo'); 
                return false; 
              }             
              if(formulario.lote.value.length==0) { //comprueba que no esté vacío
                formulario.lote.focus();
                alert('Debe ingresar el lote');
                return false;
              }   
              return true;
            }
        </script>

</head>
<body>


<%
		//List<DTO.Producto> productos=  BusinessDelegate.getInstancia().getProductos();
		List<DTO.Semielaborado> semis=  BusinessDelegate.getInstancia().getSemielaborados();	
%>

	<form class="formulario" id="formulario" action="Controller2?action=doStockTransfer" method="POST"
			onsubmit="return validarForm(this);">
	<table cellspacing="3" cellpadding="3" border="1" width="60%">	
	<input type="hidden" name="id" value="1">
	

	<td><b>Producto:</b> 
		  <td>
		  	  <select name="prod" form="formulario">
		  	<%for(Semielaborado semi: semis) {  %>
			  <option value="<%=semi.getProducto_id() %>"><%=semi.getName()%></option>
		 <% } %>
		</select>
		  
		  </td>
		</tr>
		
	
	  </td>
	</tr>

	<tr>
		<td><b>Motivo:</b> 
	  <td><input type="text" size="50" name="motivo" value="motivo test"></td>
	</tr>
	<tr>
		<td><b>Cant:</b> 
	  <td><input type="text" size="5" name="cant" value="2"></td>
	</tr>
	<tr>
		<td><b>Lote:</b> 
	  <td><input type="text" size="50" name="lote" value="lote 10"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Transferir Stock"></td>
	</tr>
	</table>
	</form>
	<p>
	<p>
	<a href="index.jsp" target="_self">volver</a> 
</body>
</html>