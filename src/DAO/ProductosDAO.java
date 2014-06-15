package DAO;

import java.util.List;

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
	
	public List<Ingrediente> getIngredientes(Integer idPlato){
		Session session = sf.openSession();
		List<Ingrediente> ing = (List<Ingrediente>)session.createQuery("FROM Ingrediente i JOIN i.ingrediente_plato p where p.plato_id=?").setInteger(0, idPlato).list();
		session.close();
		return ing;
	}
	
	public List<Producto> getProductos(){
		Session session = sf.openSession();
		List<Producto> prod = (List<Producto>)session.createQuery("FROM Producto p Order by Name").list();
		session.close();
		return prod;
	}
}
