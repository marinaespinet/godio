package BUSINESS;

import java.sql.Date;
import java.util.*;

import DAO.*;
import DTO.Area;
import DTO.Item_Carta;
import DTO.Login;
import DTO.Mesa;
import DTO.Mozo;
import DTO.Pedido;
import DTO.Plato;
import DTO.Rol;
import DTO.Sector;
import DTO.Sucursal;
import DTO.Usuario;
import ENTITY.*;
import Exceptions.RestaurantException;

public class RestauranteController {
	private static RestauranteController instancia = null;

	public static RestauranteController getInstancia(){
		if(instancia == null){			
			instancia = new RestauranteController();
		} 
		return instancia;
	}
	
	public void abrirMesa(int mozo, int comensales) throws RestaurantException{
		ENTITY.Mozo elMozo = LocationDAO.getInstancia().getMozoPorId(mozo);
		List <ENTITY.Mesa> mesasPosibles=new LinkedList <ENTITY.Mesa>();
		List <ENTITY.Mesa> mesasLibres = getMesasLibresEnSucursal(elMozo.getMozo_sector().getSector_sucursal().getSucursal_id(), comensales);
		if(mesasLibres == null) {throw new RestaurantException("No hay mesas libres en la sucursal");}
		
		//Si la mesa libre cubre la cantidad de comensales, la agrego como opcion
		for (ENTITY.Mesa unaMesa: mesasLibres){
					
				if(unaMesa.getMax_cant_comensales()>=comensales)
					mesasPosibles.add(unaMesa);
				else {
					//buscoUnir con la mesa anterior
					int anterior=0;
					if (unaMesa.equals(mesasLibres.get(0))) 
						{anterior=mesasLibres.size()-1;}
					else 
						{anterior=mesasLibres.indexOf(unaMesa)-1;}
					
					int cantComensalesUnion=unaMesa.getMax_cant_comensales()+mesasLibres.get(anterior).getMax_cant_comensales();
					if(
						//Si la cantidad de comensales que obtengo por la union cubre la cantidad solicitada
						(cantComensalesUnion>=comensales) && 
						//y si las mesas pertenecen al mismo sector
						(unaMesa.getMesa_sector().equals(mesasLibres.get(anterior).getMesa_sector())))
						unaMesa.setUnion_mesa(mesasLibres.get(anterior));
						mesasLibres.get(anterior).setUnion_mesa(unaMesa);
						mesasPosibles.add(unaMesa);
				}
				
			}
		
		if(mesasPosibles!=null) 
		{
				//Verifica si hay reservas
				Long cantidadReserva = getCantidadReservas(elMozo.getMozo_sector().getSector_sucursal().getSucursal_id());
				if (cantidadReserva<mesasPosibles.size()){
					//Si está unida, marca la otra mesa como ocupada
					ENTITY.Mesa mesaElegida = mesasPosibles.get(0);
					if (mesaElegida.getUnion_mesa()!=null) {
						ENTITY.Mesa mesaUnida=mesaElegida.getUnion_mesa();
						mesaUnida.setUnion_mesa(mesaElegida);
						mesaUnida.setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa(2));
						LocationDAO.getInstancia().grabarMesa(mesaUnida);
						//Crea el pedido con el id de mesa mayor
						PedidosController.getInstancia().crearPedido(mesaUnida.getMesa_id(),mozo,comensales);
					}
					//Crea el pedido con la mesa seleccionada
					else {PedidosController.getInstancia().crearPedido(mesaElegida.getMesa_id(),mozo,comensales);} 
					//Marca la mesa como ocupada
					mesaElegida.setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa(2));
					LocationDAO.getInstancia().grabarMesa(mesaElegida);
					
				}
				else  {throw new RestaurantException("No hay mesas disponibles en la sucursal");}
		}
		
	}
	

	public Date getDate(int year,int month,int day,int hour,int minutes){
		
		int elMesReal = month -1;
		Calendar unaFecha = Calendar.getInstance();
		unaFecha.set(Calendar.YEAR,year);
		unaFecha.set(Calendar.MONTH,elMesReal);
		unaFecha.set(Calendar.DAY_OF_MONTH,day);
		unaFecha.set(Calendar.HOUR_OF_DAY, hour);
		unaFecha.set(Calendar.MINUTE, minutes);
		
		Date laFecha = new java.sql.Date(unaFecha.getTimeInMillis());
		
		return laFecha;
	}

	public java.sql.Date getTodayDate(){						
		return new java.sql.Date(Calendar.getInstance().getTimeInMillis());		
	}
	

	public DTO.Login getLoginDTO(ENTITY.Login loginEnt) {
		DTO.Login unLoginDTO = new DTO.Login();
		unLoginDTO.setFecha_login_dt(loginEnt.getFecha_login_dt());
		unLoginDTO.setFecha_logout_dt(loginEnt.getFecha_logout_dt());
		unLoginDTO.setLogin_id(loginEnt.getLogin_id());
		unLoginDTO.setUser(getUserDTO(loginEnt.getUser()));
		return unLoginDTO;
	}


	public DTO.Usuario getUserDTO(ENTITY.Usuario userEnt) {
		DTO.Usuario unUsuarioDTO = new DTO.Usuario();
		unUsuarioDTO.setUser_id(userEnt.getUser_id());
		unUsuarioDTO.setUser_name(userEnt.getUser_name());
		unUsuarioDTO.setUser_rol(getRolDTO(userEnt.getUser_rol()));
		return unUsuarioDTO;
	}


	public DTO.Rol getRolDTO(ENTITY.Rol rolEnt) {
		DTO.Rol unRolDTO = new DTO.Rol();
		unRolDTO.setRole_id(rolEnt.getRole_id());
		unRolDTO.setRole_name(rolEnt.getRole_name());
		return unRolDTO;
	}


	public DTO.Mesa getMesaDTO(ENTITY.Mesa mesaEnt) {
		DTO.Mesa unaMesaDTO = new DTO.Mesa();
		unaMesaDTO.setMax_cant_comensales(mesaEnt.getMax_cant_comensales());
		unaMesaDTO.setMesa_cd(mesaEnt.getMesa_cd());
		unaMesaDTO.setMesa_estado(mesaEnt.getMesa_estado().getEstado_name());
		unaMesaDTO.setMesa_id(mesaEnt.getMesa_id());
		unaMesaDTO.setMesa_sector(getSectorDTO(mesaEnt.getMesa_sector()));
		unaMesaDTO.setMesa_sucursal(getSucursalDTO(mesaEnt.getMesa_sucursal()));
		//unaMesaDTO.setUnion_mesa(mesaEnt.getUnion_mesa_id()); //odio la union de mesas
		return unaMesaDTO;
	}

	public DTO.Sector getSectorDTO(ENTITY.Sector mesa_sectorEnt) {
		DTO.Sector unSectorDTO = new DTO.Sector();
		unSectorDTO.setName(mesa_sectorEnt.getName());
		unSectorDTO.setSector_id(mesa_sectorEnt.getSector_id());
		unSectorDTO.setSector_sucursal(getSucursalDTO(mesa_sectorEnt.getSector_sucursal()));
		return unSectorDTO;
	}

	public DTO.Sucursal getSucursalDTO(ENTITY.Sucursal sucursalEnt) {
		DTO.Sucursal unaSucursalDTO = new DTO.Sucursal();
		unaSucursalDTO.setCant_max_cubiertos(sucursalEnt.getCant_max_cubiertos());
		unaSucursalDTO.setCant_max_hs_produccion_cocina(sucursalEnt.getCant_max_hs_produccion_cocina());
		unaSucursalDTO.setCant_max_mesas(sucursalEnt.getCant_max_mesas());
		unaSucursalDTO.setEs_admin_central_ind(sucursalEnt.getEs_admin_central_ind());
		unaSucursalDTO.setName(sucursalEnt.getName());
		unaSucursalDTO.setSucursal_id(sucursalEnt.getSucursal_id());
		//unaSucursalDTO.setAreas(getAreasDTO(sucursalEnt.getAreas()));
 		return unaSucursalDTO;
	}

	public List<Area> getAreasDTO(List<ENTITY.Area> areasEnt) {
		List<DTO.Area> areasDTO = new LinkedList<DTO.Area>();
		for(ENTITY.Area areaEnt : areasEnt){
			DTO.Area unAreaDTO = new DTO.Area();
			unAreaDTO.setArea_id(areaEnt.getArea_id());
			unAreaDTO.setName(areaEnt.getName());
			areasDTO.add(unAreaDTO);
		}
		return areasDTO;
	}
	
	public DTO.Area getAreaDTO(ENTITY.Area areaEnt) {
		DTO.Area unAreaDTO = new DTO.Area();
		unAreaDTO.setArea_id(areaEnt.getArea_id());
		unAreaDTO.setName(areaEnt.getName());
		return unAreaDTO;
	}


	public List<ENTITY.Mesa> getMesasLibresEnSucursal(Integer sucursal_id, int comensales) {
		List<ENTITY.Mesa> lasMesas=LocationDAO.getInstancia().getMesasLibresEnSucursal(sucursal_id, comensales);
		return lasMesas;
	}



	public Mozo getMozoDTO(ENTITY.Mozo mozoEnt) {
		DTO.Mozo unMozoDTO = new DTO.Mozo();
		unMozoDTO.setComision(mozoEnt.getComision());
		unMozoDTO.setMozo_id(mozoEnt.getMozo_id());
		unMozoDTO.setMozo_sector(getSectorDTO(mozoEnt.getMozo_sector()));
		unMozoDTO.setMozo_user(getUserDTO(mozoEnt.getMozo_user()));
		unMozoDTO.setName(mozoEnt.getName());
		return unMozoDTO;
	}


	public Item_Carta getItemCartaDTO(ENTITY.Item_Carta item_cartaEnt) {
		DTO.Item_Carta unItem_CartaDTO = new DTO.Item_Carta();
		unItem_CartaDTO.setItem_carta_id(item_cartaEnt.getItem_carta_id());
		unItem_CartaDTO.setItem_plato(getPlatoDTO(item_cartaEnt.getPlato()));
		unItem_CartaDTO.setPrecio_monto(item_cartaEnt.getPrecio_monto());
		unItem_CartaDTO.setRubro(item_cartaEnt.getRubro().getName());
		return unItem_CartaDTO;
	}


	public Plato getPlatoDTO(ENTITY.Plato platoEnt) {
		DTO.Plato unPlatoDTO = new DTO.Plato();
		unPlatoDTO.setComision_extra_mozo(platoEnt.getComision_extra_mozo());
		unPlatoDTO.setName(platoEnt.getName());
		unPlatoDTO.setPlato_area(getAreaDTO(platoEnt.getPlato_area()));
		unPlatoDTO.setPlato_id(platoEnt.getPlato_id());
		return unPlatoDTO;
	}

