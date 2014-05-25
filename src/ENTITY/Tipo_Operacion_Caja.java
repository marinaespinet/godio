package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="Tipos_Operaciones_Caja")


public class Tipo_Operacion_Caja {
	@Id
	@GeneratedValue
	private Integer tipo_operacion_caja_id;
	private String nombre;
	
	
	public Integer tipo_operacion_caja_id() {
		return tipo_operacion_caja_id;
	}
	public void setTipo_operacion_id(Integer tipo_operacion_id) {
		this.tipo_operacion_caja_id = tipo_operacion_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
