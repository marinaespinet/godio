package ENTITY;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="ITEMS_PEDIDOS")

public class Item_Pedido {

	@Id
	private Integer item_id;
	
	@ManyToOne
	@JoinColumn(name="item_pedido_id")
	private Pedido item_pedido;
	
	@OneToOne
	@JoinColumn(name="item_item_carta_id")
	private Item_Carta item_carta;
	
	private Integer cantidad;
	private Boolean item_no_facturar_ind;
	private String observaciones_no_facturar;
	
	public Item_Pedido() {
		super();
	}
	/*
	public Item_Pedido(Pedido pedido, Item_Carta item_carta,
			Integer cantidad) {
		super();
		this.item_pedido = pedido;
		this.item_carta = item_carta;
		this.cantidad = cantidad;
	}*/
	
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public Pedido getItem_pedido() {
		return item_pedido;
	}
	public void setItem_pedido(Pedido item_pedido) {
		this.item_pedido = item_pedido;
	}
	public Item_Carta getItem_carta() {
		return item_carta;
	}
	public void setItem_carta(Item_Carta item_carta) {
		this.item_carta = item_carta;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Boolean getItem_no_facturar_ind() {
		return item_no_facturar_ind;
	}
	public void setItem_no_facturar_ind(Boolean item_no_facturar_ind) {
		this.item_no_facturar_ind = item_no_facturar_ind;
	}
	public String getObservaciones_no_facturar() {
		return observaciones_no_facturar;
	}
	public void setObservaciones_no_facturar(String observaciones_no_facturar) {
		this.observaciones_no_facturar = observaciones_no_facturar;
	}

	
}
