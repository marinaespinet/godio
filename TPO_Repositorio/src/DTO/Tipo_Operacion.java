package DTO;

import java.io.Serializable;

public class Tipo_Operacion implements Serializable {
	private static final long serialVersionUID = 1L;
	

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
