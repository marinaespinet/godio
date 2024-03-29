package servlets;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exceptions.RestaurantException;
import Interfaces.*;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
          String action = request.getParameter("action");
          String jspPage = "/index.jsp";

          if ((action == null) || (action.length() < 1))
          {
              action = "default";
          }

          if ("default".equals(action))
          {
              jspPage = "/index.jsp";
          }
          else if ("displayMenu".equals(action))
          {
              //List<Cliente> clientes = AdminCliente.getInstancia().getClientes();
              //request.setAttribute("clientes", clientes);
              jspPage = "/MostrarLista.jsp";
          }
          else if ("doStockTransfer".equals(action))
          {
        	    Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");
        	    	return;
        	    }
        	    
        	try{	        		            	    	
        		//TODO: Validaciones aqui y en el Form .JSP con javascript 
        		Integer prod = Integer.parseInt(request.getParameter("prod"));
        		String motivo = request.getParameter("motivo");
        		String lote = request.getParameter("lote");
        		Integer cant = Integer.parseInt(request.getParameter("cant"));
        		
        		BusinessDelegate.getInstancia().transferenciaStockByLoginId( 
        				prod, loginId, 
        				motivo, cant, lote);
        		
        		request.setAttribute("message", "Transferencia de Stock satisfactoria");
        		request.setAttribute("goTo", "index.jsp");		    
        		jspPage = "/Success.jsp";   
        	} catch (RestaurantException re) {        
        		request.setAttribute("message",re.getMessage());
        		request.setAttribute("goTo", "index.jsp");		    
        		jspPage = "/Error.jsp";   

        	} catch (RemoteException re) {        
        		request.setAttribute("message",re.getMessage());
        		request.setAttribute("goTo", "index.jsp");		    
        		jspPage = "/Error.jsp";   
        	}
          }
          else if ("FormStockTransfer".equals(action))
          {
              //String id = request.getParameter("id");
              //Cliente cliente = AdminCliente.getInstancia().getCliente(id);
              //request.setAttribute("cliente", cliente);
          	
              jspPage = "/Form_StockTransfer.jsp";            
          }         
          else if ("doPlanProd".equals(action))
          {
        	    Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");
        	    	return;
        	    }
      	    
             	try{	        		                	            	    	
            		//TODO: Validaciones aqui y en el Form .JSP con javascript 
            		Integer semi = Integer.parseInt(request.getParameter("semi"));
            		Integer cant = Integer.parseInt(request.getParameter("cant"));
            		
            		BusinessDelegate.getInstancia().addTareaPlanProduccion(semi, cant, loginId);
            		
            		request.setAttribute("message", "Agregado de tarea al Plan en forma satisfactoria");
            		request.setAttribute("goTo", "index.jsp");		    
            		jspPage = "/Success.jsp";   
            	} catch (RestaurantException re) {        
            		request.setAttribute("message",re.getMessage());
            		request.setAttribute("goTo", "index.jsp");		    
            		jspPage = "/Error.jsp";   

            	} catch (RemoteException re) {        
            		request.setAttribute("message",re.getMessage());
            		request.setAttribute("goTo", "index.jsp");		    
            		jspPage = "/Error.jsp";   
            	}          
          }

          dispatch(jspPage, request, response);
      }
  
      protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
          if (jsp != null)
          {
          	/*Env�a el control al JSP que pasamos como par�metro, y con los 
          	 * request / response cargados con los par�metros */
              RequestDispatcher rd = request.getRequestDispatcher(jsp);
              rd.forward(request, response);
          }
      }

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
          doPost(request, response);
      }

}

