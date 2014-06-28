package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class ComprasDAO {
	private static ComprasDAO instancia = null;
	private static SessionFactory sf = null;

	public static ComprasDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ComprasDAO();
		} 
		return instancia;
	}
	
	
	//Trae todos los que estan agotados o debajo del punto de reposicion
	@SuppressWarnings("unchecked")
	public List<Insumo> getComprasRealizar()
	{
		Session session = sf.openSession();
		List<Insumo> list = (List<Insumo>)session.createQuery(""
				+ "SELECT i "				
				+ "FROM Insumo i JOIN i.estado est "
				+ "WHERE est.estado_id>1 AND i.puede_compra_ind=1").list();			
		
		session.close();

		return list;
	}


	public void setRecepcionCompra(RecepcionCompra recepcionEnt) {
		Session session = sf.openSession();
		session.save(recepcionEnt);
		//session.flush();
		session.close();
			
	}


	public Proveedor getProveedor(int proveedorId) {
		Session session = sf.openSession();
		Proveedor proveedor =(Proveedor) session.get(Proveedor.class,proveedorId); 
		session.close();
		return proveedor;
	}


	public void grabarCompra(Compra compra) {
		Session session = sf.openSession();
		session.saveOrUpdate(compra);
		session.flush();
		session.close();
		
	}


	public Compra getCompraPorProveedor(Integer proveedor_id) {
		Session session = sf.openSession();
		Integer id = (Integer)session.createQuery("Select co.compra_id FROM Compra co JOIN co.compra_proveedor prov WHERE prov.proveedor_id=? ORDER BY co.fecha_compra_dt DESC").setInteger(0, proveedor_id).setFirstResult(0).setMaxResults(1).uniqueResult();
		Compra compra = (Compra) session.get(Compra.class, id);
		return compra;
	}


	public void agregarItemCompra(Item_Compra it) {
		Session session = sf.openSession();
		session.saveOrUpdate(it);
		session.flush();session.close();
		
	}


	public Compra getCompra(int id) {
		Session session = sf.openSession();
		Compra compra = (Compra) session.get(Compra.class, id);
		return compra;
	}
	
}
