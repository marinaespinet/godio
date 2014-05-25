package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class LocationDAO {

	private static LocationDAO instancia = null;
	private static SessionFactory sf = null;

	public static LocationDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new LocationDAO();
		} 
		return instancia;
	}
	
	//Trae todas.
	@SuppressWarnings("unchecked")
	public List<Sucursal> getSucursales()
	{
		Session session = sf.openSession();
		List<Sucursal> list = (List<Sucursal>)session.createQuery("from Sucursales").list();
		
		session.close();

		return list;
	}
	
	//Trae una sucursal.
	@SuppressWarnings("unchecked")
	public Sucursal getSucursalPorId(Integer sucursalId)
	{
		Session session = sf.openSession();
		Sucursal laSucursal = (Sucursal)session.createQuery("FROM Sucursal suc WHERE suc.sucursal_id = ?").setInteger(0, sucursalId).uniqueResult();
		
		session.close();

		return laSucursal;
	}	
	
	

	//busqueda x name
	public Sucursal getSucursalPorNombre(String sucursalNombre){
		Session session = sf.openSession();
		//Busca x name
		Sucursal suc  = (Sucursal)session.createQuery("FROM Sucursal suc WHERE suc.name= ?").setString(0, sucursalNombre)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return suc;
	}

}
