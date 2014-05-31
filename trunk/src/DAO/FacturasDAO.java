package DAO;

import java.util.List;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class FacturasDAO {
	private static FacturasDAO instancia = null;
	private static SessionFactory sf = null;

	public static FacturasDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new FacturasDAO();
		} 
		return instancia;
	}
	
	
	//Graba factura
	public void grabarFactura(Factura aux){				
		Session session = sf.openSession();
		session.persist(aux);
		session.flush();
		session.close();
	}
	
	//Calcula el monto a partir del precio de los platos 
	//"No facturar=falso" y cantidad pedida de c/u
	public Double calcularMonto(int nroFact){
		Session session = sf.openSession();
		Double monto = (Double)session.createQuery("SELECT SUM(itc.precio_monto*itp.cantidad) FROM Item_Factura itf JOIN itf.factura fac JOIN itf.item_pedido itp JOIN itp.item_carta itc WHERE fac.factura_id=? AND itp.item_no_facturar_ind=false").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		return monto;
	}
	
	public void addItemsFactura(Item_Factura item){
		Session session = sf.openSession();
		session.persist(item);
		session.flush();
		session.close();
	}
	
	public Double getMontoPagos(int nroFact){
		Session session = sf.openSession();
		Double monto = (Double)session.createQuery("SELECT SUM(p.monto_total) FROM Factura f JOIN f.pagos WHERE f.factura_id=?").setInteger(0,nroFact).setFirstResult(0).setMaxResults(1).uniqueResult();
		return monto;
	}
		
}
