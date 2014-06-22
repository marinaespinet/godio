<%@page import="Interfaces.*"%>
<%@page import="DTO.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Platos a preparar</title>

</head>
<body>


<%
		//List<DTO.Producto> productos=  BusinessDelegate.getInstancia().getProductos();
		List<DTO.Semielaborado> semis=  BusinessDelegate.getInstancia().getSemielaborados();
		
		List<DTO.Item_Pedido> losItemsPedidoPendientesDTO = BusinessDelegate.getInstancia().getItemPedidosPendientesDTO(1,1);
%>

<table border="1">
<thead>
<tr bgcolor="yellow">
	<td>Plato</td>
	<td>Cant</td>
	<td>Accion</td>
	</tr>
</thead>
<% for(Item_Pedido item : losItemsPedidoPendientesDTO ) { %>
	<tr>
		<td>
			<%=item.getDescripcionPlatoContenido() %>
		</td>	
		<td>
			<%=item.getCantidad() %></a>
		</td>	
		<td>
			<a href="Controller2?action=doSetPlatoListo&itemPedidoID=<%=item.getItem_id()%>" target="_self">Listo</a>
		</td>	
	</tr>
<% }  %>
</table>	
	
	 
  
  
</body>
</html>