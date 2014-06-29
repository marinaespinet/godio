package SERVER;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.sql.Date;
import java.sql.Date;
import java.util.List;

import BUSINESS.FacturasController;
import BUSINESS.ProduccionController;
import BUSINESS.ProductosController;
import BUSINESS.RestauranteController;
import BUSINESS.CajaController;
import BUSINESS.ComprasController;
import BUSINESS.PedidosController;
import BUSINESS.StockController;
import BUSINESS.UsuariosController;
import DTO.Insumo;
import DTO.Item_Compra;
import Exceptions.RestaurantException;

public class NegocioRemoto extends UnicastRemoteObject implements Interfaces.RemoteInterface {
	private static final long serialVersionUID = 4516149167297806966L;
	
	protected NegocioRemoto() throws RemoteException, RestaurantException  {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID,
			Integer areaId, Integer sucID, String motivo, Integer cant,
			String lote) throws RemoteException, RestaurantException  {
		// TODO Auto-generated method stub
		StockController.getInstancia().transferenciaStockByAreaSuc(prodID, loginID, areaId, sucID, motivo, cant, lote);
		
	}
	@Override
	public void transferenciaStockByLoginId(Integer prodID, Integer loginID,
			 String motivo, Integer cant,
			String lote) throws RemoteException, RestaurantException  {
		// TODO Auto-generated method stub
		StockController.getInstancia().transferenciaStockByLoginId(prodID, loginID, motivo, cant, lote);		
	}
	
	//TODO: Agregar todos los metodos de TODOS los CONTROLLERS
	
	public List<DTO.Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RemoteException, RestaurantException {
	
		return PedidosController.getInstancia().obtenerItemsParaReclamo(idMesa);
		
	}
	
	public void registrarReclamo(List<DTO.Reclamo> losItemsParaReclamos) throws RemoteException, RestaurantException {
		
		PedidosController.getInstancia().registrarReclamo(losItemsParaReclamos);
		
	}
	
	public List<DTO.Stock> getStockPorDeposito (Integer depoID) throws RemoteException, RestaurantException {
		
		return StockController.getInstancia().getStockPorDeposito(depoID);
		
	}
	
	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO (Integer areaID, Integer sucID) throws RemoteException, RestaurantException {
		
		return PedidosController.getInstancia().getItemPedidosPendientesDTO(areaID, sucID);	
	
	}
	
	
	public void marcarItemPedidoPreparado(List<DTO.Item_Pedido> losItemsPedidoPendientesDTO) throws RemoteException, RestaurantException  {
		
		PedidosController.getInstancia().marcarItemPedidoPreparado(losItemsPedidoPendientesDTO);
		
	}
	
	
	public void setRecepcionCompra(DTO.RecepcionCompra laRecepcion) throws RemoteException, RestaurantException {
		
		ComprasController.getInstancia().setRecepcionCompra(laRecepcion);
		
	}
	
	public void liquidarComisionesMozos(Date diaLiquidado, Integer sucID) throws RemoteException, RestaurantException {
		
		CajaController.getInstancia().liquidarComisionesMozos(diaLiquidado, 1);
		
	}
	
	
	public List<DTO.Movimiento_Stock> getMovimientosDeStockPorDeposito(Integer depoID) throws RemoteException, RestaurantException {
		
		return StockController.getInstancia().getMovimientosDeStockPorDeposito(depoID);
		
	}
	
	
	
	
	public List<DTO.Producto> getProductos() throws RemoteException, RestaurantException  {
		return ProductosController.getInstancia().getProductos();
	}	
	public List<DTO.Semielaborado> getSemielaborados() throws RemoteException, RestaurantException  {
		return ProductosController.getInstancia().getSemielaborados();
	}	
	
	public List<DTO.Area> getAreas() throws RemoteException, RestaurantException  {
		return RestauranteController.getInstancia().getAreas();
	}

	@Override
	public Integer userLogin(String user) throws RemoteException, RestaurantException  {
		return UsuariosController.getInstancia().tryLogin(user, "");
	}
	
	public boolean addTareaPlanProduccion(Integer semiID, Integer cant, Integer loginID)  throws RestaurantException{
		return ProduccionController.getInstancia().addTareaPlanProduccion(semiID, cant, loginID);
	}

	public Integer crearOperacionCaja(Integer operacionId, Integer sucId) throws RemoteException, RestaurantException  {
		return CajaController.getInstancia().crearOperacionCaja(operacionId, sucId);
		
	}
	
	public void agregarItemsCaja(DTO.Item_Operacion_Caja item, Integer opCajaId) throws RemoteException, RestaurantException  {
		
		CajaController.getInstancia().agregarItemsCaja(item,opCajaId);
		
	}
	
	public List<Integer> abrirMesa(Integer mozo, Integer comensales) throws RestaurantException{
		
		return RestauranteController.getInstancia().abrirMesa(mozo, comensales);
		
	}
	
	public void agregarPlato (Integer plato, Integer cantidad, Integer suc, Integer mesa) throws RestaurantException{
		PedidosController.getInstancia().agregarPlatoAlPedido(plato, cantidad, suc, mesa);
	}

	@Override
	public List<Integer> getMesasConPedidosAbiertosPorMozo(Integer mozoId) throws RemoteException, RestaurantException  {
		return PedidosController.getInstancia().getMesasCodAbiertasUnIdMozo(mozoId);
	}
	
	public void cerrarPedido(Integer mesa,Integer suc) throws RemoteException, RestaurantException {
		PedidosController.getInstancia().cerrarPedido(mesa,suc);
	}

	@Override
	public Integer getSucursalDelLogin(Integer loginId) throws RestaurantException {
		return RestauranteController.getInstancia().getSucursalDeLogin(loginId);
	}
	
	@Override
	public Integer getMozoDelLogin(Integer loginId) throws RestaurantException {
		return RestauranteController.getInstancia().getMozoDeLogin(loginId);
	}

	@Override
	public Integer solicitarFactura(Integer mesa) throws RemoteException, RestaurantException  {
		return  FacturasController.getInstancia().solicitarFactura(mesa);

	}

	@Override
	public List<Insumo> getComprasARealizar() throws RemoteException, RestaurantException  {
		return ComprasController.getInstancia().getListadoDeComprasARealizar();
	}

	@Override
	public Integer crearOrdenDeCompra(Integer proveedorId) throws RemoteException, RestaurantException  {
		return ComprasController.getInstancia().crearOrdenDeCompra(proveedorId);
	}


	public void agregarItemOC(Item_Compra item, Integer oc)
			throws RemoteException, RestaurantException  {
		ComprasController.getInstancia().agregarItemsCompra(item, oc);
		
	}

	public DTO.Factura getFacturaDTO(Integer nro) throws RemoteException, RestaurantException {
		return FacturasController.getInstancia().getFacturaDTO(nro);
	}

}
