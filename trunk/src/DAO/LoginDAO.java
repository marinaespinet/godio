package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class LoginDAO {
	private static LoginDAO instancia = null;
	private static SessionFactory sf = null;

	public static LoginDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new LoginDAO();
		} 
		return instancia;
	}
	
	public Integer grabarLogin(Login aux){				
		Session session = sf.openSession();
		
		session.saveOrUpdate(aux);
			
		session.flush();
		session.close();
		
		return aux.getLogin_id();
	}
	
	public Login getLogin(Integer id)
	{
		Session session = sf.openSession();
		Login obj = (Login)session.get(Login.class, id);
		
		session.close();
		return obj;
	}
	
	public Login getLoginActualDeMozo(Usuario usr){
		Session session = sf.openSession();
		Integer loginId = (Integer)session.createQuery("SELECT l.login_id FROM Login l JOIN l.user u WHERE u.user_id=? ORDER BY l.fecha_login_dt DESC").setInteger(0,usr.getUser_id()).setFirstResult(0).setMaxResults(1).uniqueResult();
		System.out.println(loginId);
		return getLogin(loginId);
	}
}
