package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;


public class PlanProduccionDAO {
	private static PlanProduccionDAO instancia = null;
	private static SessionFactory sf = null;

	public static PlanProduccionDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new PlanProduccionDAO();
		} 
		return instancia;
	}
	
	public void grabarPlanProduccion(Plan_Produccion aux){				
		Session session = sf.openSession();
		
		session.persist(aux);
				
		session.close();
	}
	
	public Plan_Produccion nuevoPlanProduccion(){
		Plan_Produccion plan = new Plan_Produccion();
		Session session = sf.openSession();
		session.persist(plan);
		session.flush();
		session.close();
		return plan;
	}
	public Plan_Produccion getPlanProduccion(Integer id)
	{
		Session session = sf.openSession();
		Plan_Produccion obj =(Plan_Produccion) session.get(Semielaborado.class,id); 	
		session.close();

		return obj;
	}
	
	public void grabarItemPlan(Item_Plan_Produccion item)
	{
		Session session = sf.openSession();
		
		session.persist(item);
		
		session.flush();
		session.close();
	}
	
	
	public int getCantidadTareasPendientesAvance(Integer sucursalID, Integer avance){
		/*Retorna la cantidad de tareas de la sucursal 'sucursalID, cuyo avance sea menor a 'avance'
		 * */
		Session session = sf.openSession();
		Long cant = (Long)session.createQuery(""
				+ " select count(*) AS Cant "
				+ " from Item_Plan_Produccion p "
				+ " join p.sucursal s "			
				+ " where s.sucursal_id=:suc " 
				+ " and ((p.item_plan_avance_qty / p.cantidad) *100) < :avance "
				+ "").setInteger("suc",sucursalID).setInteger("avance",avance).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		Integer cantidad = cant.intValue();
		return cantidad;
	}
	
	/*para la regla: Valida que la sucursal posea horas disponibles para produccion y SI posee.*/
	public Double[] getHorasAsignadasAvance(Integer sucursalID){
		Session session = sf.openSession();
		Object[] datos = (Object[])session.createQuery(""
				+ " select " 
				+ " sum(e.horas_elaboracion_cant * p.cantidad) AS HsAsign, "
				+ " sum(p.item_plan_avance_qty * p.cantidad) AS HsAvance "
				+ " from Item_Plan_Produccion p "
				+ " join p.sucursal s "
				+ " join p.semielaborado e  "
				+ " where s.sucursal_id=:suc  "
				+ "").setInteger("suc",sucursalID).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		Double[] valores = new Double[2];
		valores[0] = (Double)datos[0];
		valores[1] = ((Long)datos[1]).doubleValue();
		
		return valores;
	}
	public Item_Plan_Produccion getItemPorSucursalySemielaborado(int sucursal, int semielaborado){
		Session session = sf.openSession();
		Item_Plan_Produccion item = (Item_Plan_Produccion) session.createQuery("FROM Item_Plan_Produccion ipp JOIN ipp.item_plan_semielaborado ips JOIN ipp.item_plan_sucursal suc WHERE suc.sucursal_id=? AND ips.semielaborado_id=? AND ipp.item_plan_avance_qty<1").setInteger(0, sucursal).setInteger(1,semielaborado).setFirstResult(0).setMaxResults(1).uniqueResult();
		return item;
	}
}