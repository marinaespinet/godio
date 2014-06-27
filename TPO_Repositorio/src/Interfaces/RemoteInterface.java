package Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import Exceptions.RestaurantException;

public interface RemoteInterface extends Remote {

	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote)  throws RemoteException;
	public void transferenciaStockByLoginId(Integer prodID, Integer loginID, String motivo, Integer cant, String lote)  throws RemoteException;		
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException;
	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException;
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException;
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException;
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException;
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException;
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException;	
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException;
	public List<DTO.Producto> getProductos() throws RemoteException;
	public List<DTO.Semielaborado> getSemielaborados() throws RemoteException;
	public List<DTO.Area> getAreas() throws RemoteException;
	public Integer userLogin(String user)  throws RemoteException;
	public boolean addTareaPlanProduccion(Integer semiID, Integer cant, Integer loginID)  throws RemoteException;
	public Integer crearOperacionCaja(Integer operacionId, Integer sucId) throws RemoteException; 
	public void agregarItemsCaja(DTO.Item_Operacion_Caja item, Integer opCajaId) throws RemoteException;
	public List<Integer> abrirMesa(Integer mozo, Integer comensales) throws RemoteException;
	public void agregarPlato (Integer plato, Integer cantidad, Integer suc, Integer mesa) throws RemoteException;
	public List<Integer> getMesasConPedidosAbiertosPorMozo(Integer mozoId) throws RemoteException;
	public void cerrarPedido(Integer mesaID) throws RemoteException;
}	