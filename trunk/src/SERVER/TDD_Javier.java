package SERVER;

import java.util.List;

import DAO.*;
import ENTITY.*;

public class TDD_Javier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//unitTestSucursales();
		//unitTestSucursalPorNombre();
		//unitTestSucursalPorId();
		
		unitTestAreas();
		//unitTestAreaPorNombre();
		//unitTestAreaPorId();
		
		//unitTestSectores();
		//unitTestSectorPorNombre();
		//unitTestSectorPorId();
		
		//unitTestMozos();
		//unitTestMozoPorNombre();
		//unitTestMozoPorId();
		
		//unitTestReservas();
		//unitTestReservaPorId();
		//unitTestReservaPorFecha();
		//unitTestCrearReserva();

	}
	
	private static void unitTestCrearReserva() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestReservaPorFecha() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestReservaPorId() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestReservas() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestMozoPorId() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestMozoPorNombre() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestMozos() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestSectorPorId() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestSectorPorNombre() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestSectores() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestAreaPorId() {
		// TODO Auto-generated method stub
		
	}

	private static void unitTestAreaPorNombre() {
		// TODO Auto-generated method stub
		
	}

	private static boolean unitTestAreas() {
		
		System.out.print("Test Areas: ");
		List<Area> lasAreas = LocationDAO.getInstancia().getAreas();
		if(lasAreas != null){
			for(Area unArea : lasAreas)
				System.out.println("Encontré un area y se llama: " + unArea.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSucursalPorId() {
		
		System.out.print("Test Sucursal por Id: ");
		Sucursal unaSucursal = LocationDAO.getInstancia().getSucursalPorId(4);
		if(unaSucursal != null){
		System.out.println("La sucursal Nro " + unaSucursal.getSucursal_id() + " efectivamente existe y se llama " + unaSucursal.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSucursalPorNombre() {
		
		System.out.print("Test Sucursal por nombre: ");
		Sucursal unaSucursal = LocationDAO.getInstancia().getSucursalPorNombre("Belgrano");
		if(unaSucursal != null){
		System.out.println("La sucursal " + unaSucursal.getName() + " efectivamente existe y tiene " + unaSucursal.getCant_max_mesas() + " mesas");
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	public static boolean unitTestSucursales(){
		
		System.out.print("Test Sucursales: ");
		List<Sucursal> lasSucursales = LocationDAO.getInstancia().getSucursales();
		if(lasSucursales != null){
			for(Sucursal laSuc : lasSucursales)
				System.out.println("Encontré una sucursal y se llama: " + laSuc.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}
	
	
	


}
