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
		Integer planID = 0;
		for(DTO.Item_Plan_Produccion item : tareas){
			//Check sucursal Existe
			Sucursal suc = DAO.LocationDAO.getInstancia().getSucursalPorId(item.getSucursalID());
			if(suc == null){ throw new RestaurantException("Sucursal "+item.getSucursalID().toString()+ " inexistente en tarea de produccion");}
			//Check Semielaborado Existe
			Semielaborado semi = DAO.ProductosDAO.getInstancia().getSemielaborado(item.getSemielaboradoID());
			if(semi == null){ throw new RestaurantException("Semielaborado "+item.getSemielaboradoID().toString()+ " inexistente en tarea de produccion");}
			
			if(item.getPlan_id()==null)
				planID=0;
			else				
				planID = item.getPlan_id();
			
			Plan_Produccion plan;
			if(planID ==0 ){
				//Add new plan and return id
				plan= DAO.PlanProduccionDAO.getInstancia().nuevoPlanProduccion();
			} else {
				plan = DAO.PlanProduccionDAO.getInstancia().getPlanProduccion(planID);
			}
			
			Item_Plan_Produccion itEnt = getItemPlanEntity(item);
			itEnt.setPlan(plan);
			itEnt.setSemielaborado(semi);
			itEnt.setSucursal(suc);
			
			DAO.PlanProduccionDAO.getInstancia().grabarItemPlan(itEnt);
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
	
	public void registrarAvancePlanProduccion(int sucursal, int codSemielaborado, int cantidadProducida) throws RestaurantException {
		Sucursal suc = DAO.LocationDAO.getInstancia().getSucursalPorId(sucursal);
		if(suc == null)
			{ throw new RestaurantException("Sucursal "+ sucursal + " inexistente en tarea de produccion");}
		
		Semielaborado semi = DAO.ProductosDAO.getInstancia().getSemielaborado(codSemielaborado);
		if(semi == null)
			{ throw new RestaurantException("Semielaborado " + codSemielaborado + " inexistente en tarea de produccion");}
		
		Item_Plan_Produccion item = PlanProduccionDAO.getInstancia().getItemPorSucursalySemielaborado(sucursal, codSemielaborado);
		if(item!=null){
			int avance = (cantidadProducida/item.getCantidad())+item.getItem_plan_avance_qty();
			if(avance<1){
				item.setAvance(avance);
				PlanProduccionDAO.getInstancia().grabarItemPlan(item);
				}
			else
				throw new RestaurantException("La cantidad producida excede lo indicado en el plan de produccion");
		}
		else 
			{throw new RestaurantException("No existen tareas pendientes para la sucursal y el semielaborado ingresados");}
	
	}
	
}
