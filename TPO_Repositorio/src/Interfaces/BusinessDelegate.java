package Interfaces;

import DTO.Insumo;
import DTO.Item_Compra;
import Exceptions.*;

import java.net.MalformedURLException;
import java.rmi.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BusinessDelegate {
	private static BusinessDelegate instancia;
	private RemoteInterface ri;
	
	private BusinessDelegate() throws RemoteException, RestaurantException 
	{
		conexionRemota();
	}
	
	public static BusinessDelegate getInstancia() throws RemoteException, RestaurantException 
	{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	
	
	private void conexionRemota() throws RemoteException, RestaurantException {	
		try{
			System.setSecurityManager(new RMISecurityManager());
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
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) throws RemoteException, RestaurantException {
			ri.transferenciaStockByAreaSuc(prodID, loginID, areaId, sucID, motivo, cant, lote);					
	}
	public void transferenciaStockByLoginId(Integer prodID, Integer loginID, String motivo, Integer cant, String lote) throws RemoteException, RestaurantException {
		ri.transferenciaStockByLoginId(prodID, loginID, motivo, cant, lote);					
}
	
	
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException, RestaurantException {
		
		List <DTO.Reclamo> losItems = new ArrayList <DTO.Reclamo>();
		
		try {	
			
			losItems = ri.obtenerItemsParaReclamo(idMesa);
			
		} 	catch (RestaurantException r){
			
			}
		
		return losItems;
		
		}

	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException, RestaurantException {
		
		try {	
		
			ri.registrarReclamo(losItemsParaReclamos);
	
		} catch (RestaurantException r){
				
		  }
		
	}
	
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException, RestaurantException {
		
	List <DTO.Stock> elStock = new ArrayList <DTO.Stock>();
		
		try {	
			
			elStock = ri.getStockPorDeposito(depoID);
			
		} 	catch (RestaurantException r){
			
			}
		
		return elStock;
		
	}
	
	
	
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException, RestaurantException {
		
	List <DTO.Item_Pedido> losItems = new ArrayList <DTO.Item_Pedido>();
		
		try {	
			
			losItems = ri.getItemPedidosPendientesDTO (areaID, sucID);
			
		} 	catch (RestaurantException r){
			
			}
		
		return losItems;
		
	}
		
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException, RestaurantException {
		
		try {	
			
			ri.marcarItemPedidoPreparado(losItemsPedidoPendientesDTO);
	
		} catch (RestaurantException r){
				
		  }
		
	}
		
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException, RestaurantException {
		
		try {	
			
			ri.setRecepcionCompra(laRecepcion);
	
		} catch (RestaurantException r){
				
		  }
		
	}
	
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException, RestaurantException {
		
		try {	
			
			ri.liquidarComisionesMozos(diaLiquidado, sucID);
	
		} catch (RestaurantException r){
				
		  }
		
	}
	
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException, RestaurantException {
		
	List <DTO.Movimiento_Stock> losMovimientos = new ArrayList <DTO.Movimiento_Stock>();
		
		try {	
			
			losMovimientos = ri.getMovimientosDeStockPorDeposito(depoID);
			
		} 	catch (RestaurantException r){
			
			}
		
		return losMovimientos;
		
	}


	public List<DTO.Producto> getProductos() throws RemoteException, RestaurantException  {
		return ri.getProductos();
	}
	public List<DTO.Semielaborado> getSemielaborados() throws RemoteException, RestaurantException  {
		return ri.getSemielaborados();
	}
	
	public List<DTO.Area> getAreas() throws RemoteException, RestaurantException  {
		return ri.getAreas();
	}
	

	
	public Integer userLogin(String user) throws RemoteException, RestaurantException {		
		return ri.userLogin(user);
	}
	
	public boolean addTareaPlanProduccion(Integer semiID, Integer cant, Integer loginID)  throws RemoteException, RestaurantException {
		return ri.addTareaPlanProduccion(semiID, cant, loginID);
	}
	
	
	public Integer crearOperacionCaja(Integer operacionId, Integer sucId) throws RemoteException, RestaurantException  { 
		
		return ri.crearOperacionCaja(operacionId,sucId);
		
	}
	
	public void agregarItemsCaja(DTO.Item_Operacion_Caja item, Integer opCajaId) throws RemoteException, RestaurantException  {
		
		ri.agregarItemsCaja(item,opCajaId);
		
	}
	
	public List<Integer> abrirMesa(Integer mozoId, Integer cantComensales) throws RemoteException, RestaurantException {
		
		return ri.abrirMesa(mozoId,cantComensales);
		
	}
	
	public void agregarPlato (Integer plato, Integer cantidad, Integer suc, Integer mesa) throws RemoteException, RestaurantException {
		ri.agregarPlato(plato, cantidad, suc, mesa);
	}

	public List<Integer> getMesasConPedidosAbiertosPorMozo(Integer mozoId) {
	
			try {
				return ri.getMesasConPedidosAbiertosPorMozo(mozoId);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public void cerrarPedido(Integer mesa, Integer suc) throws RemoteException, RestaurantException {
		ri.cerrarPedido(mesa,suc);
	}

	public Integer getSucursalDeLogin(Integer loginId) {
		try {
			return ri.getSucursalDelLogin(loginId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer getMozoDeLogin(Integer loginId) {
		try {
			return ri.getMozoDelLogin(loginId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Integer solicitarfactura(Integer mesa) {
		try {
			return ri.solicitarFactura(mesa);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Insumo> getComprasARealizar() throws RemoteException, RestaurantException  {
		
			return ri.getComprasARealizar();
		
	}
	
	public Integer crearOrdenDeCompra (int proveedorId) throws RemoteException, RestaurantException  {
		return ri.crearOrdenDeCompra (proveedorId);
	}

	public void agregarItemOC(Item_Compra item, Integer oc) throws RemoteException, RestaurantException  {
		ri.agregarItemOC(item,oc);
		
	}

	public DTO.Factura getFacturaDTO(Integer nro) throws RemoteException, RestaurantException , RestaurantException {
		return ri.getFacturaDTO(nro);
	}
}
