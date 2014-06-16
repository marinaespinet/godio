import java.rmi.RemoteException;
import java.sql.Date;
import java.util.Calendar;

import Exceptions.RestaurantException;
import Interfaces.*;

public class Test_Javier {

	public static void main(String[] args) throws RemoteException {
		
		try {
			Calendar unaFecha = Calendar.getInstance();
			unaFecha.set(Calendar.YEAR,2014);
			unaFecha.set(Calendar.MONTH,04);
			unaFecha.set(Calendar.DAY_OF_MONTH,29);
			unaFecha.set(Calendar.HOUR_OF_DAY, 00);
			unaFecha.set(Calendar.MINUTE, 00);
			
			Date laFecha = new java.sql.Date(unaFecha.getTimeInMillis());

			BusinessDelegate.getInstancia().liquidarComisionesMozos(laFecha, 1);
			
			System.out.println("Mozos liquidados");
			
			
		} catch (RestaurantException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
	}	
}
