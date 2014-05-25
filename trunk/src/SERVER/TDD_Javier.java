package SERVER;

import java.util.List;

import DAO.*;
import ENTITY.*;

public class TDD_Javier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		unitTestSucursales();

	}
	
	public static boolean unitTestSucursales(){
		
		System.out.print("Test Sucursales: ");
		List<Sucursal> lasSucursales = LocationDAO.getInstancia().getSucursales();
		if(lasSucursales != null){
			for(Sucursal laSuc : lasSucursales)
				System.out.println("Encontré una sucursal y se llama" + laSuc.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}
	
	/*
	public static boolean unitTestLogin(){
		System.out.print("Test LOGIN: ");
		Login log = new Login();
		Usuario usu = UsuariosDAO.getInstancia().getUsuario("Cajero1");
		log.setUser(usu);
		LoginDAO.getInstancia().grabarLogin(log);
		
		System.out.println("OK");
		return true;
	}
	
	public static boolean unitTestPlanProd(){
		System.out.print("Test PLAN PROD: ");
		Plan_Produccion plan = new Plan_Produccion();
		
		PlanProduccionDAO.getInstancia().grabarPlanProduccion(plan);
		
		System.out.println("OK");
		return true;
	}
	*/

}
