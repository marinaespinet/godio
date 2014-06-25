package DTO;

import java.io.Serializable;

public class Item_Factura  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String plato;
	private Float importe;
	private Integer item_id;
	private Integer cant_plato;
	private boolean no_facturar;
	
	public Item_Factura() {
		super();
	}
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
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
	public boolean isNo_facturar() {
		return no_facturar;
	}
	public void setNo_facturar(boolean no_facturar) {
		this.no_facturar = no_facturar;
	}

	
	
}
