package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

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
	
	
	public Producto getProducto(Integer id)
	{
		Session session = sf.openSession();
		Producto obj = (Producto)session.get(Producto.class, id);
		
		session.close();
		return obj;
	}
	
}
