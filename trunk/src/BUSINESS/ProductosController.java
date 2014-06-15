package BUSINESS;

import java.util.*;

import DAO.*;
import ENTITY.*;

public class ProductosController {

	private static ProductosController instancia = null;

	public static ProductosController getInstancia(){
		if(instancia == null){			
			instancia = new ProductosController();
		} 
		return instancia;
	}
	
	public DTO.Insumo getInsumoDTO(Insumo insumo){
		
		DTO.Insumo insumoDTO = new DTO.Insumo();
		insumoDTO.setName(insumo.getName());		
		insumoDTO.setPrecio_compra(insumo.getPrecio_compra());
		
		
		return insumoDTO;
	}
	
	public List<DTO.Producto> getProductos(){
		List<DTO.Producto> productos = new ArrayList<DTO.Producto>();
		
		for(Producto prod : DAO.ProductosDAO.getInstancia().getProductos())
			productos.add(new DTO.Producto(prod.getName(), prod.getProducto_id()));
		
		return productos;
	}
	
}
