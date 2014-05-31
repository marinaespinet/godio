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

public class RestauranteController {
	private static RestauranteController instancia = null;

	public static RestauranteController getInstancia(){
		if(instancia == null){			
			instancia = new RestauranteController();
		} 
		return instancia;
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
		unaSucursalDTO.setAreas(getAreasDTO(sucursalEnt.getAreas()));
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


	public List<ENTITY.Mesa> getMesasLibresEnSucursal(Integer sucursal_id) {
		List<ENTITY.Mesa> lasMesas=LocationDAO.getInstancia().getMesasLibresEnSucursal(sucursal_id);
		return lasMesas;
	}


	public List<DTO.Item_Pedido> getItemsPedidoDTO(List<Item_Pedido> itemsEnt) {
		List<DTO.Item_Pedido> itemsPedidoDTO = new LinkedList<DTO.Item_Pedido>();
		for(ENTITY.Item_Pedido unItemEnt: itemsEnt){
			DTO.Item_Pedido unItemPedidoDTO = new DTO.Item_Pedido();
			unItemPedidoDTO.setCantidad(unItemEnt.getCantidad());
			unItemPedidoDTO.setItem_carta(getItemCartaDTO(unItemEnt.getItem_carta()));
			unItemPedidoDTO.setItem_carta_id(unItemEnt.getItem_carta().getItem_carta_id());
			unItemPedidoDTO.setItem_id(unItemEnt.getItem_id());
			unItemPedidoDTO.setItem_no_facturar_ind(unItemEnt.getItem_no_facturar_ind());
			unItemPedidoDTO.setItem_pedido(getPedidoDTO(unItemEnt.getPedido()));
			unItemPedidoDTO.setObservaciones_no_facturar(unItemEnt.getObservaciones_no_facturar());
			unItemPedidoDTO.setPedido_id(unItemEnt.getPedido().getPedido_id());
			itemsPedidoDTO.add(unItemPedidoDTO);
		}
		return itemsPedidoDTO;
	}


	public Pedido getPedidoDTO(ENTITY.Pedido pedidoEnt) {
		DTO.Pedido unPedidoDTO = new DTO.Pedido();
		unPedidoDTO.setCant_comensales(pedidoEnt.getCant_comensales());
		unPedidoDTO.setFecha_apertura_dt(pedidoEnt.getFecha_apertura_dt());
		unPedidoDTO.setFecha_cierre_dt(pedidoEnt.getFecha_cierre_dt());
		unPedidoDTO.setFecha_pago_dt(pedidoEnt.getFecha_pago_dt());
		unPedidoDTO.setItems(getItemsPedidoDTO(pedidoEnt.listarItems()));  //esto no se clava por recursividad?
		unPedidoDTO.setPedido_id(pedidoEnt.getPedido_id());
		unPedidoDTO.setPedido_login(getLoginDTO(pedidoEnt.getPedido_login()));
		unPedidoDTO.setPedido_mesa(getMesaDTO(pedidoEnt.getPedido_mesa()));
		unPedidoDTO.setPedido_mozo(getMozoDTO(pedidoEnt.getPedido_mozo()));
		return unPedidoDTO;
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


	
}
