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
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos()
	{
		Session session = sf.openSession();
		List<Pedido> list = (List<Pedido>)session.createQuery("FROM Pedido").list();
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
	
	//Listar items de una mesa
		@SuppressWarnings("unchecked")
		public List<Item_Pedido> getItems (int id){
			Session session = sf.openSession();
			List<Item_Pedido> list = (List<Item_Pedido>)session.createQuery("SELECT p.items FROM Pedido p WHERE p.pedido_id=? ").setInteger(0, id).list();
			session.close();
			return list;
		}
	
	//Listar items pendientes de una mesa
	@SuppressWarnings("unchecked")
	public List<Item_Pedido> getItemsPendientesDeMesa (int id){
		Session session = sf.openSession();
		List<Item_Pedido> list = (List<Item_Pedido>)session.createQuery("SELECT p.items FROM Pedido p JOIN p.items i JOIN i.estado e WHERE p.pedido_id=? and e.estado_name='Pendiente'").setInteger(0, id).list();
		session.close();
		return list;
	}
	
	//Verifica que no haya items pendientes en un pedido
		public Long verificarItemsPendientesDelPedido (Integer id){
			Session session = sf.openSession();
			Long conteo = (Long)session.createQuery("SELECT COUNT(i.estado)FROM Pedido p JOIN p.items i JOIN i.estado e WHERE p.pedido_id=? and e.estado_name='Pendiente'").setInteger(0, id).setFirstResult(0).setMaxResults(1).uniqueResult();
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
		
		@SuppressWarnings("unchecked")
		public List<Pedido> getPedidosPorEstado(String estado)
		{
			Session session = sf.openSession();
			List<Pedido> pedidos = (List<Pedido>)session.createQuery("FROM Pedido p JOIN p.pedido_estado e WHERE e.estado_name=?").setString(0, estado);
			session.close();
			return pedidos;
		}

				
		//Calcula el monto a partir del precio de los platos 
		//"No facturar=falso" y cantidad pedida de c/u
		public Double calcularMonto(int pedido){
			Session session = sf.openSession();
			Double monto = (Double)session.createQuery("SELECT SUM(itc.precio_monto*itp.cantidad) FROM Pedido p JOIN p.items itp JOIN itp.item_carta itc WHERE p.pedido_id=? AND itp.item_no_facturar_ind=false").setInteger(0,pedido).setFirstResult(0).setMaxResults(1).uniqueResult();
			return monto;
		}

		public void grabarPedidoActualizado(Pedido aux) {
		
				Session session = sf.openSession();
				session.beginTransaction();
				session.merge(aux);
				session.flush();
				session.getTransaction().commit();
				session.close();
			}	
			
	
		public Item_Pedido getItemPedidoPorId(Integer item_id) {
			Session session = sf.openSession();
			Item_Pedido elItem =(Item_Pedido) session.get(Item_Pedido.class,item_id); 
			session.close();
			return elItem;
		}

		@SuppressWarnings("unchecked")
		public List<Item_Pedido> getItemsPendientesDeArea(int sucId, int areaId) {
			Session session = sf.openSession();
			List<ENTITY.Item_Pedido> losItemsPedido = (List<ENTITY.Item_Pedido>) session.createQuery("SELECT it FROM Item_Pedido it " 
				+ " JOIN it.Estado_Item_Pedido es"
				+ " JOIN it.Pedido ped"
				+ " JOIN ped.pedido_mesa mes"
				+ " JOIN mes.mesa_sucursal suc"
				+ " JOIN Estado_Item_Pedido est"
				+ " WHERE " 
				+ " suc.sucursal_id=?"
				+ " AND"
				+ " it.item_area_id=?"
				+ " AND "
				+ "est.estado_id = 1")
				.setInteger(0, sucId).setInteger(1, areaId).list();
			return losItemsPedido;
		}

		public Plato getPlatoPorId(Integer plato_id) {
			Session session = sf.openSession();
			Plato elPlato =(Plato) session.get(Plato.class,plato_id); 
			session.close();
			return elPlato;
		}

}

