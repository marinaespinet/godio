package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class ComprasDAO {
	private static ComprasDAO instancia = null;
	private static SessionFactory sf = null;

	public static ComprasDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ComprasDAO();
		} 
		return instancia;
	}
	
	
	//Trae todos.
	@SuppressWarnings("unchecked")
	public List<Insumo> getComprasRealizar()
	{
		Session session = sf.openSession();
		List<Insumo> list = (List<Insumo>)session.createQuery(""
				+ "SELECT i "				
				+ "FROM Insumo i "
				+ "JOIN i.stock s "
				+ "WHERE s.cantidad <= i.punto_reposicion_cant "
				+ " ").list();			
		
		session.close();

		return list;
	}


	public void setRecepcionCompra(RecepcionCompra recepcionEnt) {
		Session session = sf.openSession();
		session.persist(recepcionEnt);
		session.flush();
		session.close();
			
	}
	
}
