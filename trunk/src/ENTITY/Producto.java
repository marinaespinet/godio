package ENTITY;

import javax.persistence.*;

//@MappedSuperclass
@Table(name="PRODUCTO")
@Inheritance(strategy=InheritanceType.JOINED)
public class Producto {
	
	
	@Id
	@GeneratedValue
	private Integer producto_id;
	private String name;
	private Integer producto_tipo_caducidad_id;
	private Boolean puede_venta_ind;
	
	
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
	
	public int verificarStock(){
		//TODO
		return 0;
	}
	
	public void modificarStockProducto(Integer cantidad){
		//TODO
	}
	
}
