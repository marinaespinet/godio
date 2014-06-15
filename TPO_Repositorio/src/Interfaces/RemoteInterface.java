package Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

public interface RemoteInterface extends Remote {

	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) 
				throws RemoteException;
	
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException;
	
	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException;
	
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException;
	
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException;
		
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException;
		
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException;
	
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException;	
	
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException;
	
}	
