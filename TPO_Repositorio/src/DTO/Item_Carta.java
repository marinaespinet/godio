package DTO;

import java.io.Serializable;

public class Item_Carta  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer item_carta_id;
	private Plato item_plato;
	private String rubro;
	private Float precio_monto;
	
	
	public Integer getItem_carta_id() {
		return item_carta_id;
	}
	public void setItem_carta_id(Integer item_carta_id) {
		this.item_carta_id = item_carta_id;
	}
	public Plato getItem_plato() {
		return item_plato;
	}
	public void setItem_plato(Plato item_plato) {
		this.item_plato = item_plato;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public Float getPrecio_monto() {
		return precio_monto;
	}
	public void setPrecio_monto(Float precio_monto) {
		this.precio_monto = precio_monto;
	}
	
}
