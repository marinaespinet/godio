<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Operacion Realizada con Exito</title>
</head>
 <body>

         <%
	String message = (String)request.getAttribute("message");
    String goTo = (String)request.getAttribute("goTo");	
	%>
        <h1>Exito</h1>        
        <p><%=message%></p>
       
        <br><br><br>
        <p>Por favor, toque continuar.</p>
        <br><br>
        <form action="<%=goTo%>" method="POST">
            <input type="SUBMIT" value="continuar"/>
        </form>
    </body>
</html>