package DTO;

import java.io.Serializable;

public class Medio_Pago  implements Serializable {
	private static final long serialVersionUID = 1L;
	

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
