package BUSINESS;

import java.sql.Date;
import java.util.*;
import DAO.*;
import ENTITY.*;
import Exceptions.RestaurantException;

public class CajaController {

	private static CajaController instancia = null;

	public static CajaController getInstancia(){
		if(instancia == null){			
			instancia = new CajaController();
		} 
		return instancia;
	}
	
	public void crearOperacionCaja(int operacion_id, int sucursal)throws RestaurantException{
		Date hoy = new java.sql.Date(System.currentTimeMillis());
		Long cantOperacionesHoy=OperacionCajaDAO.getInstancia().verificarOperacionCaja(hoy,operacion_id, sucursal);
		if (cantOperacionesHoy==0){
			Operacion_Caja opCaja = new Operacion_Caja();
			opCaja.setOperacion_caja_id(Calendar.DATE);
			opCaja.setFecha_dt(hoy);
			opCaja.setOperacion_caja_sucursal(LocationDAO.getInstancia().getSucursalPorId(sucursal));
			opCaja.setTipo(OperacionCajaDAO.getInstancia().getTipo(operacion_id));
			OperacionCajaDAO.getInstancia().grabarOperacionCaja(opCaja);
			System.out.println("Se cre� la operaci�n de caja " + opCaja.getTipo().getNombre() + " con fecha: " + opCaja.getFecha_dt());
		}
		else throw new RestaurantException("Ya existe una operacion de caja de el tipo seleccionado para el d�a de hoy");
	}
	
	public void agregarItemsCaja(DTO.Item_Operacion_Caja item, int opCajaId){
		Item_Operacion_Caja it = getItemCajaFromDTO(item, opCajaId);
		OperacionCajaDAO.getInstancia().setItemCaja(it);
		recalcularRecaudacionCaja(item.getItem_operacion_operacion_id());
	}
	
	private void recalcularRecaudacionCaja(DTO.Operacion_Caja operacion) {
		Operacion_Caja op = getOperacionCajaFromDTO(operacion);
		Double monto = OperacionCajaDAO.getInstancia().calcularMonto(operacion.getOperacion_caja_id());
		op.setRecaudacion(monto);
		OperacionCajaDAO.getInstancia().grabarOperacionCaja(op);
	}

	public Operacion_Caja getOperacionCajaFromDTO(DTO.Operacion_Caja operacionDTO) {
		Operacion_Caja opCajaEnt = new Operacion_Caja();
		opCajaEnt.setOperacion_caja_id(operacionDTO.getOperacion_caja_id());
		opCajaEnt.setOperacion_caja_sucursal(LocationDAO.getInstancia().getSucursalPorId(1));//operacionDTO.getOperacion_caja_sucursal().getSucursal_id()));
		opCajaEnt.setComisiones(operacionDTO.getComisiones());
		opCajaEnt.setFecha_dt(operacionDTO.getFecha_dt());
		opCajaEnt.setItems(OperacionCajaDAO.getInstancia().listarItems(operacionDTO.getOperacion_caja_id()));
		opCajaEnt.setRecaudacion(operacionDTO.getRecaudacion());
		opCajaEnt.setTipo(OperacionCajaDAO.getInstancia().getTipo(1));//operacionDTO.getTipo().getTipo_operacion_id()));
		return opCajaEnt;
	}

	private Item_Operacion_Caja getItemCajaFromDTO(DTO.Item_Operacion_Caja itemDTO, int opCajaId){
		Item_Operacion_Caja itEnt = new Item_Operacion_Caja();
		itEnt.setTipo_comprobante(OperacionCajaDAO.getInstancia().getTipoComprobante(itemDTO.getTipo_comprobante().getTipo_comprobante_id()));
		System.out.println("Tipo comprobante: "+itEnt.getTipo_comprobante().getNombre());
		itEnt.setItem_operacion_id(itemDTO.getItem_operacion_id());
		System.out.println("Item Id: "+itEnt.getItem_operacion_id());
		itEnt.setCantidad(itemDTO.getCantidad());
		System.out.println("Cantidad: "+itEnt.getCantidad());
		itEnt.setMonto(itemDTO.getMonto());
		System.out.println("Monto: "+itEnt.getMonto());
		itEnt.setItem_cierre_cierre_id(OperacionCajaDAO.getInstancia().getOperacion(opCajaId));
		//Esto no le gusta
		//itEnt.setItem_cierre_cierre_id(OperacionCajaDAO.getInstancia().getOperacion(itemDTO.getItem_operacion_operacion_id().getOperacion_caja_id()));
		System.out.println("Operacion Id: "+itEnt.getItem_cierre_cierre_id().getOperacion_caja_id());
		return itEnt;
	}

	public DTO.Operacion_Caja getDTOFromEntity(ENTITY.Operacion_Caja op) {
		DTO.Operacion_Caja opDTO = new DTO.Operacion_Caja();
		opDTO.setComisiones(op.getComisiones());
		opDTO.setFecha_dt(op.getFecha_dt());
		//opDTO.setItems(OperacionCajaDAO.getInstancia().listarItems(op.getOperacion_caja_id()));
		opDTO.setOperacion_caja_id(op.getOperacion_caja_id());
		//opDTO.setOperacion_caja_sucursal(LocationDAO.getInstancia().getSucursalPorId(op.getOperacion_caja_sucursal().getSucursal_id()));
		opDTO.setRecaudacion(op.getRecaudacion());
		//opDTO.setTipo(op.getTipo());
		return opDTO;
	
	}
	
}