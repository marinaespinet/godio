
<%@ page import=" java.util.*" %>
<%  
    
    Integer loginId = (Integer)session.getAttribute("loginId");  
	if(loginId == null ) loginId = 0;

    if ( loginId == -1 || loginId == 0) {
    	response.sendRedirect("./Login.jsp");
    }
 %>