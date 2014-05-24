
public class Item_Comanda {

	private Integer item_comanda;
	private Item_Pedido item_comanda_item_pedido;
	
	
	
	
	public Item_Comanda(Item_Pedido item) {
		super();
		this.item_comanda_item_pedido = item;
	}
	public Integer getItem_comanda() {
		return item_comanda;
	}
	public void setItem_comanda(Integer item_comanda) {
		this.item_comanda = item_comanda;
	}
	public Item_Pedido getItem_comanda_item_pedido() {
		return item_comanda_item_pedido;
	}
	public void setItem_comanda_item_pedido(Item_Pedido item_comanda_item_pedido) {
		this.item_comanda_item_pedido = item_comanda_item_pedido;
	}
	
	
	
}
