package SERVER;

import java.util.*;

import BUSINESS.*;
import DAO.*;
import DTO.Item_Pedido;
import DTO.Item_Plan_Produccion;
import ENTITY.*;
import Exceptions.RestaurantException;


public class TDD_Schere {

	public static void main(String[] args) throws RestaurantException {
		// TODO Auto-generated method stub
		
		
		unitTestUsuarios();
		unitTestLogin();
		unitTestPlanProd();
		unitTestComprasRealizar();
		unitTestAgregarItemPedido();
		unitTestAddPlanProduccion();
	}
	
	public static boolean unitTestAddPlanProduccion() throws RestaurantException{
		System.out.print("Test Add Items Plan Prod: ");
		List<DTO.Item_Plan_Produccion> items = new ArrayList<DTO.Item_Plan_Produccion>();  
		DTO.Item_Plan_Produccion it = new Item_Plan_Produccion();
		it.setCantidad(3);
		it.setSucursalID(3);
		it.setSemielaboradoID(3);
		
		items.add(it);
		
		it = new Item_Plan_Produccion();
		it.setCantidad(111);
		it.setSucursalID(4);
		it.setSemielaboradoID(3);
		
		items.add(it);
		ProduccionController.getInstancia().addTareasPlanProduccion(items);
		
		System.out.println("OK");
		return true;
		
	}
	
	public static boolean unitTestComprasRealizar(){
		System.out.print("Test Compras a Realizar: ");
		List<DTO.Insumo> insumos = ComprasController.getInstancia().getListadoDeComprasARealizar();
		for(DTO.Insumo ins : insumos)
			System.out.println(ins.getName());
		System.out.println("OK");
		return true;
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
	
	public static boolean unitTestPlanProd(){
		System.out.print("Test PLAN PROD: ");
		Plan_Produccion plan = new Plan_Produccion();
		
		PlanProduccionDAO.getInstancia().grabarPlanProduccion(plan);
		
		System.out.println("OK");
		return true;
	}
	
	public static boolean unitTestAgregarItemPedido(){
		
		System.out.print("Test TestAgregarItemPedido: ");
		DTO.Item_Pedido item = new Item_Pedido(1,1,123);
		PedidosController.getInstancia().agregarItemsPedido(item);		
		
		System.out.println("OK");
		return true;
		
	}

}
