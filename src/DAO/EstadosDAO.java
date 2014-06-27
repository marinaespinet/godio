package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class EstadosDAO {
	private static EstadosDAO instancia = null;
	private static SessionFactory sf = null;

	public static EstadosDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EstadosDAO();
		} 
		return instancia;
	}
	
	public Estado_Pedido buscarEstadoPedido(String est){				
		Session session = sf.openSession();
		Estado_Pedido estado = (Estado_Pedido)session.createQuery("FROM Estado_Pedido e WHERE e.estado_name=?").setString(0,est).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return estado;
	}
	
	public Estado_Mesa buscarEstadoMesa(Integer est){				
		Session session = sf.openSession();
		Estado_Mesa estado = (Estado_Mesa)session.createQuery("FROM Estado_Mesa e WHERE e.estado_id=?").setInteger(0,est).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return estado;
	}
	
	public Estado_Item_Pedido getEstadoItemPedidoByName(String name){
		Session session = sf.openSession();
		Estado_Item_Pedido estado = (Estado_Item_Pedido)session.createQuery("FROM Estado_Item_Pedido e WHERE e.estado_name=?").setString(0,name).setMaxResults(1).uniqueResult();
		session.close();
		return estado;
	}
	
	public void TestActualizarEstadoInsumo(int estadoID, String newdesc){
		Session session = sf.openSession();
		Estado_Insumo estado = (Estado_Insumo)session.get(Estado_Insumo.class, estadoID);
		estado.setEstado_name(newdesc);
		session.persist(estado);
		session.flush();
		session.close();
		
	}
}
