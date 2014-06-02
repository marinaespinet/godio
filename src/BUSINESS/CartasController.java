package BUSINESS;

import java.util.*;

import DAO.*;
import DTO.Plato;
import ENTITY.*;

public class CartasController {
	private static CartasController instancia = null;

	public static CartasController getInstancia(){
		if(instancia == null){			
			instancia = new CartasController();
		} 
		return instancia;
	}
	
	public ENTITY.Item_Carta getItemCartaFromDTO(DTO.Item_Carta cartaDTO){
		ENTITY.Item_Carta itc = new ENTITY.Item_Carta();
		itc.setItem_carta_id(cartaDTO.getItem_carta_id());
		itc.setPlato(getPlatoFromDTO(cartaDTO.getItem_plato()));
		itc.setPrecio_monto(cartaDTO.getPrecio_monto());
		itc.setRubro(CartasDAO.getInstancia().getRubro((cartaDTO.getRubro())));
		return itc;
	}


	private ENTITY.Plato getPlatoFromDTO(Plato plato) {
		ENTITY.Plato pl = new ENTITY.Plato();
		pl.setPlato_id(plato.getPlato_id());
		return pl;
	}
	

	
}
