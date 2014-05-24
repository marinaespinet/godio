package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class UsuariosDAO {

	private static UsuariosDAO instancia = null;
	private static SessionFactory sf = null;

	public static UsuariosDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new UsuariosDAO();
		} 
		return instancia;
	}
	
	public void grabarUsuario(Usuario aux){
				
		Session session = sf.openSession();
		
		session.persist(aux);
		
		session.close();
	}

	//Trae todos.
	public List<Usuario> getUsuarios()
	{
		Session session = sf.openSession();
		List<Usuario> list = (List<Usuario>)session.createQuery("from Usuario").list();
		
		session.close();

		return list;
	}
	
	//busqueda x ID
	public Usuario getUsuario(int id){
		Session session = sf.openSession();
		//Busca x ID ?
		Usuario usu  = (Usuario)session.get(Usuario.class, id);
		
		session.close();

		return usu;
	}
	
	//busqueda x name
	public Usuario getUsuario(String name){
		Session session = sf.openSession();
		//Busca x name
		Usuario usu  = (Usuario)session.createQuery("FROM Usuario WHERE user_name= ?").setString(0, name)
				.setFirstResult(0).setMaxResults(1).uniqueResult();
		
		session.close();

		//Si el name no existe devuelve null.
		return usu;
	}

}
