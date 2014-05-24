package ENTITY;

import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name="Comandas")
public class Comanda {

	private Integer comanda_id;
	private String estado;
	private Vector<Item_Comanda>items;
	
	
	public Comanda(Vector<Item_Comanda> items) {
		super();
		this.items = items;
	}
	public Integer getComanda_id() {
		return comanda_id;
	}
	public void setComanda_id(Integer comanda_id) {
		this.comanda_id = comanda_id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Vector<Item_Comanda> getItems() {
		return items;
	}
	public void setItems(Vector<Item_Comanda> items) {
		this.items = items;
	}
	
	
	
}
