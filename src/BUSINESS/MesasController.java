package BUSINESS;

import java.util.*;

import DAO.*;
import ENTITY.*;
import Exceptions.RestaurantException;


public class MesasController {
	private static MesasController instancia = null;

	public static MesasController getInstancia(){
		if(instancia == null){			
			instancia = new MesasController();
		} 
		return instancia;
	}

	
	public void cerrarMesa(Integer mesaID) throws RestaurantException{
		Mesa mesa = LocationDAO.getInstancia().getMesaPorId(mesaID);
		if(mesa==null)
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " inexistente");}
		
		if(mesa.getMesa_estado().getEstado_name() != "Ocupada")
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " no puede ser cerrada pues no se encuentra Ocupada.");}
		
		if(! facturaPagaMesa(mesaID))
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " aun no ha sido facturada o abonado su factura.");}
		
		//Desune las mesas si habia unidas
		mesa.setUnion_mesa(null);
		
		//La setea en estado Proxima liberarse
		mesa.setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa("ProximaLiberarse"));
		
	}
	
	private boolean facturaPagaMesa(Integer mesaID) throws RestaurantException{
		Mesa mesa = LocationDAO.getInstancia().getMesaPorId(mesaID);
		if(mesa==null)
			{ throw new RestaurantException("Mesa "+mesaID.toString()+ " inexistente");}
		
		if(mesa.getFactura()==null) return false;
		if(mesa.getFactura().getPago_factura()==null) return false;
		if(mesa.getFactura().getPago_factura().getMonto_total() != (mesa.getFactura().getMonto_total()).floatValue()) return false; 
		return true;
	}
}
