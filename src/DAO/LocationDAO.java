//maneja sucursal area sector mozo reserva mesas

package DAO;

import java.util.*;

import org.hibernate.Query;
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
		Sucursal laSucursal =(Sucursal) session.get(Sucursal.class,sucursalId); 
				//old code: (Sucursal)session.createQuery("FROM Sucursal suc WHERE suc.sucursal_id = ?").setInteger(0, sucursalId).uniqueResult();
		
		
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
	
	public Area getAreaDePlato(Integer plato) {
		Session session = sf.openSession();
		Area unArea  = (Area)session.createQuery("FROM Area are WHERE are.area_id= ?").setInteger(0, plato)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
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
			Mesa unaMesa = (Mesa)session.get(Mesa.class, mesaId);
			
			session.close();
			return unaMesa;
		}

		public void grabarMesa(Mesa aux) {
			Session session = sf.openSession();
			session.beginTransaction();
			session.saveOrUpdate(aux);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}

		@SuppressWarnings("unchecked")
		public List<ENTITY.Mesa> getMesasLibresEnSucursal(Integer sucursal_id, Integer comensales) {
			List<ENTITY.Mesa> laLista = new LinkedList<ENTITY.Mesa>();
			Session session = sf.openSession();
			List<Integer> idsMesa = (List<Integer>)session.createQuery("SELECT me.mesa_id FROM Mesa me JOIN me.mesa_estado es JOIN me.mesa_sucursal su WHERE es.estado_id =1 AND su.sucursal_id =?").setInteger(0, sucursal_id).list();
			for(Integer o:idsMesa){
				laLista.add(getMesaPorId(o));
			}
			session.close();

			return laLista;
			
		}	
		
		public void grabarMesaActualizada(Mesa aux) {
			Session session = sf.openSession();
			session.beginTransaction();
			session.merge(aux);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}	
		
		public Long getCantReservas(int sucursal_id){
			Date hoy = new java.sql.Date(System.currentTimeMillis());
			Session session = sf.openSession();
			Long cantReservas = (Long)session.createQuery("SELECT COUNT(*) FROM Reserva res JOIN res.sucursal suc WHERE suc.sucursal_id=? and res.fecha-res.minutos_duracion<?").setInteger(0,sucursal_id).setDate(1, hoy).setFirstResult(0).setMaxResults(1).uniqueResult();
			session.close();
			return cantReservas;
		}
		
		
		//Depositos
		public Deposito getDeposito(Integer depoID)
		{
			Session session = sf.openSession();
			Deposito obj = (Deposito)session.get(Deposito.class, depoID);
			
			session.close();
			return obj;
		}
		
		public Deposito getDepositoPorAreaSucursal(Integer areaID, Integer sucID)
		{
			Session session = sf.openSession();
			Deposito obj = (Deposito)session.createQuery("SELECT d FROM Deposito d JOIN d.deposito_area a JOIN d.sucursal s WHERE a.area_id=:area AND s.sucursal_id=:suc").setInteger("area", areaID).setInteger("suc", sucID).uniqueResult();
			
			session.close();

			return obj;
		}
		
		public Deposito getDepositoPorAreaSucursal( Integer sucID, String area)
		{
			Session session = sf.openSession();
			Deposito obj = (Deposito)session.createQuery("SELECT d FROM Deposito d JOIN d.deposito_area a JOIN d.sucursal s WHERE a.name=:area AND s.sucursal_id=:suc").setString("area", area).setInteger("suc", sucID).uniqueResult();
			
			session.close();

			return obj;
		}

		@SuppressWarnings("unchecked")
		public List<Mozo> getMozosPorSucursal(int sucId) {
			Session session = sf.openSession();
			List<Mozo> list = (List<Mozo>)session.createQuery(""
					+ "SELECT m FROM Mozo m"
					+ " JOIN m.mozo_sector sec"
					+ " JOIN sec.sector_sucursal suc"
					+ " WHERE suc.sucursal_id = ?").setInteger(0, sucId).list();
			
			session.close();

			return list;
		}



}
