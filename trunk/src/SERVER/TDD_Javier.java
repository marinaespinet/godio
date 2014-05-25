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
		
		//unitTestAreas();
		//unitTestAreaPorNombre();
		//unitTestAreaPorId();
		
		unitTestSectores();
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

	private static boolean unitTestSectores() {
		
		System.out.print("Test Sectores: ");
		List<Sector> losSectores = LocationDAO.getInstancia().getSectores();
		if(losSectores != null){
			for(Sector unSector : losSectores)
				System.out.println("Encontré un sector y se llama: " + unSector.getName() + " que corresponde a la sucursal " + unSector.getSector_sucursal().getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestAreaPorId() {
		
		System.out.print("Test Area por Id: ");
		Area unArea = LocationDAO.getInstancia().getAreaPorId(1);
		if(unArea != null){
		System.out.println("El area con el Id 1 efectivamente existe y se llama " + unArea.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestAreaPorNombre() {

		System.out.print("Test Area por nombre: ");
		Area unArea = LocationDAO.getInstancia().getAreaPorNombre("Cocina");
		if(unArea != null){
		System.out.println("El area " + unArea.getName() + " efectivamente existe y tiene el Id " + unArea.getArea_id());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
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
