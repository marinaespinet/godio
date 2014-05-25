//maneja sucursal area sector mozo reserva mesas

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
	
	//MANEJO DE SUCURSALES
	
	//Trae todas las sucursales.
	@SuppressWarnings("unchecked")
	public List<Sucursal> getSucursales()
	{
		Session session = sf.openSession();
		List<Sucursal> list = (List<Sucursal>)session.createQuery("FROM Sucursal").list();
		
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
	
	
	//MANEJO DE AREAS
	
	//Trae todas las areas.
	@SuppressWarnings("unchecked")
	public List<Area> getAreas()
	{
		Session session = sf.openSession();
		List<Area> list = (List<Area>)session.createQuery("FROM Area").list();
		
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
		Area unArea  = (Area)session.createQuery("FROM Area are WHERE are.name= ?").setString(0, AreaNombre)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return unArea;
	}
	

	//MANEJO DE SECTORES
	
	//Trae todos los sectores.
	@SuppressWarnings("unchecked")
	public List<Sector> getSectores()
	{
		Session session = sf.openSession();
		List<Sector> list = (List<Sector>)session.createQuery("FROM Sector").list();
		
		session.close();

		return list;
	}
	
	//Trae un sector.
	public Sector getSectorPorId(Integer sectorId)
	{
		Session session = sf.openSession();
		Sector unSector = (Sector)session.createQuery("FROM Sector sec WHERE sec.sector_id = ?").setInteger(0, sectorId).uniqueResult();
		
		session.close();

		return unSector;
	}	
	
	

	//busqueda x name
	public Sector getSectorPorNombre(String SectorNombre){
		Session session = sf.openSession();
		//Busca x name
		Sector unSector  = (Sector)session.createQuery("FROM Sector sec WHERE sec.name= ?").setString(0, SectorNombre)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return unSector;
	}
	
	//MANEJO DE MOZOS
	
	//Trae todos los mozos.
	@SuppressWarnings("unchecked")
	public List<Mozo> getMozos()
	{
		Session session = sf.openSession();
		List<Mozo> list = (List<Mozo>)session.createQuery("FROM Mozo").list();
		
		session.close();

		return list;
	}
	
	//Trae un Mozo.
	public Mozo getMozoPorId(Integer mozoId)
	{
		Session session = sf.openSession();
		Mozo unMozo = (Mozo)session.createQuery("FROM Mozo moz WHERE moz.mozo_id = ?").setInteger(0, mozoId).uniqueResult();
		
		session.close();

		return unMozo;
	}	
	
	

	//busqueda x name
	public Mozo getMozoPorNombre(String MozoNombre){
		Session session = sf.openSession();
		//Busca x name
		Mozo unMozo  = (Mozo)session.createQuery("FROM Mozo moz WHERE moz.name= ?").setString(0, MozoNombre)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return unMozo;
	}

	//MANEJO DE RESERVAS
	
	//Trae todas las reservas.
	@SuppressWarnings("unchecked")
	public List<Reserva> getReservas()
	{
		Session session = sf.openSession();
		List<Reserva> list = (List<Reserva>)session.createQuery("FROM Reserva").list();
		
		session.close();

		return list;
	}
	
	//Trae una reserva.
	public Reserva getReservaPorId(Integer reservaId)
	{
		Session session = sf.openSession();
		Reserva unaReserva = (Reserva)session.createQuery("FROM Reserva resv WHERE resv.reserva_id = ?").setInteger(0, reservaId).uniqueResult();
		
		session.close();

		return unaReserva;
	}	
	
	

	//busqueda x fecha
	public Reserva getReservaPorFecha(Date fechaReserva){
		Session session = sf.openSession();
		//Busca x name
		Reserva unaReserva  = (Reserva)session.createQuery("FROM Reserva resv WHERE resv.fecha= ?").setDate(0, fechaReserva).setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		return unaReserva;
	}
	
	
	//insertar una reserva
	public void setReserva(Reserva resv){
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(resv);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	//MANEJO DE MESAS
	
		//Trae todas las mesas.
		@SuppressWarnings("unchecked")
		public List<Mesa> getMesas()
		{
			Session session = sf.openSession();
			List<Mesa> list = (List<Mesa>)session.createQuery("FROM Mesa").list();
			
			session.close();

			return list;
		}
		
		//Trae una mesa por Id.
		public Mesa getMesaPorId(Integer mesaId)
		{
			Session session = sf.openSession();
			Mesa unaMesa = (Mesa)session.createQuery("FROM Mesa mes WHERE mes.mesa_id = ?").setInteger(0, mesaId).uniqueResult();
			
			session.close();

			return unaMesa;
		}	
		
	
}
