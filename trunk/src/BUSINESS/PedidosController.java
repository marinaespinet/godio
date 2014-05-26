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
	
	public Item_Pedido getItemPedidoFromDTO(DTO.Item_Pedido item){
		Item_Pedido it = new Item_Pedido();
		it.setCantidad(item.getCantidad());
		it.setPedido(PedidosDAO.getInstancia().getPedido(item.getPedido_id()));
		it.setItem_carta(CartasDAO.getInstancia().getItemCarta(item.getItem_carta_id()));
		
		it.setEstado(EstadosDAO.getInstancia().getEstadoItemPedidoByName("Pendiente"));
		
		it.setArea(
				CartasDAO.getInstancia().getItemCarta(item.getItem_carta_id()).getPlato().getPlato_area()
		);
		
		Pedido pedido = PedidosDAO.getInstancia().getPedido(item.getPedido_id());
		
		it.setPedido(pedido);
		return it;
	}
}
