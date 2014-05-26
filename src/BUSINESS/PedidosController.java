package BUSINESS;

import DAO.PedidosDAO;
import ENTITY.Item_Pedido;

public class PedidosController {
	private static ProductosController instancia = null;

	public static ProductosController getInstancia(){
		if(instancia == null){			
			instancia = new ProductosController();
		} 
		return instancia;
	}
	
	public void agregarItemsPedido(DTO.Item_Pedido item ){
		
	}
	
	public Item_Pedido getItemPedidoFromDTO(DTO.Item_Pedido item){
		Item_Pedido it = new Item_Pedido();
		it.setCantidad(item.getCantidad());
		it.setItem_pedido(PedidosDAO.getInstancia().getPedido(item.getPedido_id()));
		//it.setItem_carta();
		return it;
	}
}
