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
	
	//Trae todas las sucursales.
	@SuppressWarnings("unchecked")
	public List<Sucursal> getSucursales()
	{
		Session session = sf.openSession();
		List<Sucursal> list = (List<Sucursal>)session.createQuery("from Sucursal").list();
		
		session.close();

		return list;
	}
	
	//Trae una sucursal.
	public Sucursal getSucursalPorId(Integer sucursalId)
	{
		Session session = sf.openSession();
		Sucursal laSucursal = (Sucursal)session.createQuery("FROM Sucursal suc WHERE suc.sucursal_id = ?").setInteger(0, sucursalId).uniqueResult();
		
		session.close();

		return laSucursal;
	}	
	
	

	//Busqueda por nombre
	public Sucursal getSucursalPorNombre(String sucursalNombre){
		Session session = sf.openSession();
		//Busca por nombre
		Sucursal suc  = (Sucursal)session.createQuery("FROM Sucursal suc WHERE suc.name= ?").setString(0, sucursalNombre)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return suc;
	}
	
	//maneja sucursal area sector mozo reserva

	//Trae todas las areas.
	@SuppressWarnings("unchecked")
	public List<Area> getAreas()
	{
		Session session = sf.openSession();
		List<Area> list = (List<Area>)session.createQuery("from Area").list();
		
		session.close();

		return list;
	}
	
	//Trae un area.
	public Area getAreaPorId(Integer areaId)
	{
		Session session = sf.openSession();
		Area unArea = (Area)session.createQuery("FROM Area are WHERE are.area_id = ?").setInteger(0, areaId).uniqueResult();
		
		session.close();

		return unArea;
	}	
	
	

	//busqueda x name
	public Area getAreaPorNombre(String AreaNombre){
		Session session = sf.openSession();
		//Busca x name
		Area unArea  = (Area)session.createQuery("FROM Area are WHERE suc.name= ?").setString(0, AreaNombre)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return unArea;
	}
	
}
