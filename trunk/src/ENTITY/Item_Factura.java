package ENTITY;

import javax.persistence.*;


@Entity
@Table(name="ITEMS_FACTURA")


public class Item_Factura {
	@Id
	@GeneratedValue

	private Integer item_id;
	
	@OneToOne
	@JoinColumn(name="plato_id")
	private Plato item_plato;
	
	private Integer cant_plato;
	
	@OneToOne
	@JoinColumn(name="item_id")
	private Item_Pedido item_pedido;
	
	public Item_Factura() {
		super();
	}
	/*	
	public Item_Factura(Plato plato, Integer cantidad,
			Item_Pedido item_pedido) {
		super();
		this.item_plato = plato;
		this.cant_plato = cantidad;
		this.item_pedido = item_pedido;
	}*/
	
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
