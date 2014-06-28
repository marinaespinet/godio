package servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Item_Pedido;
import Exceptions.RestaurantException;
import Interfaces.*;

/**
 * Servlet implementation class Controller2
 */
@WebServlet("/Controller3")
public class Controller3 extends HttpServlet {
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
          else if ("doSetPlatoListo".equals(action))
          {

        	try{	        		    
        		Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");}
        	    
        	    Integer idItem = Integer.parseInt(request.getParameter("itemPedidoID"));
        	    	
        	    List<DTO.Item_Pedido> items =  new ArrayList<DTO.Item_Pedido>();
        	    DTO.Item_Pedido it = new Item_Pedido();
        	    it.setItem_id(idItem);
        	    items.add(it);
        	    
        	   BusinessDelegate.getInstancia().marcarItemPedidoPreparado(items);
        		
        		jspPage = "./Form_PanelPlatos.jsp";   
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
          else if ("doAbrirMesa".equals(action))
          {

        	try{	        		    
        		Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");}
        	    
        	    Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
        	    Integer mozoId= BusinessDelegate.getInstancia().getMozoDeLogin(loginId);
        	    List<Integer> mesas = BusinessDelegate.getInstancia().abrirMesa(mozoId, cantidad);
        	    if (mesas.size()==1)
        	    	request.setAttribute("message", "Por favor, ubique a los comensales en la mesa: "+mesas.get(0).toString());
        	    else
        	    	request.setAttribute("message", "Por favor, ubique a los comensales en las mesas: "+mesas.get(0).toString()+" y "+mesas.get(1).toString());
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
          else if ("doSolicitarFactura".equals(action))
          {

        	try{	        		    
        		Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");}
        	    
        	    Integer mesa = Integer.parseInt(request.getParameter("mesa"));
        	    Integer factura = BusinessDelegate.getInstancia().solicitarfactura(mesa);
        	    request.setAttribute("message", "Se creó la factura nro: "+factura+" para la mesa "+mesa);
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
          else if ("doCerrrarMesa".equals(action))
          {

        	try{	        		    
        		Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		  Integer suc = BusinessDelegate.getInstancia().getSucursalDeLogin(loginId);
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");}
        	    
        	    Integer mesa = Integer.parseInt(request.getParameter("mesa"));
        	    BusinessDelegate.getInstancia().cerrarPedido(mesa,suc);
        	    request.setAttribute("message", "Se cerró el pedido de la mesa "+mesa);
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
          else if ("doAgregarPlato".equals(action))
          {

        	try{	        		    
        		Integer loginId = (Integer)request.getSession().getAttribute("loginId");  
        		if(loginId == null ) loginId = 0;

        	    if ( loginId == -1 || loginId == 0) {
        	    	response.sendRedirect("./Login.jsp");}
        	    
        	    
        	    Integer nroPlato = Integer.parseInt(request.getParameter("nroPlato"));
        	    Integer cant = Integer.parseInt(request.getParameter("cant"));
        	    Integer mesa = Integer.parseInt(request.getParameter("mesa"));
        	    Integer sucursal = BusinessDelegate.getInstancia().getSucursalDeLogin(loginId);
        	    
        	    BusinessDelegate.getInstancia().agregarPlato(nroPlato,cant,sucursal,mesa);
        	    
        	    request.setAttribute("message", "Se agrego el plato al pedido");
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

          dispatch(jspPage, request, response);
      }
  
      protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
          if (jsp != null)
          {
          	/*Envía el control al JSP que pasamos como parámetro, y con los 
          	 * request / response cargados con los parámetros */
              RequestDispatcher rd = request.getRequestDispatcher(jsp);
              rd.forward(request, response);
          }
      }

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
      {
          doPost(request, response);
      }

}

