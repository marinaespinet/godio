import java.rmi.RemoteException;

import Exceptions.RestaurantException;
import Interfaces.*;

public class Test_Schere {

	public static void main(String[] args) throws RemoteException {
		
		try {
			BusinessDelegate.getInstancia().transferenciaStockByAreaSuc(1, 1, 1, 1, "test", 2, "Lote4");
			
			System.out.println("Stock transferido");
		} catch (RestaurantException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
	}	
}
