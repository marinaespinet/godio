package SERVER;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import DAO.*;
import ENTITY.*;
import BUSINESS.RestauranteController;

public class TDD_Florencia {

	public static void main(String[] args) {
		Mozo unMozo = new Mozo();
		unMozo.setMozo_id(1);
		int comensales = 4;
		//crear los datos para los métodos 
		unitTestAbrirMesa(unMozo, comensales);
		unitTestMesasPorSucursal();
	}



	private static boolean unitTestMesasPorSucursal() {
		System.out.print("Test Mesa libre por Sucursal: ");
		List <Mesa> unasMesas = LocationDAO.getInstancia().getMesasLibresEnSucursal(1);
		if (unasMesas != null){
			for(Mesa unaMesa:unasMesas){
				System.out.println("La sucursal 1 tiene la mesa " + unaMesa.getMesa_id() + " libre");
			}
			return true;
		} else
			System.out.println("No existen mesas libres en la sucursal");
			return false;
		
	}



	//sabe cant comensales y mozo
	private static int unitTestAbrirMesa(Mozo unMozo, int comensales){
		List <Mesa> mesasBuenas=new LinkedList <Mesa>();
		List <Mesa> mesasBuenasSinReservas=new LinkedList <Mesa>();
		List <Mesa> mesas = RestauranteController.getInstancia().getMesasLibresEnSucursal(unMozo.getMozo_sector().getSector_sucursal().getSucursal_id());
		if(mesas != null){
			for (Mesa unaMesa: mesas){
				if(unaMesa.getMax_cant_comensales()>=comensales)
					mesasBuenas.add(unaMesa);
			}
			if(mesasBuenas!=null){
				//chequear reservas
				
				/*select count(*) from RESERVAS where RESERVA_SUCURSAL_ID = :sucursalID and :fechaHOY < (FECHA_DT +MINUTOS_DURACION) and CANT_COMENSALES <= :cantComensales*/
			}
			System.out.println("No hay mesas para los comensales");
			return 0;
		} else
			System.out.println("No hay mesas para los comensales");
			return 0;
	
	}

}