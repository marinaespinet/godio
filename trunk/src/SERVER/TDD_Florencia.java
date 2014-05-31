package SERVER;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import DAO.*;
import ENTITY.*;
import BUSINESS.RestauranteController;

public class TDD_Florencia {

	public static void main(String[] args) {
		//crear los datos para los métodos 
		//unitTestAbrirMesa();
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
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}



	//sabe cant comensales y mozo
	/*private static int unitTestAbrirMesa(Mozo unMozo, int comensales){
		List <Mesa> mesasBuenas;
		List <Mesa> mesas = RestauranteController.getInstancia().getMesasLibresEnSucursal(unMozo.getMozo_sector().getSector_sucursal().getSucursal_id());
		if(mesas != null){
			for (Mesa unaMesa: mesas){
				if(unaMesa.getMax_cant_comensales()>=comensales)
					mesasBuenas.add(unaMesa);
			}
			if(mesasBuenas!=null){
				//chequear reservas
			}
			return mesasBuenas;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
	
	}*/

}