package ENTITY;


public class Item_Recepcion_Compra {

	private Integer item_recepcion_id;
	private Producto item_recepcion_producto;
	private Integer cant;
	
	
	
	public Item_Recepcion_Compra(Producto producto, Integer cantidad) {
		super();
		this.item_recepcion_producto = producto;
		this.cant = cantidad;
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
