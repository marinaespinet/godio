package SERVER;

import Exceptions.RestaurantException;
import Interfaces.*;

import java.rmi.*;
import java.rmi.registry.*;


public class Servidor {

	RemoteInterface negocioRemoto;
	
	public Servidor()
	{
		inicializar();
	}

	public void inicializar(){
		try {
			LocateRegistry.createRegistry(1099);
			negocioRemoto = new NegocioRemoto();
			java.rmi.
			Naming.rebind ("//localhost/SistemaRemoto", negocioRemoto);
			System.out.println("Se cargó el servidor en //localhost/SistemaRemoto");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Main
	public static void main(String[] args) throws RestaurantException {

		new Servidor();
	}
	
}
