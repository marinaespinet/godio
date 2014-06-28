package SERVER;

import java.rmi.RemoteException;
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
		
		//unitTestUpdateEstadoInsumo();
		//unitTestUsuarios();
		//unitTestLogin();
		//unitTestPlanProd();
		//unitTestComprasRealizar();
		//unitTestAgregarItemPedido();
		//unitTestAddPlanProduccion();
		//unitTestCerrarMesa();
		//unitTestCheckStock();
		//unitTestTransferStock();
		//unitTestAddStock();
		//unitTestLogin();
		unitTestGetMesasAbiertasUnLogin(24);
	}

	private static void unitTestGetMesasAbiertasUnLogin(Integer log) throws RestaurantException{
		List<DTO.Mesa> mesas = PedidosController.getInstancia().getMesasAbiertasUnLogin(log);
		
	}
	
	
	private static void unitTestLogin() throws RestaurantException{
		System.out.print("Test LOGIN: ");
		Integer id =UsuariosController.getInstancia().tryLogin("PEPE", "1234");
		if(id==-1) {
			System.out.print("User or pass inexistente.");
		} else {
		System.out.print("LOGIN id= " + id.toString());
		System.out.print("Test LOGIN OK: ");
		
		UsuariosController.getInstancia().logout(id);
		}
	}
	
	private static void unitTestUpdateEstadoInsumo(){
		EstadosDAO.getInstancia().TestActualizarEstadoInsumo(1,"cambiado");
	}
	
	public static boolean unitTestAddStock(){
		Stock st1 = StockDAO.getInstancia().getStock(1, 1);
		
		Stock stk = new Stock();
		stk.setCantidad(3);
		stk.setFecha_vencimiento_producto_dt(st1.getFecha_vencimiento_producto_dt());
		stk.setProducto(st1.getProducto());
		stk.setStock_deposito(st1.getStock_deposito());
		
		StockDAO.getInstancia().grabarStock(stk);
		
		stk.setCantidad(666);
		
		StockDAO.getInstancia().grabarStock(stk);
		
		return true;
	}
	
	public static boolean unitTestCheckStock() throws RemoteException{
		System.out.print("Test check Stock: ");
		
		Integer cant = StockController.getInstancia().getStockCant(1,  1);
		
		System.out.println(cant.toString());
		System.out.println("OK");
		return true;
	}
	public static boolean unitTestTransferStock()throws RestaurantException{
		System.out.print("Test check Stock: ");
		
		//(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) 
		StockController.getInstancia().transferenciaStockByAreaSuc(1, 1, 1, 1, "test", 2, "Lote4");
		
		System.out.println("OK");
		return true;
	}
	
	public static boolean unitTestCerrarMesa() throws RestaurantException{
		System.out.print("Test Cerrar Mesa: ");
		
		PedidosController.getInstancia().cerrarPedido(1,1);
		
		System.out.println("OK");
		return true;
	}
	
	public static boolean unitTestAddPlanProduccion() throws RestaurantException{
		System.out.print("Test Add Items Plan Prod: ");
		List<DTO.Item_Plan_Produccion> items = new ArrayList<DTO.Item_Plan_Produccion>();  
		DTO.Item_Plan_Produccion it = new Item_Plan_Produccion();
		it.setCantidad(3);
		it.setSucursalID(5);
		it.setSemielaboradoID(3);
		
		items.add(it);
		/*
		it = new Item_Plan_Produccion();
		it.setCantidad(111);
		it.setSucursalID(4);
		it.setSemielaboradoID(3);
		*/
		//items.add(it);
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
	
	public static boolean unitTestLogin2(){
		System.out.print("Test LOGIN: ");
		Login log = new Login();
		Usuario usu = UsuariosDAO.getInstancia().getUsuario("Cajero1");
		log.setUser(usu);
		//LoginDAO.getInstancia().grabarLogin(log);
		
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
