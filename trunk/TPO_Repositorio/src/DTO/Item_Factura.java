package DTO;

public class Item_Factura {

	private Integer item_id;
	private Plato item_plato;
	private Integer cant_plato;
	private Item_Pedido item_pedido;
	
		
	public Item_Factura(Plato plato, Integer cantidad,
			Item_Pedido item_pedido) {
		super();
		this.item_plato = plato;
		this.cant_plato = cantidad;
		this.item_pedido = item_pedido;
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public Plato getItem_plato() {
		return item_plato;
	}
	public void setItem_plato(Plato item_plato) {
		this.item_plato = item_plato;
	}
	public Item_Pedido getItem_pedido() {
		return item_pedido;
	}
	public void setItem_pedido(Item_Pedido item_pedido) {
		this.item_pedido = item_pedido;
	}
	
	
	
}