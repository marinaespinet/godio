package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class FacturasDAO {
	private static FacturasDAO instancia = null;
	private static SessionFactory sf = null;

	public static FacturasDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new FacturasDAO();
		} 
		return instancia;
	}
	
	
	//Graba factura
	public void grabarFactura(Factura aux){				
		Session session = sf.openSession();
		session.persist(aux);
		session.flush();
		session.close();
	}
}
