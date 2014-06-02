package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import DTO.Item_Carta;
import ENTITY.*;

public class CartasDAO {

	private static CartasDAO instancia = null;
	private static SessionFactory sf = null;

	public static CartasDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new CartasDAO();
		} 
		return instancia;
	}
	
	//busqueda x ID
	public Item_Carta getItemCarta(int id){
		Session session = sf.openSession();
		//Busca x ID 
		Item_Carta item  = (Item_Carta)session.get(Item_Carta.class, id);
		
		session.close();

		return item;
	}

	public Item_Carta getItemCartaPorPlato(Integer plato_id) {
		Session session = sf.openSession();
		Item_Carta item  = (Item_Carta)session.createQuery("FROM Item_Carta i JOIN i.carta c JOIN i.item_plato pl WHERE c.fecha_expiracion>getDate() AND pl.plato_id=?").setInteger(0,plato_id).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return item;
	}
	
	@SuppressWarnings("unchecked")
	public List<Plato> getPlatosAlternativos(Integer plato_id, String rubro){
		Session session = sf.openSession();
		List<Plato> platos  = (List<Plato>)session.createQuery("FROM Plato pl JOIN Item_Carta i JOIN i.carta c JOIN i.rubro r WHERE c.fecha_expiracion>getDate() AND pl.plato_id<>? AND r.name=? ").setInteger(0,plato_id).setString(1,rubro).list();
		session.close();
		return platos;
	}
	
	public Rubro_Carta getRubro(String rubro){
		Session session = sf.openSession();
		Rubro_Carta r  = (Rubro_Carta)session.createQuery("FROM Rubro_Carta rub WHERE rub.name=?").setString(0,rubro).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return r;
	}
}
