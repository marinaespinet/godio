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
		Pedido ped = (Pedido)session.get(Pedido.class, id);
		
		session.close();

		return ped;
	}
	
	//Listar Items de un pedido
	
	public List<Item_Pedido> getItems (int id){
		Session session = sf.openSession();
		List<Item_Pedido> list = (List<Item_Pedido>)session.createQuery("SELECT p.items FROM Pedido p JOIN p.items i WHERE p.pedido_id=?").setInteger(0, id).list();
		session.close();
		return list;
	}
	
	//Listar pedidos por estado
	
	public List<Pedido> getPedidosPorEstado(String estado)
	{
		Session session = sf.openSession();
		List<Pedido> list = (List<Pedido>)session.createQuery("Select p from Pedido p JOIN p.pedido_estado e where e.estado_name=?").setString(0,estado).list();
		session.close();
		return list;
	}

}

