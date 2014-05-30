package BUSINESS;

import java.sql.Date;
import java.util.*;

import DAO.*;
import ENTITY.*;

public class RestauranteController {
	private static RestauranteController instancia = null;

	public static RestauranteController getInstancia(){
		if(instancia == null){			
			instancia = new RestauranteController();
		} 
		return instancia;
	}
	

	public Date getDate(int year,int month,int day,int hour,int minutes){
		
		int elMesReal = month -1;
		Calendar unaFecha = Calendar.getInstance();
		unaFecha.set(Calendar.YEAR,year);
		unaFecha.set(Calendar.MONTH,elMesReal);
		unaFecha.set(Calendar.DAY_OF_MONTH,day);
		unaFecha.set(Calendar.HOUR_OF_DAY, hour);
		unaFecha.set(Calendar.MINUTE, minutes);
		
		Date laFecha = new java.sql.Date(unaFecha.getTimeInMillis());
		
		return laFecha;
	}
}
