package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Interfaces.BusinessDelegate;

public class Controlador extends HttpServlet {

	private static final long serialVersionUID = 1087702007634924L;
	
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
                //String id = request.getParameter("id");
                //Cliente cliente = AdminCliente.getInstancia().getCliente(id);
                //request.setAttribute("cliente", cliente);

            	BusinessDelegate.getInstancia().transferenciaStockByAreaSuc(1, 1, 1, 1, "test", 2, "Lote4");
            	//jspPage = "/ShowMesa_TransOK.jsp";   
            }
            else if ("stockTransfer".equals(action))
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
