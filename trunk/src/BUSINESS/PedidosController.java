package BUSINESS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Exceptions.*;
import DAO.*;
import DTO.Item_Carta;
import DTO.Reclamo;
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

	public ENTITY.Item_Pedido getItemPedidoEntityFromDTO(DTO.Item_Pedido itemDTO) {
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
                  
        	  	  /******Old Espinet code *********/
        	  	  /*DTO.Item_Pedido item = new DTO.Item_Pedido();
                  item.setItem_id(999);
                  item.setCantidad(cantidad);
                  
                  item.setItem_carta(getItemCargaDTOFromEntity(CartasDAO.getInstancia().getItemCartaPorPlato(pl.getPlato_id())));
                  item.setItem_pedido(getPedidoFromEntity(PedidosDAO.getInstancia().getPedido(pedido)));
                  agregarItemsPedido(item);
                  */
        	  
        	      
        	  	  /******Nuevo codigo by Javier*********/
        	  	  //Si tengo todas las condiciones, crea un nuevo ENTITY.Item_Pedido para persistir
        	  	  ENTITY.Item_Pedido elItemPedidoEnt = new ENTITY.Item_Pedido();
        	  	  
        	  	  //le "cargo" los datos que traigo
        	  	  elItemPedidoEnt.setCantidad(cantidad);
        	  	  elItemPedidoEnt.setPedido(PedidosDAO.getInstancia().getPedido(pedido));
        	  	  elItemPedidoEnt.setItem_carta(CartasDAO.getInstancia().getItemCartaPorPlato(pl.getPlato_id()));
        	  	  
        	  	  //lo persisto
        	  	  PedidosDAO.getInstancia().setItemPedido(elItemPedidoEnt);
          }
          else {
                  System.out.println("No disponible");
                  String rubro = CartasDAO.getInstancia().getItemCartaPorPlato(pl.getPlato_id()).getRubro().getName();
                  List<ENTITY.Plato> platosAlternativos = CartasDAO.getInstancia().getPlatosAlternativos(pl.getPlato_id(), rubro);
                  System.out.println("El plato elegido no est� disponible. Seleccionar alternativa: ");
                  
          }
  }

	  public Item_Carta getItemCargaDTOFromEntity(ENTITY.Item_Carta itemCartaEnt) {
			DTO.Item_Carta itemCartaDTO = new DTO.Item_Carta();
			itemCartaDTO.setItem_carta_id(itemCartaEnt.getItem_carta_id());
			itemCartaDTO.setPrecio_monto(itemCartaEnt.getPrecio_monto());
			return itemCartaDTO;
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
		//mesa.setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa("ProximaLiberarse")); //comentado para que no haya errores al tiempo de compilacion
				
	}

	public void registrarReclamo(List<Reclamo> itemsReclamoDTO) {
		for(DTO.Reclamo unItem : itemsReclamoDTO){
			if(unItem.getCantidadNoFacturar() > 0){
				ENTITY.Item_Pedido elItem = PedidosDAO.getInstancia().getItemPedidoPorId(unItem.getIdItemPedido());
				elItem.setItem_no_facturar_ind(true);
				elItem.setObservaciones_no_facturar(unItem.getObservaciones());
				PedidosDAO.getInstancia().updateItemPedido(elItem);
			}
		}
		
	}

	public List<Reclamo> obtenerItemsParaReclamo(Integer idMesa) throws RestaurantException {
		ENTITY.Pedido elPedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(idMesa);
		
		if((elPedido==null) || (elPedido.getPedido_mesa().getMesa_estado().getEstado_id() != 2 /* Estado 2 es Ocupada */))
		{ throw new RestaurantException("Mesa "+idMesa.toString()+ " no tiene el pedido abierto.");}
		
		List<DTO.Reclamo> losItemsDelReclamo = new ArrayList <DTO.Reclamo>();
		for(ENTITY.Item_Pedido itemPedidoEnt : elPedido.listarItems()){
			DTO.Reclamo itemReclamo = new DTO.Reclamo();
			itemReclamo.setIdItemPedido(itemPedidoEnt.getItem_id());
			itemReclamo.setPlatoNombre(itemPedidoEnt.getItem_carta().getPlato().getName());
			losItemsDelReclamo.add(itemReclamo);
		}
		
		return losItemsDelReclamo;
	}
}
