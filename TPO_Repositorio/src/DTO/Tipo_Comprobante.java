package DTO;

import java.io.Serializable;

public class Tipo_Comprobante  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer tipo_comprobante_id;
	private String nombre;
	
	
	public Integer getTipo_comprobante_id() {
		return tipo_comprobante_id;
	}
	public void setTipo_comprobante_id(Integer tipo_comprobante_id) {
		this.tipo_comprobante_id = tipo_comprobante_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
