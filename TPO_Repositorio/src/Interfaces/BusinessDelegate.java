package Interfaces;

import Exceptions.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class BusinessDelegate {
	private static BusinessDelegate instancia;
	private RemoteInterface ri;
	
	private BusinessDelegate() throws RemoteException
	{
		conexionRemota();
	}
	
	public static BusinessDelegate getInstancia() throws RemoteException
	{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	
	
	private void conexionRemota() throws RemoteException{	
		try{
			ri = (RemoteInterface) Naming.lookup("//localHost/SistemaRemoto");	
		}
		catch(NotBoundException nbe){
			System.out.println("MalformedURLException: "+ nbe.toString());
		}
		catch(MalformedURLException re){
			System.out.println("RemoteException: "+ re.toString());
		}
	}
	
	
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) throws RemoteException{
		try {	
			ri.transferenciaStockByAreaSuc(prodID, loginID, areaId, sucID, motivo, cant, lote);
		} catch (RestaurantException r){
				
		}
		
	}
	
	



}
