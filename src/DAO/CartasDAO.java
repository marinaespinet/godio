package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		//Busca x ID ?
		Item_Carta item  = (Item_Carta)session.get(Item_Carta.class, id);
		
		session.close();

		return item;
	}
}
