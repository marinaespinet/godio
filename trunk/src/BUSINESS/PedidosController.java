package BUSINESS;

import DAO.*;
import ENTITY.*;
import Exceptions.RestaurantException;

public class PedidosController {
	private static PedidosController instancia = null;

	public static PedidosController getInstancia(){
		if(instancia == null){			
			instancia = new PedidosController();
		} 
		return instancia;
	}
	
	public void agregarItemsPedido(DTO.Item_Pedido item ){
		Item_Pedido it = getItemPedidoFromDTO(item);
		PedidosDAO.getInstancia().setItemPedido(it);
	}
	
	public Item_Pedido getItemPedidoFromDTO(DTO.Item_Pedido itemDTO){
		Item_Pedido itEnt = new Item_Pedido();
		itEnt.setCantidad(itemDTO.getCantidad());
		itEnt.setPedido(PedidosDAO.getInstancia().getPedido(itemDTO.getPedido_id()));
		itEnt.setItem_carta(CartasDAO.getInstancia().getItemCarta(itemDTO.getItem_carta_id()));
		
		itEnt.setEstado(EstadosDAO.getInstancia().getEstadoItemPedidoByName("Pendiente"));
		
		itEnt.setArea(
				CartasDAO.getInstancia().getItemCarta(itemDTO.getItem_carta_id()).getPlato().getPlato_area()
		);
		
		Pedido pedido = PedidosDAO.getInstancia().getPedido(itemDTO.getPedido_id());
		
		itEnt.setPedido(pedido);
		return itEnt;
	}
	
	
	public DTO.Pedido mostrarPedidoActual(Integer mesaId){
		Pedido elPedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(mesaId);
		DTO.Pedido elPedidoDTO = RestauranteController.getInstancia().getPedidoDTO(elPedido);
		return elPedidoDTO;
	}
	

	public void cerrarPedido(Integer mesaID) throws RestaurantException{
		//verifica mesa existente
		Mesa mesa = LocationDAO.getInstancia().getMesaPorId(mesaID);
		if(mesa==null)
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " inexistente");}
		
		if(mesa.getMesa_estado().getEstado_name().compareTo( "Ocupada") !=0)
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " no puede ser cerrada pues no se encuentra Ocupada.");}
		
		//verifica mesa con pedido abierto
		Pedido ped = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(mesaID);
		if(ped==null)
		{ throw new RestaurantException("Mesa "+mesaID.toString()+ " no registra pedido de mesa.");}
		
		if(ped.getPedidoEstado().getEstado_name().compareTo("Abierto")!=0)
		{ throw new RestaurantException("Mesa "+mesaID.toString()+ " no tiene el pedido abierto.");}
		
		Factura fac = FacturasDAO.getInstancia().getFacturaPedido(ped.getPedido_id());
		if(fac==null)
		{ throw new RestaurantException("Mesa "+mesaID.toString()+ " no tiene factura asociada.");}
		
		Double montoFac = FacturasDAO.getInstancia().getMontoPagos(fac.getFactura_id());
		if(montoFac == null || montoFac == 0)		
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " no registra pagos en la factura.");}
		
		//Desune las mesas si habia unidas
		mesa.setUnion_mesa(null);
		
		//La setea en estado Proxima liberarse
		mesa.setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa("ProximaLiberarse"));
		
	}
		
	
	
}
