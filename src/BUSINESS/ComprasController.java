package BUSINESS;

import java.util.*;

import DAO.*;
import ENTITY.*;

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
}
