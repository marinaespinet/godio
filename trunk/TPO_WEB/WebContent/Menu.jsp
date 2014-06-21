
<%@ page import=" java.util.*" %>
<%  
    
    Integer loginId = (Integer)session.getAttribute("loginId");    
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
            submmenus.put("Pedido Stock", "Form_StockTransfer");            
            menus.put("Stock ", submmenus);
            
            submmenus = new HashMap<String,String>();
            submmenus.put("Abrir Mesa", "FormAbrirMesa");
            menus.put("Mesas", submmenus);
                             
        	submmenus = new HashMap<String,String>();
            submmenus.put("Cerrar Mesa", "FormCompra");            
            menus.put("Mesas", submmenus);
              
            submmenus = new HashMap<String,String>();
            submmenus.put("Nuevo Plan", "FormPlanProd");
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

                <%/*  </ul>
 <ul id="menu">
    <li><a href=?#?>Inicio</a></li>
    <li><a href=?#?>Opcion 1</a>
        <ul>
            <li><a href=?#?>submenu1</a></li>
            <li><a href=?#?>submenu1</a></li>
            <li><a href=?#?>submenu1</a></li>
        </ul>
    </li>
    <li><a href=?#?>Opcion 2</a>
        <ul>
            <li><a href=?#?>submenu2</a></li>
            <li><a href=?#?>submenu2</a></li>
            <li><a href=?#?>submenu2</a></li>
        </ul>
    </li>
    <li><a href=?#?>Opcion 3</a>
        <ul>
            <li><a href=?#?>submenu3</a></li>
            <li><a href=?#?>submenu3</a></li>
            <li><a href=?#?>submenu3</a></li>
        </ul>
    </li>
 </ul>*/%>
