package ENTITY;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="RECEPCIONES_COMPRAS")
public class RecepcionCompra {
	@Id
	@GeneratedValue

	private Integer recepcion_id;
	private Date recepcion_fecha_dt;
	//private Compra recepcion_compra;
	
	@OneToMany @JoinColumn(name="item_recepcion_recepcion_id")
	private List<Item_Recepcion_Compra> items;	
	

	public Integer getRecepcion_id() {
		return recepcion_id;
	}
	public void setRecepcion_id(Integer recepcion_id) {
		this.recepcion_id = recepcion_id;
	}
	public Date getRecepcion_fecha_dt() {
		return recepcion_fecha_dt;
	}
	public void setRecepcion_fecha_dt(Date recepcion_fecha_dt) {
		this.recepcion_fecha_dt = recepcion_fecha_dt;
	}
	
	public List<Item_Recepcion_Compra> getItems() {
		return items;
	}
	public void setItems(List<Item_Recepcion_Compra> items) {
		this.items = items;
	}
	
	public void agregarItem(Item_Recepcion_Compra itemRecepcionCompra){
		//TODO
	}
	
}
