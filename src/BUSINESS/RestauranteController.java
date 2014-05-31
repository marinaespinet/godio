package BUSINESS;

import java.sql.Date;
import java.util.*;

import DAO.*;
import DTO.Login;
import DTO.Mesa;
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


	private DTO.Usuario getUserDTO(ENTITY.Usuario userEnt) {
		DTO.Usuario unUsuarioDTO = new DTO.Usuario();
		unUsuarioDTO.setUser_id(userEnt.getUser_id());
		unUsuarioDTO.setUser_name(userEnt.getUser_name());
		unUsuarioDTO.setUser_rol(getRolDTO(userEnt.getUser_rol()));
		return unUsuarioDTO;
	}


	private DTO.Rol getRolDTO(ENTITY.Rol rolEnt) {
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
		unaMesaDTO.setUnion_mesa(mesaEnt.getUnion_mesa());
		return unaMesaDTO;
	}


	private DTO.Sector getSectorDTO(ENTITY.Sector mesa_sectorEnt) {
		DTO.Sector unSectorDTO = new DTO.Sector();
		unSectorDTO.setName(mesa_sectorEnt.getName());
		unSectorDTO.setSector_id(mesa_sectorEnt.getSector_id());
		unSectorDTO.setSector_sucursal(getSucursalDTO(mesa_sectorEnt.getSector_sucursal()));
		return unSectorDTO;
	}


	private DTO.Sucursal getSucursalDTO(ENTITY.Sucursal sucursalEnt) {
		DTO.Sucursal unaSucursalDTO = new DTO.Sucursal();
		unaSucursalDTO.setCant_max_cubiertos(sucursalEnt.getCant_max_cubiertos());
		unaSucursalDTO.setCant_max_hs_produccion_cocina(sucursalEnt.getCant_max_hs_produccion_cocina());
		unaSucursalDTO.setCant_max_mesas(sucursalEnt.getCant_max_mesas());
		unaSucursalDTO.setEs_admin_central_ind(sucursalEnt.getEs_admin_central_ind());
		unaSucursalDTO.setName(sucursalEnt.getName());
		unaSucursalDTO.setHorasProduccionLibres(sucursalEnt.getHorasProduccionLibres); //y esto?
		unaSucursalDTO.setReservas(sucursalEnt.getReservas); //tampoco coincide
		unaSucursalDTO.setSucursal_id(sucursalEnt.getSucursal_id());
		unaSucursalDTO.setAreas(sucursalEnt.getAreas()); //y esto otro?
 		return unaSucursalDTO;
	}


	public List<ENTITY.Mesa> getMesasLibresEnSucursal(Integer sucursal_id) {
		List<ENTITY.Mesa> lasMesas=LocationDAO.getInstancia().getMesasLibresEnSucursal(sucursal_id);
		return lasMesas;
	}


	
}
