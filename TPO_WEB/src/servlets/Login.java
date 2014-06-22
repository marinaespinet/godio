
package servlets;
import Interfaces.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

import org.apache.tomcat.util.http.Cookies;

import Exceptions.*;


public class Login extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        
        String resultPage="index";
        
        try {
        	Integer loginId = BusinessDelegate.getInstancia().userLogin(usuario);
			if ( loginId != -1){
			    resultPage = "/index.jsp";
			    HttpSession session = request.getSession();
			    session.setAttribute("loginId", loginId);	
			    			    
			    response.addCookie(new Cookie("lastUserLogin",usuario));
			}
			else {
			    resultPage = "/Error.jsp";
			    request.setAttribute("message", "Usuario inválido");
			    request.setAttribute("goTo", "./Login.jsp");
			}
        } catch (Exception e){}
        
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
