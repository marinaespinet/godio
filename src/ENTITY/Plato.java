package ENTITY;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="")


public class Plato {

	private Integer plato_id;
	private String name;
	private Area plato_area;
	private Float comision_extra_mozo;
	private Receta plato_receta;
	
	
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
	public Receta getPlato_receta() {
		return plato_receta;
	}
	public void setPlato_receta(Receta plato_receta) {
		this.plato_receta = plato_receta;
	}
	
	private Item_Carta obtenerPlatoAlternativo(){
		//TODO
		return null;
	}
	
}
