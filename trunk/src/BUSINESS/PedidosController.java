package BUSINESS;

import java.util.LinkedList;
import java.util.List;

import DAO.*;
import DTO.Item_Pedido;
import DTO.Plato;
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
		ENTITY.Item_Carta itc = CartasController.getInstancia().getItemCartaFromDTO(itemDTO.getItem_carta());
		itEnt.setItemCarta(itc);
		itEnt.setEstado(EstadosDAO.getInstancia().getEstadoItemPedidoByName("Pendiente"));
		ENTITY.Area area = RestauranteController.getInstancia().getAreaEntity(itemDTO.getItem_carta().getItem_plato().getPlato_area());
		itEnt.setArea(area);
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
	
	public void agregarPlatoAlPedido(DTO.Plato pl, int cantidad, int depo, int pedido){
		ENTITY.Plato plato=getPlatoFromDTO(pl);
		System.out.println("Obtuve Plato para verificar disponibilidad");
		boolean disponible = verificarDisponibilidad(pl.getPlato_id(), cantidad, depo);
		if (disponible){
			DTO.Item_Pedido item = new Item_Pedido();
			item.setItem_id(999);
			item.setCantidad(cantidad);
			item.setItem_carta(CartasDAO.getInstancia().getItemCartaPorPlato(pl.getPlato_id()));
			item.setItem_pedido (getPedidoFromEntity(PedidosDAO.getInstancia().getPedido(pedido)));
			agregarItemsPedido(item);
		}
		else {
			System.out.println("No disponible");
			String rubro = CartasDAO.getInstancia().getItemCartaPorPlato(pl.getPlato_id()).getRubro();
			List<ENTITY.Plato> platosAlternativos = CartasDAO.getInstancia().getPlatosAlternativos(pl.getPlato_id(), rubro);
			System.out.println("El plato elegido no está disponible. Seleccionar alternativa: ");
			
		}
	}

	private DTO.Pedido getPedidoFromEntity(ENTITY.Pedido ped) {
		DTO.Pedido pedido = new DTO.Pedido();
		pedido.setPedido_id(ped.getPedido_id());
		pedido.setCant_comensales(ped.getCant_comensales());
		return pedido;
	}

	private ENTITY.Plato getPlatoFromDTO(DTO.Plato plato) {
		ENTITY.Plato platoEnt = PedidosDAO.getInstancia().getPlatoPorId(plato.getPlato_id());
		platoEnt.setPlato_id(plato.getPlato_id());
		return null;
	}
	

	private boolean verificarDisponibilidad(int pl, int cantidad, int depo) {
		Long sinStock = StockDAO.getInstancia().verificarStockPorPlato(pl, cantidad, depo);
		System.out.println("Cant sin stock: "+sinStock);
		if(sinStock>0) 
			return false;
		else 
			return true;
	}
	
	
}
