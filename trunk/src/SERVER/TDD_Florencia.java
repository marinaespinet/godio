package SERVER;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import DAO.*;
import ENTITY.*;
import BUSINESS.CajaController;
import BUSINESS.RestauranteController;

public class TDD_Florencia {

	public static void main(String[] args) {
		Mozo unMozo = new Mozo();
		unMozo.setMozo_id(1);
		int comensales = 4;
		Date hoy;
		//crear los datos para los métodos 
		//unitTestAbrirMesa(unMozo, comensales);
		//unitTestMesasPorSucursal();
		//unitTestLiquidarComisiones(hoy);
		//unitTestRegistrarOC();
	}



	private static boolean unitTestMesasPorSucursal() {
		System.out.print("Test Mesa libre por Sucursal: ");
		List <Mesa> unasMesas = LocationDAO.getInstancia().getMesasLibresEnSucursal(1, null);
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
		List <Mesa> mesas = RestauranteController.getInstancia().getMesasLibresEnSucursal(unMozo.getMozo_sector().getSector_sucursal().getSucursal_id(), comensales);
		if(mesas != null){
			for (Mesa unaMesa: mesas){
				if(unaMesa.getMax_cant_comensales()>=comensales)
					mesasBuenas.add(unaMesa);
			}
			if(mesasBuenas!=null){
				//chequear reservas
				Long cantidadReserva = RestauranteController.getInstancia().getCantidadReservas(unMozo.getMozo_sector().getSector_sucursal().getSucursal_id());
				if (cantidadReserva<mesasBuenas.size()){
					return mesasBuenas.get(0).getMesa_id(); //devuelvo la primer mesa
				}
				

				
			}
			System.out.println("No hay mesas para los comensales");
			return 0;
		} else
			System.out.println("No hay mesas para los comensales");
			return 0;
	
	}

	private static List <Liquidacion_Comision_Mozo> unitTestLiquidarComisiones(Date d){
		List <Liquidacion_Comision_Mozo> liquidoComisiones = new LinkedList <Liquidacion_Comision_Mozo>();
		//me traigo a los mozos
		List <Mozo> todosMozos = new LinkedList <Mozo>();
		todosMozos= LocationDAO.getInstancia().getMozos();
		//liquido a cada uno
		float liquidacionDia;
		Date hoy = new java.sql.Date(System.currentTimeMillis());
		for(Mozo unMozo:todosMozos){
			liquidacionDia = CajaController.getInstancia().liquidarComisionMozo(d, unMozo.getMozo_id());
			Liquidacion_Comision_Mozo liqmozo = new Liquidacion_Comision_Mozo(); 
			liqmozo.setFecha_liquidacion_dt(d);
			liqmozo.setImporte_amount(liquidacionDia);
			liqmozo.setFecha_liquidacion_dt(hoy);
			liqmozo.setComision_mozo(unMozo);
			//guardo el que creo
			liquidoComisiones.add(liqmozo);
			
		}
		//persisto todas
		// por mozo?
		
		for(Liquidacion_Comision_Mozo l:liquidoComisiones){
			FacturasDAO.getInstancia().grabarLiquidaciones(liquidoComisiones.get(l.getComision_mozo().getMozo_id()));
		}
		//liquidoComisiones = CajaController.getInstancia().liquidarComisionMozo(d, mozo);
		
		return liquidoComisiones;
	}
	/*private static void unitTestRegistrarOC(int Prov_id, int Prod_id, int cant){
		ProductosDAO.getInstancia().getProducto(Prod_id);
	}*/
	
}