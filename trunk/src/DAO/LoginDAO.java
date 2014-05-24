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
	
	public void grabarLogin(Login aux){				
		Session session = sf.openSession();
		
		session.persist(aux);
			
		session.flush();
		session.close();
	}
}
