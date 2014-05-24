package ENTITY;

import java.sql.Date;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name="Facturas")


public class Factura {

	private Integer factura_id;
	private Date fecha_factura_dt;
	private Mesa factura_mesa;
	private Mozo factura_mozo;
	private Float monto_total;
	private Vector<Item_Factura>items;
	
	
	
	public Factura(Date fecha, Mesa mesa, Mozo mozo,
			Vector<Item_Factura> items) {
		super();
		this.fecha_factura_dt = fecha;
		this.factura_mesa = mesa;
		this.factura_mozo = mozo;
		this.items = items;
	}
	
	public Integer getFactura_id() {
		return factura_id;
	}
	public void setFactura_id(Integer factura_id) {
		this.factura_id = factura_id;
	}
	public Date getFecha_factura_dt() {
		return fecha_factura_dt;
	}
	public void setFecha_factura_dt(Date fecha_factura_dt) {
		this.fecha_factura_dt = fecha_factura_dt;
	}
	public Mesa getFactura_mesa() {
		return factura_mesa;
	}
	public void setFactura_mesa(Mesa factura_mesa) {
		this.factura_mesa = factura_mesa;
	}
	public Mozo getFactura_mozo() {
		return factura_mozo;
	}
	public void setFactura_mozo(Mozo factura_mozo) {
		this.factura_mozo = factura_mozo;
	}
	public Float getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Float monto_total) {
		this.monto_total = monto_total;
	}
	public Vector<Item_Factura> getItems() {
		return items;
	}
	public void setItems(Vector<Item_Factura> items) {
		this.items = items;
	}
	
	public void calcularMonto(){
		//TODO
	}
	
}
