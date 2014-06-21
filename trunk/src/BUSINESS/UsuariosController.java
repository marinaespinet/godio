package BUSINESS;

import ENTITY.*;
import Exceptions.RestaurantException;

public class UsuariosController {
	private static UsuariosController instancia = null;

	public static UsuariosController getInstancia(){
		if(instancia == null){			
			instancia = new UsuariosController();
		} 
		return instancia;
	}
	
	public Integer tryLogin(String user, String password){
		Usuario usu = DAO.UsuariosDAO.getInstancia().getUsuario(user);
		if(usu == null)
			return -1; //user not exist
		
		Login log = new Login();
		log.setUser(usu);
		DAO.LoginDAO.getInstancia().grabarLogin(log);
		
		return log.getLogin_id();
	}
	
	public void logout(Integer loginID) throws RestaurantException{
		Login log = DAO.LoginDAO.getInstancia().getLogin(loginID);
		
		if(log==null)
			{ throw new RestaurantException("Login id  "+loginID.toString()+ " inexistente.");}
		
		log.setFecha_logout_dt(BUSINESS.RestauranteController.getInstancia().getTodayDate());
		DAO.LoginDAO.getInstancia().grabarLogin(log);
	}
	
	public Usuario getLogedUser(Integer loginId) throws RestaurantException{
		Login log = DAO.LoginDAO.getInstancia().getLogin(loginId);
		
		if(log==null)
			{ throw new RestaurantException("Login id  "+loginId.toString()+ " inexistente.");}
		
		Usuario user = log.getUser();
		if(user==null)
			{ throw new RestaurantException("Usuario logueado es inexistente.");}
		
		return user;				
	}
}
