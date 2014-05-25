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
	
	
	
}
