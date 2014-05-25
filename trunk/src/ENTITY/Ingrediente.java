package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="Ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue

	private Integer ingrediente_id;
	@ManyToOne @JoinColumn(name="INGREDIENTE_INSUMO_ID")
	private Insumo insumo;
	private Integer cantidad;
	
	@ManyToOne @JoinColumn(name="ingrediente_plato_id")
	private Plato ingrediente_plato;
	
	public Integer getIngrediente_id() {
		return ingrediente_id;
	}
	public void setIngrediente_id(Integer ingrediente_id) {
		this.ingrediente_id = ingrediente_id;
	}
	public Insumo getIngrediente_producto() {
		return insumo;
	}
	public void setIngrediente_insumo(Insumo insumo) {
		this.insumo = insumo;
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
