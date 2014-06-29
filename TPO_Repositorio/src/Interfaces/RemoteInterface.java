package Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

import DTO.Insumo;
import DTO.Item_Compra;
import Exceptions.RestaurantException;

public interface RemoteInterface extends Remote {

	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote)  throws RemoteException, RestaurantException;
	public void transferenciaStockByLoginId(Integer prodID, Integer loginID, String motivo, Integer cant, String lote)  throws RemoteException, RestaurantException;		
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException, RestaurantException;
	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException, RestaurantException;
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException, RestaurantException;
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException, RestaurantException;
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException, RestaurantException;
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException, RestaurantException;
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException, RestaurantException;
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException, RestaurantException;
	public List<DTO.Producto> getProductos() throws RemoteException, RestaurantException;
	public List<DTO.Semielaborado> getSemielaborados() throws RemoteException, RestaurantException;
	public List<DTO.Area> getAreas() throws RemoteException, RestaurantException;
	public Integer userLogin(String user)  throws RemoteException, RestaurantException;
	public boolean addTareaPlanProduccion(Integer semiID, Integer cant, Integer loginID)  throws RemoteException, RestaurantException;
	public Integer crearOperacionCaja(Integer operacionId, Integer sucId) throws RemoteException, RestaurantException;
	public void agregarItemsCaja(DTO.Item_Operacion_Caja item, Integer opCajaId) throws RemoteException, RestaurantException;
	public List<Integer> abrirMesa(Integer mozo, Integer comensales) throws RemoteException, RestaurantException;
	public void agregarPlato (Integer plato, Integer cantidad, Integer suc, Integer mesa) throws RemoteException, RestaurantException;
	public List<Integer> getMesasConPedidosAbiertosPorMozo(Integer mozoId) throws RemoteException, RestaurantException;
	public void cerrarPedido(Integer mesa, Integer suc) throws RemoteException, RestaurantException;
	public Integer getSucursalDelLogin(Integer loginId) throws RemoteException, RestaurantException;
	public Integer getMozoDelLogin(Integer loginId)throws RemoteException, RestaurantException;
	public Integer solicitarFactura(Integer mesa)throws RemoteException, RestaurantException;
	public List<Insumo> getComprasARealizar()throws RemoteException, RestaurantException;
	public Integer crearOrdenDeCompra(Integer proveedorId) throws RemoteException, RestaurantException;
	public void agregarItemOC(Item_Compra item, Integer oc) throws RemoteException, RestaurantException;
	public DTO.Factura getFacturaDTO(Integer nro) throws RemoteException, RestaurantException;
	
}	