package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.Semielaborado;
import ENTITY.Sucursal;

public class ProductosDAO {
	private static ProductosDAO instancia = null;
	private static SessionFactory sf = null;

	public static ProductosDAO   getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductosDAO();
		} 
		return instancia;
	}
	
	
	public Semielaborado getSemielaborado(Integer semiId)
	{
		Session session = sf.openSession();
		Semielaborado semi =(Semielaborado) session.get(Semielaborado.class,semiId); 	
		session.close();

		return semi;
	}	
	
}
