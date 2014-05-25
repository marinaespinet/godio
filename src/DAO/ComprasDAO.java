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
	public List<Insumo> getComprasRealizar()
	{
		Session session = sf.openSession();
		List<Insumo> list = (List<Insumo>)session.createQuery(""
				+ "SELECT i "
				+ "FROM Stock s JOIN s.producto p "
				+ "WHERE p.punto_reposicion_cant <= s.cantidad "
				+ " ").list();			
		
		session.close();

		return list;
	}
}
