package SERVER;

import DAO.*;
import ENTITY.*;

public class TDD_Schere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		unitTestUsuarios();
		unitTestLogin();
	}
	
	public static boolean unitTestUsuarios(){
		
		System.out.print("Test USUARIOS y ROLES: ");
		Usuario usu = UsuariosDAO.getInstancia().getUsuario("Cajero1");
		if(usu != null){
			//System.out.print(usu.getUser_id()); //TDD: Espero un 4
			//System.out.print(usu.getUser_rol().getRole_name()); //TDD: Espero Encargado de Caja 
			System.out.println("OK");
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}
	
	public static boolean unitTestLogin(){
		System.out.print("Test LOGIN: ");
		Login log = new Login();
		Usuario usu = UsuariosDAO.getInstancia().getUsuario("Cajero1");
		log.setUser(usu);
		LoginDAO.getInstancia().grabarLogin(log);
		
		System.out.println("OK");
		return true;
	}
	

}
