package DAO;

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
		
		session.persist(obj);
			
		session.flush();
		session.close();
	}
}
