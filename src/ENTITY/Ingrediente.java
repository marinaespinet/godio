package ENTITY;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Ingredientes")


public class Ingrediente {

	private Integer ingrediente_id;
	private Producto ingrediente_producto;
	private Integer cantidad;
	
	
	public Integer getIngrediente_id() {
		return ingrediente_id;
	}
	public void setIngrediente_id(Integer ingrediente_id) {
		this.ingrediente_id = ingrediente_id;
	}
	public Producto getIngrediente_producto() {
		return ingrediente_producto;
	}
	public void setIngrediente_producto(Producto ingrediente_producto) {
		this.ingrediente_producto = ingrediente_producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Integer verificarDisponibilidadIngredientes(){
		//TODO
		return 0;
	}
	
	public void modificarStockIngrediente(Integer cantidad){
		//TODO
	}
}
