package ENTITY;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Platos")
public class Plato {
	@Id
	@GeneratedValue
	private Integer plato_id;
	private String name;
	
	@ManyToOne @JoinColumn(name="plato_area_id")
	private Area plato_area;
	private Float comision_extra_mozo;
	
	@OneToMany @JoinColumn(name="ingrediente_plato_id")
	private List<Ingrediente>  ingredientes;
	
	
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public Integer getPlato_id() {
		return plato_id;
	}
	public void setPlato_id(Integer plato_id) {
		this.plato_id = plato_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Area getPlato_area() {
		return plato_area;
	}
	public void setPlato_area(Area plato_area) {
		this.plato_area = plato_area;
	}
	public Float getComision_extra_mozo() {
		return comision_extra_mozo;
	}
	public void setComision_extra_mozo(Float comision_extra_mozo) {
		this.comision_extra_mozo = comision_extra_mozo;
	}
	
	private Item_Carta obtenerPlatoAlternativo(){
		//TODO
		return null;
	}
	
}
