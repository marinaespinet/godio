
<%@ page import=" java.util.*" %>
<%@include file="./CheckLogin.jsp"%>
<%      
    HashMap<String,HashMap<String,String>> menus = new HashMap<String,HashMap<String,String>>();
    HashMap<String,String> submmenus;
    HashMap<String,String> submmenus2;
 %>
    <ul id="menu">
 <%
    if ( loginId != -1 && loginId != 0) {
 %>
        <li><a href="index.jsp">Inicio</a></li>
 <%          
        
            
            submmenus = new HashMap<String,String>();
            submmenus.put("Abrir Mesa", "Form_AbrirMesa.jsp");
            menus.put("Mesas", submmenus);
            
            submmenus = new HashMap<String,String>();
            submmenus.put("Cerrar mesa", "Form_CerrarMesa.jsp");            
            menus.put("Mesas ", submmenus);
                                   
            submmenus = new HashMap<String,String>();
            submmenus.put("Agregar Plato a Pedido", "Form_AgregarPlato.jsp");
            menus.put("Pedidos", submmenus);
                             
        	submmenus = new HashMap<String,String>();
            submmenus.put("Platos Comandas", "Form_PanelPlatos.jsp");            
            menus.put("Comandas", submmenus);
            
            submmenus = new HashMap<String,String>();
            submmenus.put("Pedido Stock", "Form_StockTransfer.jsp");            
            menus.put("Stock ", submmenus);
            
        	submmenus = new HashMap<String,String>();
            submmenus.put("Solicitar factura", "Form_SolicitarFactura.jsp");            
            menus.put("Facturas", submmenus);
              
            submmenus = new HashMap<String,String>();
            submmenus.put("Nuevo Plan", "FormPlanProd.jsp");
            menus.put("Plan Produccion", submmenus);
                
        for( Iterator itMenu = menus.keySet().iterator(); itMenu.hasNext();) { 
            String menuName = (String)itMenu.next();
            HashMap sub = (HashMap)menus.get(menuName);            
%>            
        <li><a href=?#?><%=menuName%></a>
            <ul>
            
 <%     
            for(Iterator itSub = sub.keySet().iterator(); itSub.hasNext();) {
                 String subMenuName = (String)itSub.next();
                 String subMenuAction = (String)sub.get(subMenuName);
 %>
                <li><a href="<%=subMenuAction%>"><%=subMenuName%></a></li>
 <%
            }
 %>
            </ul>
        </li>
 <%        
        }
 %>
        <li><a href="./Login.jsp">Salir</a></li>
 <%
    }
 %>
    </ul>

                