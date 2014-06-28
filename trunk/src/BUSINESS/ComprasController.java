package BUSINESS;

import java.sql.Date;
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
	
	public ArrayList<DTO.Insumo> getListadoDeComprasARealizar(){
		List<Insumo> insumos = ComprasDAO.getInstancia().getComprasRealizar();
		ArrayList<DTO.Insumo> insumosDTO  = new ArrayList<DTO.Insumo>();
		
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
	
	public Integer crearOrdenDeCompra (int proveedorId) throws RestaurantException{
		//Check proveedor Existe
		Proveedor proveedor = ComprasDAO.getInstancia().getProveedor(proveedorId);
		if(proveedor == null){ throw new RestaurantException("Proveedor "+proveedorId+" inexistente");}
		//Si existe, crea la orden de compra
		ENTITY.Compra OC = new ENTITY.Compra(proveedor);
		ComprasDAO.getInstancia().grabarCompra(OC);
		System.out.println("Se creó la orden de compra nro: "+ComprasDAO.getInstancia().getCompraPorProveedor(OC.getCompra_proveedor().getProveedor_id()).getCompra_id());
		return ComprasDAO.getInstancia().getCompraPorProveedor(OC.getCompra_proveedor().getProveedor_id()).getCompra_id();
	}
	
	public void agregarItemsCompra(DTO.Item_Compra item, Integer compra ) throws RestaurantException{
		ENTITY.Item_Compra it = getItemCompraFromDTO(item);
		
		//Valida que exista el producto
		if (it.getItem_producto()==null) { throw new RestaurantException("Producto inexistente");}
		
		//Valida la cantidad ingresada
		if (it.getItem_compra_cant()<=0){ throw new RestaurantException("Cantidad inválida");}
		
		//Valida el precio ingresado
		if (it.getItem_precio_monto()<=0) { throw new RestaurantException("Precio inválido");}
		
		//Asocia el item con la compra y persiste
		it.setItem_compra_compra_id(ComprasDAO.getInstancia().getCompra(compra));
		ComprasDAO.getInstancia().agregarItemCompra(it);
	}
	
	public ENTITY.Item_Compra getItemCompraFromDTO(DTO.Item_Compra itemDTO){
		ENTITY.Item_Compra itEnt = new ENTITY.Item_Compra();
		itEnt.setItem_compra_cant(itemDTO.getItem_compra_cant());
		itEnt.setItem_precio_monto(itemDTO.getItem_precio_monto());
		itEnt.setItem_producto(ProductosDAO.getInstancia().getProducto(itemDTO.getItem_producto()));
		return itEnt;
	}
	

	
}
