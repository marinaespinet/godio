package BUSINESS;

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
	
	public void getListadoDeComprasARealizar(){
		
	}
	
}
