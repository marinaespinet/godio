package ENTITY;
import javax.persistence.*;


@Entity
@Table(name="Items_Compra")
public class Item_Compra {
	@Id
	@GeneratedValue
	private Integer item_compra_id;
	
	@ManyToOne
	@JoinColumn(name="item_producto_id")
	private Producto item_producto;
	
	private Integer item_compra_cant;
	private Float item_precio_monto;
	
	@ManyToOne
	@JoinColumn(name="item_compra_compra_id")
	private Compra item_compra_compra_id;
	
	public Integer getItem_compra_id() {
		return item_compra_id;
	}
	public void setItem_compra_id(Integer item_compra_id) {
		this.item_compra_id = item_compra_id;
	}
	public Producto getItem_producto() {
		return item_producto;
	}
	public void setItem_producto(Producto item_producto) {
		this.item_producto = item_producto;
	}
	public Integer getItem_compra_cant() {
		return item_compra_cant;
	}
	public void setItem_compra_cant(Integer item_compra_cant) {
		this.item_compra_cant = item_compra_cant;
	}
	public Float getItem_precio_monto() {
		return item_precio_monto;
	}
	public void setItem_precio_monto(Float item_precio_monto) {
		this.item_precio_monto = item_precio_monto;
	}
	
	
	
}
