<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.*"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
String lastUser="";

Cookie[] cookies = request.getCookies();

for(Cookie cookie : cookies){
    if("lastUserLogin".equals(cookie.getName())){
    	lastUser = cookie.getValue();
    }
}


%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="cuerpo">
            <h3>Login</h3>
            <p>Por favor ingrese su usuario y password para ingresar al sistema</p>
            <form class="formulario" action="Login" method="POST" >
                <fieldset>
                    <legend>Ingreso</legend>                
                    <table>
                        <tr>
                            <td id="usuario">Usuario</td>
                            <td><input type="TEXT" name="usuario" value="<%=lastUser%>"></td>
                        </tr>
                        <tr>
                            <td>Password:</td><td colspan="3"><input type="password" name="pass"></td>
                        </tr>                        
                        <tr class="buttonTD">
                            <td colspan="3"></td><td><input type="SUBMIT" value="Ingresar"></td>
                        </tr>
                    </table>                    
                </fieldset>
            </form>
        </div>
</body>
</html>