
<%@ page import=" java.util.*" %>
<%@include file="./CheckLogin.jsp"%>
<%      
    HashMap<String,HashMap<String,String>> menus = new HashMap<String,HashMap<String,String>>();
    HashMap<String,String> submmenus;
 %>
    <ul id="menu">
 <%
    if ( loginId != -1 && loginId != 0) {
 %>
        <li><a href="index.jsp">Inicio</a></li>
 <%          
        
            submmenus = new HashMap<String,String>();
            submmenus.put("Pedido Stock", "Form_StockTransfer.jsp");            
            menus.put("Stock ", submmenus);
            
            submmenus = new HashMap<String,String>();
            submmenus.put("Abrir Mesa", "FormAbrirMesa.jsp");
            menus.put("Mesas", submmenus);
                             
        	submmenus = new HashMap<String,String>();
            submmenus.put("Cerrar Mesa", "FormCerrarMesa.jsp");            
            menus.put("Mesas", submmenus);
              
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

                