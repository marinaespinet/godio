package SERVER;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.sql.Date;
import java.sql.Date;
import java.util.List;

import BUSINESS.ProductosController;
import BUSINESS.RestauranteController;
import BUSINESS.CajaController;
import BUSINESS.ComprasController;
import BUSINESS.PedidosController;
import BUSINESS.StockController;
import BUSINESS.UsuariosController;
import Exceptions.RestaurantException;

public class NegocioRemoto extends UnicastRemoteObject implements Interfaces.RemoteInterface {
	private static final long serialVersionUID = 4516149167297806966L;
	
	protected NegocioRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID,
			Integer areaId, Integer sucID, String motivo, Integer cant,
			String lote) throws RemoteException {
		// TODO Auto-generated method stub
		StockController.getInstancia().transferenciaStockByAreaSuc(prodID, loginID, areaId, sucID, motivo, cant, lote);
		
	}
	@Override
	public void transferenciaStockByLoginId(Integer prodID, Integer loginID,
			 String motivo, Integer cant,
			String lote) throws RemoteException {
		// TODO Auto-generated method stub
		StockController.getInstancia().transferenciaStockByLoginId(prodID, loginID, motivo, cant, lote);		
	}
	
	//TODO: Agregar todos los metodos de TODOS los CONTROLLERS
	
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException{
	
		return PedidosController.getInstancia().obtenerItemsParaReclamo(idMesa);
		
	}
	
	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException{
		
		PedidosController.getInstancia().registrarReclamo(losItemsParaReclamos);
		
	}
	
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException{
		
		return StockController.getInstancia().getStockPorDeposito(depoID);
		
	}
	
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException{
		
		return PedidosController.getInstancia().getItemPedidosPendientesDTO(areaID, sucID);	
	
	}
	
	
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException {
		
		PedidosController.getInstancia().marcarItemPedidoPreparado(losItemsPedidoPendientesDTO);
		
	}
	
	
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException{
		
		ComprasController.getInstancia().setRecepcionCompra(laRecepcion);
		
	}
	
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException{
		
		CajaController.getInstancia().liquidarComisionesMozos(diaLiquidado, 1);
		
	}
	
	
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException{
		
		return StockController.getInstancia().getMovimientosDeStockPorDeposito(depoID);
		
	}
	
	
	
	
	public List<DTO.Producto> getProductos() throws RemoteException {
		return ProductosController.getInstancia().getProductos();
	}	
	
	public List<DTO.Area> getAreas() throws RemoteException {
		return RestauranteController.getInstancia().getAreas();
	}

	@Override
	public Integer userLogin(String user) throws RemoteException {
		return UsuariosController.getInstancia().tryLogin(user, "1234");
	}
}
