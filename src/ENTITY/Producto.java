package ENTITY;

import javax.persistence.*;

//@MappedSuperclass
@Entity @Table(name="PRODUCTOS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Producto {
	
	@Id
	@GeneratedValue
	private Integer producto_id;
	private String name;
	private Integer producto_tipo_caducidad_id;
	private Boolean puede_venta_ind;
	private Float punto_reposicion_cant;
	private Float punto_pedido_cant;
	
	public Float getPunto_reposicion_cant() {
		return punto_reposicion_cant;
	}
	public void setPunto_reposicion_cant(Float punto_reposicion_cant) {
		this.punto_reposicion_cant = punto_reposicion_cant;
	}
	public Float getPunto_pedido_cant() {
		return punto_pedido_cant;
	}
	public void setPunto_pedido_cant(Float punto_pedido_cant) {
		this.punto_pedido_cant = punto_pedido_cant;
	}
	public Integer getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProducto_tipo_caducidad_id() {
		return producto_tipo_caducidad_id;
	}
	public void setProducto_tipo_caducidad_id(Integer producto_tipo_caducidad_id) {
		this.producto_tipo_caducidad_id = producto_tipo_caducidad_id;
	}
	public Boolean getPuede_venta_ind() {
		return puede_venta_ind;
	}
	public void setPuede_venta_ind(Boolean puede_venta_ind) {
		this.puede_venta_ind = puede_venta_ind;
	}
	

	
}
