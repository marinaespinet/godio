package BUSINESS;

import java.util.LinkedList;
import java.util.List;

import DAO.LocationDAO;
import DAO.LoginDAO;
import DAO.ProductosDAO;
import DAO.StockDAO;
import ENTITY.*;
import Exceptions.RestaurantException;

public class StockController {
	private static StockController instancia = null;

	public static StockController getInstancia(){
		if(instancia == null){			
			instancia = new StockController();
		} 
		return instancia;
	}
	

	public Integer getStockCant(Integer depoID, Integer prodID){
		Stock stk= StockDAO.getInstancia().getStock(prodID, depoID);
		if(stk == null)
			return 0;
		else
			return stk.getCantidad();
	}
	
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) throws RestaurantException{

		Deposito depoTo = LocationDAO.getInstancia().getDepositoPorAreaSucursal(areaId, sucID);
		Deposito depoFrom = LocationDAO.getInstancia().getDepositoPorAreaSucursal( sucID, "Deposito");		
		
		transferenciaStock(prodID, loginID, depoFrom.getDeposito_id(), depoTo.getDeposito_id(), motivo, cant, lote);
	}
		
	
	public void transferenciaStock(Integer prodID, Integer loginID, Integer depoFromID, Integer depoToID, String motivo, Integer cant, String lote) throws RestaurantException{				
				
		Deposito depoFrom = LocationDAO.getInstancia().getDeposito(depoFromID);
		if(depoFrom == null){ throw new RestaurantException("Deposito origen "+depoFromID.toString()+ " inexistente.");}

		Deposito depoTo = LocationDAO.getInstancia().getDeposito(depoToID);
		if(depoTo == null){ throw new RestaurantException("Deposito destino "+depoToID.toString()+ " inexistente.");}

		Producto prod = ProductosDAO.getInstancia().getProducto(prodID);
		if(prod == null){ throw new RestaurantException("Producto solicitado de transferencia de stock "+prodID.toString()+ " inexistente.");}

		Login log = LoginDAO.getInstancia().getLogin(loginID);
		if(log == null){ throw new RestaurantException("Login id "+loginID.toString()+ " inexistente.");}
		
		//Check Existance on depoFrom		
		Stock stk = StockDAO.getInstancia().getStock(prodID, depoFrom.getDeposito_id());
		if(stk == null){ throw new RestaurantException("Stock inexistente para el producto.");}
		if(stk.getCantidad() < cant){ throw new RestaurantException("No alcanzan las " + stk.getCantidad().toString()  +" unidades existentes en stock para las "+ cant.toString() +" solicitadas.");}
			
				
		Movimiento_Stock mov = new Movimiento_Stock();
	
		mov.setDeposito_destino(depoTo);
		mov.setDeposito_origen(depoFrom);
		
		mov.setMotivo_desc(motivo);
		mov.setLote(lote);
		mov.setLogin_id(LoginDAO.getInstancia().getLogin(loginID));
		mov.setCantidad(cant);		
		mov.setProducto(prod);
		//TODO: Traer from Compras
		mov.setFecha_compra_producto_dt(RestauranteController.getInstancia().getDate(2014, 1, 1, 1, 1));
		
		mov.setFecha_vencim_producto_dt(stk.getFecha_vencimiento_producto_dt());
		
		StockDAO.getInstancia().grabarTransferenciaStock(mov);
		
		//actualiza cantidad de stock
		stk.setCantidad(stk.getCantidad() - cant);
		StockDAO.getInstancia().grabarStock(stk);
	}
	
	public List<DTO.Stock> getStockPorDeposito(Integer depoID){
		List<Stock> elStock = StockDAO.getInstancia().getStockPorDeposito(depoID);
		
		//Tengo un listado de Entities, las paso a DTOs que me convengan
		List<DTO.Stock> stockSucursalDTO = StockController.getInstancia().getDTOFromEntityStockPorSucursal(elStock);
		
		return stockSucursalDTO;
	}


	public List<DTO.Stock> getDTOFromEntityStockPorSucursal(List<Stock> stockSucursalEnt) {
		List<DTO.Stock> elStockSucursal = new LinkedList<DTO.Stock>();
		for(ENTITY.Stock unStockEnt : stockSucursalEnt){
			DTO.Stock unStockDTO = new DTO.Stock();
			unStockDTO.setCantidad(unStockEnt.getCantidad());
			unStockDTO.setFecha_vencimiento_producto_dt(unStockEnt.getFecha_vencimiento_producto_dt());
			unStockDTO.setNombreProducto(unStockEnt.getProducto().getName());
			elStockSucursal.add(unStockDTO);
		}
		return elStockSucursal;
	}


	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(int depoID) {
		List<ENTITY.Movimiento_Stock> losMovimientosEnt = StockDAO.getInstancia().getMovimientosStockPorDeposito(depoID);
		
		//Tengo un listado de Entities, las paso a DTOs que me convengan
		List<DTO.Movimiento_Stock> losMovimientosDTO = StockController.getInstancia().getDTOFromEntityMovStockPorSucursal(losMovimientosEnt);
		
		return losMovimientosDTO;
	}


	private List<DTO.Movimiento_Stock> getDTOFromEntityMovStockPorSucursal(List<ENTITY.Movimiento_Stock> losMovimientosEnt) {
		List<DTO.Movimiento_Stock> losMovimientosDTO = new LinkedList<DTO.Movimiento_Stock>();
		for(ENTITY.Movimiento_Stock unMovEnt : losMovimientosEnt){
			DTO.Movimiento_Stock unMovDTO = new DTO.Movimiento_Stock();
			unMovDTO.setCantidad(unMovEnt.getCantidad());
			unMovDTO.setDeposito_origenId(unMovEnt.getDeposito_origen().getDeposito_id());
			unMovDTO.setDeposito_destinoId(unMovEnt.getDeposito_destino().getDeposito_id());
			unMovDTO.setProductoName(unMovEnt.getProducto().getName());
			losMovimientosDTO.add(unMovDTO);
		}
		return losMovimientosDTO;
	}
	
	
	
}
