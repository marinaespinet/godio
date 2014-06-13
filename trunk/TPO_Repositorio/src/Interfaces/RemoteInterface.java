package Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Exceptions.RestaurantException;

public interface RemoteInterface extends Remote {

	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID, Integer areaId, Integer sucID, String motivo, Integer cant, String lote) 
				throws RemoteException;
	
	
	
}	
