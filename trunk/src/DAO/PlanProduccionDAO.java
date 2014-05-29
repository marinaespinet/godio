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
}
