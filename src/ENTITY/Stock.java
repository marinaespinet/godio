package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="")


public class Stock {
@Id
@GeneratedValue
	private Integer stock_id;
	private Deposito stock_deposito;
	private Producto stock_producto;
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
	public Producto getStock_producto() {
		return stock_producto;
	}
	public void setStock_producto(Producto stock_producto) {
		this.stock_producto = stock_producto;
	}
	public Integer getCantidad(Producto producto) {
		//TODO
		return cantidad;
	}
	
	public void descontarStock(Integer cantidad){
		//TODO
	}
	
	public void agregarStock(Integer cantidad){
		//TODO
	}
	
	public Boolean verificarCantidad(Producto producto,Integer cantidad,Deposito deposito){
		//TODO
		return true;
	}
	public Date getFecha_vencimiento_producto_dt() {
		return fecha_vencimiento_producto_dt;
	}
	public void setFecha_vencimiento_producto_dt(Date fecha_vencimiento_producto_dt) {
		this.fecha_vencimiento_producto_dt = fecha_vencimiento_producto_dt;
	}
	
	
	
}
