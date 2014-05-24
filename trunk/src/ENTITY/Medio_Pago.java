package ENTITY;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="")


public class Medio_Pago {

	private Integer medio_pago_id;
	private String name;
	
	
	public Integer getMedio_pago_id() {
		return medio_pago_id;
	}
	public void setMedio_pago_id(Integer medio_pago_id) {
		this.medio_pago_id = medio_pago_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
