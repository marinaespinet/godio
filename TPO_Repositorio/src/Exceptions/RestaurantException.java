package Exceptions;

import java.rmi.RemoteException;

public class RestaurantException extends RemoteException {
	private static final long serialVersionUID = 1L;

	public  RestaurantException(){
		super();		
	}
	
	public  RestaurantException(String message){
		super(message);
	}
}
