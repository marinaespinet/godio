package BUSINESS;

import java.util.*;

import DAO.*;
import ENTITY.*;

public class CartasController {
	private static CartasController instancia = null;

	public static CartasController getInstancia(){
		if(instancia == null){			
			instancia = new CartasController();
		} 
		return instancia;
	}
	

	
}
