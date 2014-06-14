package SERVER;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import BUSINESS.StockController;
import Exceptions.RestaurantException;

public class NegocioRemoto extends UnicastRemoteObject implements Interfaces.RemoteInterface {
	private static final long serialVersionUID = 4516149167297806966L;
	
	protected NegocioRemoto() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transferenciaStockByAreaSuc(Integer prodID, Integer loginID,
			Integer areaId, Integer sucID, String motivo, Integer cant,
			String lote) throws RemoteException {
		// TODO Auto-generated method stub
		StockController.getInstancia().transferenciaStockByAreaSuc(prodID, loginID, areaId, sucID, motivo, cant, lote);
		
	}
	
	//TODO: Agregar todos los metodos de TODOS los CONTROLLERS

}
