package Interfaces;

import Exceptions.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BusinessDelegate {
	private static BusinessDelegate instancia;
	private RemoteInterface ri;
	
	private BusinessDelegate() throws RemoteException
	{
		conexionRemota();
	}
	
	public static BusinessDelegate getInstancia() throws RemoteException
	{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	
	
	private void conexionRemota() throws RemoteException{	
		try{
			ri = (RemoteInterface) Naming.lookup("//localHost/SistemaRemoto");	
		}
		catch(NotBoundException nbe){
			System.out.println("MalformedURLException: "+ nbe.toString());
		}
		catch(MalformedURLException re){
			System.out.println("RemoteException: "+ re.toString());
		}
	}
	
	//TODO: Aqui van los metodos que llaman al SERVER
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) throws RemoteException{
			ri.transferenciaStockByAreaSuc(prodID, loginID, areaId, sucID, motivo, cant, lote);
					
	}
	
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException{
		
		List <DTO.Reclamo> losItems = new ArrayList <DTO.Reclamo>();
		
		try {	
			
			losItems = ri.obtenerItemsParaReclamo(idMesa);
			
		} 	catch (RestaurantException r){
			
			}
		
		return losItems;
		
		}

	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException{
		
		try {	
		
			ri.registrarReclamo(losItemsParaReclamos);
	
		} catch (RestaurantException r){
				
		  }
		
	}
	
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException{
		
	List <DTO.Stock> elStock = new ArrayList <DTO.Stock>();
		
		try {	
			
			elStock = ri.getStockPorDeposito(depoID);
			
		} 	catch (RestaurantException r){
			
			}
		
		return elStock;
		
	}
	
	
	
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException{
		
	List <DTO.Item_Pedido> losItems = new ArrayList <DTO.Item_Pedido>();
		
		try {	
			
			losItems = ri.getItemPedidosPendientesDTO (areaID, sucID);
			
		} 	catch (RestaurantException r){
			
			}
		
		return losItems;
		
	}
		
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException{
		
		try {	
			
			ri.marcarItemPedidoPreparado(losItemsPedidoPendientesDTO);
	
		} catch (RestaurantException r){
				
		  }
		
	}
		
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException{
		
		try {	
			
			ri.setRecepcionCompra(laRecepcion);
	
		} catch (RestaurantException r){
				
		  }
		
	}
	
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException{
		
		try {	
			
			ri.liquidarComisionesMozos(diaLiquidado, sucID);
	
		} catch (RestaurantException r){
				
		  }
		
	}
	
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException{
		
	List <DTO.Movimiento_Stock> losMovimientos = new ArrayList <DTO.Movimiento_Stock>();
		
		try {	
			
			losMovimientos = ri.getMovimientosDeStockPorDeposito(depoID);
			
		} 	catch (RestaurantException r){
			
			}
		
		return losMovimientos;
		
	}


	/*public List<DTO.Producto> getProductos() throws RemoteException {
		return ri.getProductos();
	}
	
	public List<DTO.Area> getAreas() throws RemoteException {
		return ri.getAreas();
	}
	
	public boolean userLogin(String user){
		return true;
	}
	*/
	
}