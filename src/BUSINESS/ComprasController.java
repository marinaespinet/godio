package BUSINESS;

import java.util.*;

import DAO.*;
import DTO.RecepcionCompra;
import ENTITY.*;
import Exceptions.RestaurantException;

public class ComprasController {

	private static ComprasController instancia = null;

	public static ComprasController getInstancia(){
		if(instancia == null){			
			instancia = new ComprasController();
		} 
		return instancia;
	}
	
	public List<DTO.Insumo> getListadoDeComprasARealizar(){
		List<Insumo> insumos = ComprasDAO.getInstancia().getComprasRealizar();
		List<DTO.Insumo> insumosDTO  = new ArrayList<DTO.Insumo>();
		
		for(Insumo insumo: insumos){
			insumosDTO.add( ProductosController.getInstancia().getInsumoDTO(insumo));			
		}
		return insumosDTO;
	}

	public void setRecepcionCompra(RecepcionCompra laRecepcionDTO) throws RestaurantException {
		
		//creo la Entity a persistir
		ENTITY.RecepcionCompra laRecepcionEnt = new ENTITY.RecepcionCompra();
		laRecepcionEnt.setRecepcion_fecha_dt(laRecepcionDTO.getRecepcion_fecha_dt());
		laRecepcionEnt.setItems(getItemsRecepcionCompraEntFromDTO(laRecepcionDTO.getItems()));
		
		//genero un movimiento de stock por cada item de recepcion
		for(ENTITY.Item_Recepcion_Compra elItem : laRecepcionEnt.getItems()){
			StockController.getInstancia().transferenciaStock(elItem.getItem_recepcion_producto().getProducto_id(), 1, 1, 2, "Compra", elItem.getCant(), "Lote 1");
		}
		
		//persisto la recepcion
		ComprasDAO.getInstancia().setRecepcionCompra(laRecepcionEnt);
		
	}

	public List<ENTITY.Item_Recepcion_Compra> getItemsRecepcionCompraEntFromDTO(List<DTO.Item_Recepcion_Compra> itemsDTO) {
		
		List<ENTITY.Item_Recepcion_Compra> itemsEnt = new ArrayList<ENTITY.Item_Recepcion_Compra>();
		for(DTO.Item_Recepcion_Compra itemDTO : itemsDTO){
			ENTITY.Item_Recepcion_Compra itemEnt = new ENTITY.Item_Recepcion_Compra();
			itemEnt.setCant(itemDTO.getCant());
			itemEnt.setItem_recepcion_producto(ProductosDAO.getInstancia().getProducto(itemDTO.getItem_Id_Producto()));
			itemsEnt.add(itemEnt);
		}
		
		return itemsEnt;
		
	}

	
}
