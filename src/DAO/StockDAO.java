package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class StockDAO {
	private static StockDAO instancia = null;
	private static SessionFactory sf = null;

	public static StockDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new StockDAO();
		} 
		return instancia;
	}

	public Stock getStock(int prodID, int depoID){
		Session session = sf.openSession();
		Stock obj =(Stock)session.createQuery("SELECT s FROM Stock s " 
				+ " JOIN s.producto p JOIN s.stock_deposito d WHERE p.producto_id=:prod" 
				+ " AND d.deposito_id=:depo")
				.setInteger("prod", prodID).setInteger("depo", depoID).setFirstResult(0).setMaxResults(1).uniqueResult();
			
		session.close();

		return obj;
	}
	
	
	public void grabarTransferenciaStock(Movimiento_Stock obj){				
		Session session = sf.openSession();
		
		session.persist(obj);
			
		session.flush();
		session.close();
	}
	
	public void grabarStock(Stock obj){				
		Session session = sf.openSession();
		
		session.saveOrUpdate(obj);
			
		session.flush();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Stock> getStockPorDeposito(Integer depoID) {
		Session session = sf.openSession();
		List<Stock> elStock =(List<Stock>)session.createQuery("SELECT s FROM Stock s " 
				+ " JOIN s.stock_deposito d WHERE " 
				+ " d.deposito_id=:depo")
				.setInteger("depo", depoID).list();
			
		session.close();

		return elStock;
	}
	
	public Long verificarStockPorPlato (Integer plato,Integer cant, Integer depo){
		Session session = sf.openSession();
		Long NoTengoStock = (Long)session.createQuery("SELECT COUNT (s.cantidad) FROM Ingrediente ing JOIN ing.ingrediente_plato pl JOIN ing.insumo ins JOIN ins.stock s JOIN s.stock_deposito d WHERE pl.plato_id=? AND d.deposito_id=? AND s.cantidad/ing.cantidad<?").setInteger(0,plato).setInteger(1, depo).setInteger(2,cant).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return NoTengoStock;
	}

	@SuppressWarnings("unchecked")
	public List<ENTITY.Movimiento_Stock> getMovimientosStockPorDeposito(int depoID) {
		Session session = sf.openSession();
		List<ENTITY.Movimiento_Stock> losMovimientos =(List<ENTITY.Movimiento_Stock>)session.createQuery("SELECT s FROM Movimiento_Stock mov " 
				+ " JOIN mov.deposito_origen ori " 
				+ " JOIN mov.deposito_destino des "
				+ " WHERE ori.deposito_id = ?"
				+ " OR des.deposito_id = ?")
				.setInteger(0, depoID).setInteger(1, depoID).list();
			
		session.close();
		return losMovimientos;
	}
}
