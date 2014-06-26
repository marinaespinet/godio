package BUSINESS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Exceptions.*;
import DAO.*;
import DTO.Item_Carta;
import DTO.Item_Pedido;
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
		
	  public void agregarPlatoAlPedido(int pl, int cantidad, int depo, int mesa){
          boolean disponible = verificarDisponibilidad(pl, cantidad, depo);
          if (disponible){
                  
        	  	  //Si tengo todas las condiciones, crea un nuevo ENTITY.Item_Pedido para persistir
        	  	  ENTITY.Item_Pedido elItemPedidoEnt = new ENTITY.Item_Pedido();
        	  	  
        	  	  //le "cargo" los datos que traigo
        	  	  elItemPedidoEnt.setCantidad(cantidad);
        	  	  elItemPedidoEnt.setPedido(PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(mesa));
        	  	  elItemPedidoEnt.set_Area(LocationDAO.getInstancia().getAreaDePlato(pl));
        	  	  elItemPedidoEnt.setItem_carta(CartasDAO.getInstancia().getItemCarta(CartasDAO.getInstancia().getItemCartaIdPorPlato(pl)));
        	  	  elItemPedidoEnt.setEstado(EstadosDAO.getInstancia().getEstadoItemPedidoByName("Pendiente"));
        	  	  
        	  	  //lo persisto
        	  	  PedidosDAO.getInstancia().setItemPedido(elItemPedidoEnt);
          }
          else {
                  System.out.println("No disponible");
                  String rubro = CartasDAO.getInstancia().getItemCarta(CartasDAO.getInstancia().getItemCartaIdPorPlato(pl)).getRubro().getName();
                  List<String> alternativas = CartasDAO.getInstancia().getPlatosAlternativos(rubro);
                  System.out.println("El plato elegido no está disponible. Platos alternativos: ");
                  for (String opcion: alternativas){
                	  System.out.println(opcion);
                  }	
               
          }
  }

	  public Item_Carta getItemCargaDTOFromEntity(ENTITY.Item_Carta itemCartaEnt) {
			DTO.Item_Carta itemCartaDTO = new DTO.Item_Carta();
			itemCartaDTO.setItem_carta_id(itemCartaEnt.getItem_carta_id());
			itemCartaDTO.setPrecio_monto(itemCartaEnt.getPrecio_monto());
			return itemCartaDTO;
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
		
		//La setea en estado Libre
		//mesa.setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa("Libre")); //comentado para que no haya errores al tiempo de compilacion
				
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

	public List<DTO.Item_Pedido> getItemPedidosPendientesDTO(int areaId, int sucId) {
		List<ENTITY.Item_Pedido> losItemPedidosPendientesEnt = getItemPedidosPendientes(areaId,sucId);
		//transformo a DTO
		List<DTO.Item_Pedido> losItemPedidoPendientesDTO = getDTOFromEntityItemsPedido(losItemPedidosPendientesEnt);
		
		return losItemPedidoPendientesDTO;
	}

	public void marcarItemPedidoPreparado(List<Item_Pedido> losItemsPedidoPendientesDTO) {
		for(DTO.Item_Pedido unItem : losItemsPedidoPendientesDTO){
			ENTITY.Item_Pedido elItem = PedidosDAO.getInstancia().getItemPedidoPorId(unItem.getItem_id());
			elItem.getEstado().setEstado_id(2);  //2=EntregadoB
			PedidosDAO.getInstancia().updateItemPedido(elItem);
		}
		
	}

	public void crearPedido(Integer mesa_id, int mozo, int comensales) {
		ENTITY.Pedido pedido = new ENTITY.Pedido();
		pedido.setCant_comensales(comensales);
		pedido.setPedido_mozo(LocationDAO.getInstancia().getMozoPorId(mozo));
		pedido.setPedido_mesa(LocationDAO.getInstancia().getMesaPorId(mesa_id));
		pedido.setEstado(EstadosDAO.getInstancia().buscarEstadoPedido("Abierto"));
		pedido.setFecha_apertura_dt(RestauranteController.getInstancia().getTodayDate());
		Usuario usr = LocationDAO.getInstancia().getMozoPorId(mozo).getMozo_user();
		pedido.setPedido_login(LoginDAO.getInstancia().getLoginActualDeMozo(usr));
		PedidosDAO.getInstancia().grabarPedido(pedido);
		System.out.println("Pedido: "+pedido.getPedido_id());
	}
	
	public List<DTO.Mesa> getMesasAbiertasUnLogin(Integer loginID) throws RestaurantException{
		Usuario user = UsuariosController.getInstancia().getLogedUser(loginID);
		if(user==null)
		{ throw new RestaurantException("Usuario con loginID= "+loginID.toString()+ " inexistente");}

		
		Mozo moz = LocationDAO.getInstancia().getMozoFromUserID(user.getUser_id());
		if(moz==null)
		{ throw new RestaurantException("Mozo con usuarioID="+user.getUser_id().toString()+ " inexistente");}

		
		return getMesasAbiertasUnMozo(moz.getMozo_id());
	}
	
	public List<DTO.Mesa> getMesasAbiertasUnMozo(Integer mozoID){
		List<DTO.Mesa> mesasD = new ArrayList<DTO.Mesa>();
		List<ENTITY.Mesa> mesasE = LocationDAO.getInstancia().getMesasAbiertasUnMozo(mozoID);
		
		for(ENTITY.Mesa m : mesasE){
			DTO.Mesa mesD = new DTO.Mesa();
			mesD.setMesa_cd(m.getMesa_cd());
			mesasD.add(mesD);
		}		
		return mesasD;
	}

	public List<Integer> getMesasIdAbiertasUnIdMozo(Integer mozoId) throws RestaurantException {
		List<Integer> losIdDeLasMesas = LocationDAO.getInstancia().getIdsMesasAbiertasUnMozo(mozoId);		
		return losIdDeLasMesas;
	}
	

}
