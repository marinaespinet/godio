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
	
	public Item_Plan_Produccion getItemPorSucursalySemielaborado(int sucursal, int semielaborado){
		Session session = sf.openSession();
		Item_Plan_Produccion item = (Item_Plan_Produccion) session.createQuery("FROM Item_Plan_Produccion ipp JOIN ipp.item_plan_semielaborado ips JOIN ipp.item_plan_sucursal suc WHERE suc.sucursal_id=? AND ips.semielaborado_id=? AND ipp.item_plan_avance_qty<1").setInteger(0, sucursal).setInteger(1,semielaborado).setFirstResult(0).setMaxResults(1).uniqueResult();
		return item;
	}
}