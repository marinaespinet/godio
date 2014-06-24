package DTO;

import java.io.Serializable;

public class Item_Factura  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String plato;
	private Float importe;
	private Integer item_id;
	private Plato item_plato;
	private Integer cant_plato;
	private Item_Pedido item_pedido;
	
		
	public Item_Factura(Plato plato, Integer cantidad,
			Item_Pedido item_pedido) {
		super();
		this.item_plato = plato;
		this.setCant_plato(cantidad);
		this.item_pedido = item_pedido;
	}
	public Item_Factura() {
		super();
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
	public String getPlato() {
		return plato;
	}
	public void setPlato(String plato) {
		this.plato = plato;
	}
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	public Integer getCant_plato() {
		return cant_plato;
	}
	public void setCant_plato(Integer cant_plato) {
		this.cant_plato = cant_plato;
	}

	
	
}
