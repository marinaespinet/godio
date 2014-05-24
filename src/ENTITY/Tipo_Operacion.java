package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="")


public class Tipo_Operacion {
	@Id
	@GeneratedValue
	private Integer tipo_operacion_id;
	private String nombre;
	
	
	public Integer getTipo_operacion_id() {
		return tipo_operacion_id;
	}
	public void setTipo_operacion_id(Integer tipo_operacion_id) {
		this.tipo_operacion_id = tipo_operacion_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
