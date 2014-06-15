package DTO;

import java.io.Serializable;

public class Tipo_Caducidad  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer tipo_caducidad_id;
	private String name;
	
	public Integer getTipo_caducidad_id() {
		return tipo_caducidad_id;
	}
	public void setTipo_caducidad_id(Integer tipo_caducidad_id) {
		this.tipo_caducidad_id = tipo_caducidad_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
