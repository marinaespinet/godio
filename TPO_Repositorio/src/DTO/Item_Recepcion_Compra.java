package DTO;

import java.io.Serializable;

public class Item_Recepcion_Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer item_recepcion_id;
	private Producto item_recepcion_producto;
	private Integer cant;
	private Integer Item_Id_Producto;

	public Integer getItem_Id_Producto() {
		return Item_Id_Producto;
	}

	public void setItem_Id_Producto(Integer item_Id_Producto) {
		Item_Id_Producto = item_Id_Producto;
	}

	public Item_Recepcion_Compra(Producto producto, Integer cantidad) {
		super();
		this.item_recepcion_producto = producto;
		this.cant = cantidad;
	}
	
	public Item_Recepcion_Compra() {
	}
	
	public Integer getItem_recepcion_id() {
		return item_recepcion_id;
	}
	public void setItem_recepcion_id(Integer item_recepcion_id) {
		this.item_recepcion_id = item_recepcion_id;
	}
	
	public Producto getItem_recepcion_producto() {
		return item_recepcion_producto;
	}
	public void setItem_recepcion_producto(Producto item_recepcion_producto) {
		this.item_recepcion_producto = item_recepcion_producto;
	}
	
	public Integer getCant() {
		return cant;
	}
	public void setCant(Integer cant) {
		this.cant = cant;
	}
	
	
	
	
}
