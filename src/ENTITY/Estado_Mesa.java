package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="ESTADOS_MESAS")

public class Estado_Mesa {
	
	@Id
	private Integer estado_id;
	private String estado_name;
	
	
	public Integer getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}

	public String getEstado_name() {
		return estado_name;
	}

	public void setEstado_name(String estado_name) {
		this.estado_name = estado_name;
	}
	
	

}