/*
	public DTO.Pedido getPedidoDTOReclamo(ENTITY.Pedido pedidoEnt) {
		DTO.Pedido unPedidoDTO = new DTO.Pedido();
		unPedidoDTO.setItems(getItemsPedidoDTOReclamo(pedidoEnt.listarItems()));
		unPedidoDTO.setPedido_id(pedidoEnt.getPedido_id());
		return unPedidoDTO;
	}


	private List<DTO.Item_Pedido> getItemsPedidoDTOReclamo(List<ENTITY.Item_Pedido> itemsEnt) {
		List<DTO.Item_Pedido> itemsDTO = new LinkedList<DTO.Item_Pedido>();
		for(ENTITY.Item_Pedido itemEnt : itemsEnt){
			DTO.Item_Pedido itemDTO = new DTO.Item_Pedido();
			itemDTO.setItem_id(itemEnt.getItem_id());
			itemDTO.setDescripcionPlatoContenido(itemEnt.getItem_carta().getPlato().getName());
		}
		return itemsDTO;
	}
	*/
	


	public Item_Pedido getItemPedidoEntityFromDTOReclamo(DTO.Item_Pedido elItemObservadoDTO) {
		ENTITY.Item_Pedido elItemEnt = PedidosDAO.getInstancia().getItemPedidoPorId(elItemObservadoDTO.getItem_id());
		elItemEnt.setItem_no_facturar_ind(elItemObservadoDTO.getItem_no_facturar_ind());
		elItemEnt.setObservaciones_no_facturar(elItemObservadoDTO.getObservaciones_no_facturar());
		return elItemEnt;
	}

	public Long getCantidadReservas(int sucursal_id){
		return LocationDAO.getInstancia().getCantReservas(sucursal_id);
	}


	public DTO.Pedido getPedidoDTOReclamo(ENTITY.Pedido pedidoEnt) throws RestaurantException {
		DTO.Pedido elPedidoDTO = new DTO.Pedido();
		elPedidoDTO.setPedido_id(pedidoEnt.getPedido_id());
		if(pedidoEnt.listarItems()==null)
		{ throw new RestaurantException("El pedido no tiene items");}
		elPedidoDTO.setItems(getItemsPedidoDTOFromEntity(pedidoEnt.listarItems()));
		return elPedidoDTO;
	}


	private List<DTO.Item_Pedido> getItemsPedidoDTOFromEntity(List<Item_Pedido> itemsEnt) {
		List<DTO.Item_Pedido> itemsDTO = new LinkedList<DTO.Item_Pedido>();
		for(ENTITY.Item_Pedido itemEnt : itemsEnt){
			DTO.Item_Pedido itemDTO = new DTO.Item_Pedido();
			itemDTO.setCantidad(itemEnt.getCantidad());
			itemDTO.setDescripcionPlatoContenido(itemEnt.getItem_carta().getPlato().getName());
			itemDTO.setEstado_id(itemEnt.getEstado().getEstado_id());
			itemDTO.setEstado_name(itemEnt.getEstado().getEstado_name());
			itemDTO.setObservaciones_no_facturar(itemEnt.getObservaciones_no_facturar());
			itemDTO.setPedido_id(itemEnt.getPedido().getPedido_id());
			itemDTO.setItem_carta_id(itemEnt.getItem_carta().getItem_carta_id());
			itemDTO.setItem_no_facturar_ind(itemEnt.getItem_no_facturar_ind());
			itemsDTO.add(itemDTO);
		}
		return itemsDTO;
	}
	
	
	public  List<Area> getAreas() {
		List<DTO.Area> areas = new ArrayList<DTO.Area>();
		
		for(ENTITY.Area area : DAO.LocationDAO.getInstancia().getAreas())
			areas.add(new DTO.Area(area.getName(), area.getArea_id()));
		
		return areas;
	}
	
	
}
