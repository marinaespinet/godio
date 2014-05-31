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

	
}
