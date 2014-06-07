package Interfaces;

import Exceptions.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class BusinessDelegate {
	private RemoteInterface ri;
	
	
	//constructor
	public BusinessDelegate() throws RemoteException{	
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
	
	
	public void transferirStock(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) throws RemoteException{
		ri.transferirStock(prodID, loginID, areaId, sucID, motivo, cant, lote);
	}
	
	



}
