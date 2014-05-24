package ENTITY;

import java.sql.Date;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name="Compras")


public class Compra {

	private Integer compra_id;
	private Proveedor compra_proveedor;
	private Date fecha_compra_dt;
	private Vector<Item_Compra>items;
	
	
	public Compra(Proveedor proveedor) {
		super();
		this.compra_proveedor = proveedor;
	}
	public Integer getCompra_id() {
		return compra_id;
	}
	public void setCompra_id(Integer compra_id) {
		this.compra_id = compra_id;
	}
	public Proveedor getCompra_proveedor() {
		return compra_proveedor;
	}
	public void setCompra_proveedor(Proveedor compra_proveedor) {
		this.compra_proveedor = compra_proveedor;
	}
	public Date getFecha_compra_dt() {
		return fecha_compra_dt;
	}
	public void setFecha_compra_dt(Date fecha_compra_dt) {
		this.fecha_compra_dt = fecha_compra_dt;
	}
	public Vector<Item_Compra> getItems() {
		return items;
	}
	public void setItems(Vector<Item_Compra> items) {
		this.items = items;
	}
	
	public void agregarItems(Item_Compra item){
		//TODO
	}
	
	
}
