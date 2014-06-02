package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="STOCK")
public class Stock {

	@Id
	@GeneratedValue
	private Integer stock_id;
	
	@OneToOne
	@JoinColumn(name="STOCK_DEPOSITO_ID")
	private Deposito stock_deposito;
	
	@OneToOne
	@JoinColumn(name="STOCK_PRODUCTO_ID")
	private Producto producto;
	private Integer cantidad;
	private Date fecha_vencimiento_producto_dt;
	
	public Integer getStock_id() {
		return stock_id;
	}
	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}
	public Deposito getStock_deposito() {
		return stock_deposito;
	}
	public void setStock_deposito(Deposito stock_deposito) {
		this.stock_deposito = stock_deposito;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto stock_producto) {
		this.producto = stock_producto;
	}



	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha_vencimiento_producto_dt() {
		return fecha_vencimiento_producto_dt;
	}
	public void setFecha_vencimiento_producto_dt(Date fecha_vencimiento_producto_dt) {
		this.fecha_vencimiento_producto_dt = fecha_vencimiento_producto_dt;
	}
	
	
	
}
