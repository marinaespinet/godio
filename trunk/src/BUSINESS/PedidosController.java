package BUSINESS;

import java.util.LinkedList;
import java.util.List;

import DAO.*;
import DTO.Item_Pedido;
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
		ENTITY.Item_Pedido it = getItemPedidoEntityFromDTO(item);
		PedidosDAO.getInstancia().setItemPedido(it);
	}
	
	public ENTITY.Item_Pedido getItemPedidoFromDTO(DTO.Item_Pedido itemDTO){
		ENTITY.Item_Pedido itEnt = new ENTITY.Item_Pedido();
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

	public List<ENTITY.Item_Pedido> getItemPedidosPendientes(int sucId, int areaId) {
		List<ENTITY.Item_Pedido> losItemsPendientes = PedidosDAO.getInstancia().getItemsPendientesDeArea(sucId,areaId);
		return losItemsPendientes;
	}

	public List<DTO.Item_Pedido> getDTOFromEntityItemsPedido(List<ENTITY.Item_Pedido> itemPedidosPendientesEnt) {
		List<DTO.Item_Pedido> itemPedidosPendientesDTO = new LinkedList<DTO.Item_Pedido>();
		for (ENTITY.Item_Pedido itEnt : itemPedidosPendientesEnt){
			DTO.Item_Pedido itDTO = new DTO.Item_Pedido();
			itDTO.setDescripcionPlatoContenido(itEnt.getItem_carta().getPlato().getName());
			itDTO.setEstado_id(itEnt.getEstado().getEstado_id());
			itDTO.setEstado_name(itEnt.getEstado().getEstado_name());
			itDTO.setItem_id(itEnt.getItem_id());
			itemPedidosPendientesDTO.add(itDTO);
		}
		return itemPedidosPendientesDTO;
	}

	public ENTITY.Item_Pedido getItemPedidoEntityFromDTO(Item_Pedido itemDTO) {
		ENTITY.Item_Pedido itEnt = PedidosDAO.getInstancia().getItemPedidoPorId(itemDTO.getItem_id());
		itEnt.getEstado().setEstado_id(itemDTO.getEstado_id());
		itEnt.getEstado().setEstado_name(itemDTO.getEstado_name());
		return itEnt;
	}
		
	
}
