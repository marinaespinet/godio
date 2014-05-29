package BUSINESS;

import java.util.*;

import DAO.*;
import ENTITY.*;
import Exceptions.RestaurantException;

public class ProduccionController {

	private static ProduccionController instancia = null;

	public static ProduccionController getInstancia(){
		if(instancia == null){			
			instancia = new ProduccionController();
		} 
		return instancia;
	}
	
	//nro sucursal, codigo semielaborado y cantidad
	
	public int addTareasPlanProduccion(List<DTO.Item_Plan_Produccion> tareas) throws RestaurantException{
		//Si el PlanID existe, agrega a un plan inexistente, sino agrega un nuevo plan y devuelve el ID
		int planID = 0;
		for(DTO.Item_Plan_Produccion item : tareas){
			//Check sucursal Existe
			Sucursal suc = DAO.LocationDAO.getInstancia().getSucursalPorId(item.getSucursalID());
			if(suc == null){ throw new RestaurantException("Sucursal "+item.getSucursalID().toString()+ " inexistente en tarea de produccion");}
			//Check Semielaborado Exite
			Semielaborado semi = DAO.ProductosDAO.getInstancia().getSemielaborado(item.getSemielaboradoID());
			if(semi == null){ throw new RestaurantException("Semielaborado "+item.getSemielaboradoID().toString()+ " inexistente en tarea de produccion");}
			
			
			planID = item.getPlan_id();
			if(planID ==0 ){
				//Add new plan and return id
				Plan_Produccion plan= DAO.PlanProduccionDAO.getInstancia().nuevoPlanProduccion();
			}
			
			Item_Plan_Produccion itEnt = getItemPlanEntity(item);
		}
		return 0;
	}
	
	private Item_Plan_Produccion getItemPlanEntity(DTO.Item_Plan_Produccion itemDTO){
		Item_Plan_Produccion itEnt = new Item_Plan_Produccion();
		itEnt.setCantidad(itemDTO.getCantidad());
		//itEnt.setItem_plan_semielaborado();
		//itEnt.setItem_plan_sucursal();
		
		return itEnt;
	}
}
