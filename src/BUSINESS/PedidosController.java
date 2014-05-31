package BUSINESS;

import DAO.*;
import ENTITY.*;

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
	
	
	public ENTITY.Pedido getPedidoActualEnMesa(Integer mesaId){
		Pedido elPedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(mesaId);
		return elPedido;
	}
		
	
}
