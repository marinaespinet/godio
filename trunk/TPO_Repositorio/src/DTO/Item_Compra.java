package DTO;

public class Item_Compra {

	private Integer item_compra_id;
	private Integer item_producto;
	private Integer item_compra_cant;
	private Double item_precio_monto;
	
	
	
	public Item_Compra(Integer producto, Integer cantidad,
			Double precio) {
		super();
		this.item_producto = producto;
		this.item_compra_cant = cantidad;
		this.item_precio_monto = precio;
	}
	public Integer getItem_compra_id() {
		return item_compra_id;
	}
	public void setItem_compra_id(Integer item_compra_id) {
		this.item_compra_id = item_compra_id;
	}
	public Integer getItem_producto() {
		return item_producto;
	}
	public void setItem_producto(Integer item_producto) {
		this.item_producto = item_producto;
	}
	public Integer getItem_compra_cant() {
		return item_compra_cant;
	}
	public void setItem_compra_cant(Integer item_compra_cant) {
		this.item_compra_cant = item_compra_cant;
	}
	public Double getItem_precio_monto() {
		return item_precio_monto;
	}
	public void setItem_precio_monto(Double item_precio_monto) {
		this.item_precio_monto = item_precio_monto;
	}
	
	
	
}
