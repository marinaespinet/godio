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
	
	public void addItemsPedido(Item_Pedido item){
		Session session = sf.openSession();
		session.persist(item);
		session.flush();
		session.close();
	}
	
	//Obtener el pedido abierto de una mesa
	public Pedido getPedidoAbiertoDeMesa(int mesa)
	{
		Session session = sf.openSession();
		Pedido pedido = (Pedido)session.createQuery("SELECT p FROM Pedido p JOIN p.pedido_estado e JOIN p.pedido_mesa m WHERE e.estado_name='Abierto' AND p.pedido_mesa.mesa_id=?").setInteger(0, mesa).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return pedido;
	}
	
	//Listar items pendientes de una mesa
	public List<Item_Pedido> getItemsPendientesDeMesa (int id){
		Session session = sf.openSession();
		List<Item_Pedido> list = (List<Item_Pedido>)session.createQuery("SELECT p.items FROM Pedido p JOIN p.items i JOIN i.estado e WHERE p.pedido_id=? and e.estado_name='Pendiente'").setInteger(0, id).list();
		session.close();
		return list;
	}
	
	//Verifica que no haya items pendientes de una mesa
		public boolean verificarItemsPendientesDeMesa (int id){
			Session session = sf.openSession();
			boolean conteo = (boolean)session.createQuery("SELECT COUNT(p.items)FROM Pedido p JOIN p.items i JOIN i.estado e WHERE p.pedido_id=? and e.estado_name='Pendiente'").setInteger(0, id).equals(0);
			session.close();
			return conteo;
		}
	
	//Graba un item (update o insert) de un pedido
		public void setItemPedido(Item_Pedido item) {
			Session session = sf.openSession();
			
			session.persist(item);
			
			session.flush();
			session.close();
		}

}

