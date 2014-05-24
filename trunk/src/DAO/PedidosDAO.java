package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class PedidosDAO {

	private static PedidosDAO instancia = null;
	private static SessionFactory sf = null;

	public static PedidosDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new PedidosDAO();
		} 
		return instancia;
	}
	
	public void grabarPedido(Pedido aux){
				
		Session session = sf.openSession();
		session.persist(aux);
		session.close();
	}

	//Trae todos.
	public List<Pedido> getPedidos()
	{
		Session session = sf.openSession();
		List<Pedido> list = (List<Pedido>)session.createQuery("from Pedido").list();
		session.close();
		return list;
	}
	
	//busqueda x ID
	public Pedido getPedido(int id){
		Session session = sf.openSession();
		//Busca x ID ?
		Pedido ped = (Pedido)session.get(Pedido.class, id);
		
		session.close();

		return ped;
	}

}

