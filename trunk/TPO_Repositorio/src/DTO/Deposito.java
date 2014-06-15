package DTO;

import java.io.Serializable;

public class Deposito  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer deposito_id;
	private Area deposito_area;
	
	public Integer getDeposito_id() {
		return deposito_id;
	}
	public void setDeposito_id(Integer deposito_id) {
		this.deposito_id = deposito_id;
	}
	public Area getDeposito_area() {
		return deposito_area;
	}
	public void setDeposito_area(Area deposito_area) {
		this.deposito_area = deposito_area;
	}
	
	
	
}
