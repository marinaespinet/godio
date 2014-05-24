package ENTITY;
import javax.persistence.*;


@Entity
@Table(name="ITEMS_RECEPCION_COMPRA")

public class Item_Recepcion_Compra {
	@Id
	@GeneratedValue

	private Integer item_recepcion_id;
	@ManyToOne
	@JoinColumn(name="item_recepcion_producto_id")
	private Producto item_recepcion_producto;
	private Integer cant;
	
	
	public Integer getItem_recepcion_id() {
		return item_recepcion_id;
	}
	public void setItem_recepcion_id(Integer item_recepcion_id) {
		this.item_recepcion_id = item_recepcion_id;
	}
	public Producto getItem_recepcion_producto() {
		return item_recepcion_producto;
	}
	public void setItem_recepcion_producto(Producto item_recepcion_producto) {
		this.item_recepcion_producto = item_recepcion_producto;
	}
	public Integer getCant() {
		return cant;
	}
	public void setCant(Integer cant) {
		this.cant = cant;
	}
	
	
	
	
}
