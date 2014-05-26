package ENTITY;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items_Carta")


public class Item_Carta {
	@Id
	@GeneratedValue

	private Integer item_carta_id;
	
	@OneToOne
	@JoinColumn(name="item_plato_id")
	private Plato item_plato;
	
	@ManyToOne
	@JoinColumn(name="CARTA_RUBRO_ID")
	private Rubro_Carta rubro;
	
	private Float precio_monto;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CARTA_CARTA_ID")
	private Carta carta;
	
	
	public Integer getItem_carta_id() {
		return item_carta_id;
	}
	public void setItem_carta_id(Integer item_carta_id) {
		this.item_carta_id = item_carta_id;
	}
	public Plato getPlato() {
		return item_plato;
	}
	public void setPlato(Plato item_plato) {
		this.item_plato = item_plato;
	}
	public Rubro_Carta getRubro() {
		return rubro;
	}
	public void setRubro(Rubro_Carta rubro) {
		this.rubro = rubro;
	}
	public Float getPrecio_monto() {
		return precio_monto;
	}
	public void setPrecio_monto(Float precio_monto) {
		this.precio_monto = precio_monto;
	}
	
	public Integer verificarDisponibilidad(){
		
		//TODO
		return 0;
	}
	
}
