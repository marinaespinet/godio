package DAO;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ENTITY.*;

public class OperacionCajaDAO {

	private static OperacionCajaDAO instancia = null;
	private static SessionFactory sf = null;

	public static OperacionCajaDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new OperacionCajaDAO();
		} 
		return instancia;
	}
	
	public Tipo_Operacion_Caja getTipo(int id){
		Session session = sf.openSession();
		Tipo_Operacion_Caja tipo = (Tipo_Operacion_Caja) session.createQuery("FROM Tipo_Operacion_Caja toc WHERE toc.tipo_operacion_caja_id=?").setInteger(0,id).setFirstResult(0).setMaxResults(1).uniqueResult();
		return tipo;
	}
	
	public Tipo_Comprobante getTipoComprobante(int id){
		Session session = sf.openSession();
		Tipo_Comprobante tipo = (Tipo_Comprobante) session.createQuery("FROM Tipo_Comprobante tc WHERE tc.tipo_comprobante_id=?").setInteger(0,id).setFirstResult(0).setMaxResults(1).uniqueResult();
		return tipo;
	}
	
	public Long verificarOperacionCaja(Date hoy, int operacion, int sucursal){
		Session session = sf.openSession();
		Long operaciones = (Long)session.createQuery("SELECT COUNT(oc.operacion_caja_id) FROM Operacion_Caja oc JOIN oc.tipo oct JOIN oc.cierre_sucursal_id suc WHERE oc.fecha_dt=? AND oct.tipo_operacion_caja_id=? AND suc.sucursal_id=?").setDate(0, hoy).setInteger(1,operacion).setInteger(2,sucursal).setFirstResult(0).setMaxResults(1).uniqueResult();
		return operaciones;
	}
	
	//Graba un item (update o insert) de un cierre o apertura de caja
	public void setItemCaja(Item_Operacion_Caja item) {
		Session session = sf.openSession();
		session.saveOrUpdate(item);
		session.flush();
		session.close();
	}
	
	//Busca por Id
	public Operacion_Caja getOperacion(Integer id){
		Session session = sf.openSession();
		Operacion_Caja op = (Operacion_Caja)session.createQuery("FROM Operacion_Caja op WHERE op.operacion_caja_id=?").setInteger(0, id).setFirstResult(0).setMaxResults(1).uniqueResult();
		session.close();
		return op;
	}
	
	//Calcular monto de la operación
	public Double calcularMonto(int operacion){
		Session session = sf.openSession();
		Double monto = (Double)session.createQuery("SELECT SUM(ioc.monto*ioc.cantidad)FROM Item_Operacion_Caja ioc JOIN ioc.item_cierre_cierre_id op WHERE op.operacion_caja_id=?").setInteger(0,operacion).setFirstResult(0).setMaxResults(1).uniqueResult();
		return monto;
	}
	
	//Graba un cierre o apertura de caja
	public void grabarOperacionCaja(Operacion_Caja op) {
		Session session = sf.openSession();
		session.saveOrUpdate(op);
		session.flush();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Item_Operacion_Caja> listarItems(Integer id) {
		Session session = sf.openSession();
		List<Item_Operacion_Caja> list = (List<Item_Operacion_Caja>)session.createQuery("SELECT oc.items FROM Operacion_Caja oc WHERE oc.operacion_caja_id=?").setInteger(0, id).list();
		session.close();
		return list;
	}
	
	public void setTipoComprobante(Tipo_Comprobante tc) {
		Session session = sf.openSession();
		session.persist(tc);
		session.flush();
		session.close();
	}

	public void setComisionMozo(Liquidacion_Comision_Mozo laLiquidacion) {
		Session session = sf.openSession();
		session.persist(laLiquidacion);
		session.flush();
		session.close();		
	}

	public Float calcularComisionMozo(int mozo_id) {
		Session session = sf.openSession();
		Long operaciones = (Long)session.createQuery(""
				+ "SELECT SUM(oc.operacion_caja_id) "
				+ "FROM Operacion_Caja oc "
				+ "JOIN oc.tipo oct "
				+ "JOIN oc.cierre_sucursal_id suc "
				+ "WHERE oc.fecha_dt=? "
				+ "AND oct.tipo_operacion_caja_id=? AND suc.sucursal_id=?").setInteger(0, mozo_id).setFirstResult(0).setMaxResults(1).uniqueResult();
		return operaciones.floatValue();
	}
	
}
