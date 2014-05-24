package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


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
	
	public void grabarUsuario(UsuarioDTO usuario){
		/*Convierto el parametro a bean*/
		UsuarioBean aux = new UsuarioBean();
		aux.setId(usuario.getId());
		aux.setNombre(usuario.getNombre());
		aux.setCuit(usuario.getCuit());
		/*Abro sesion y grabo el objeto*/
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(aux);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	public List<UsuarioDTO> getUsuarios()
	{
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		UsuarioDTO aux = null;
		Session session = sf.openSession();
		List<UsuarioBean> list = session.createQuery("from UsuarioBean").list();
		for(UsuarioBean u: list)
		{
			aux = new UsuarioDTO(u.getId(), u.getNombre(), u.getCuit());
			usuarios.add(aux);
		}
		session.close();

		return usuarios;
	}

}
