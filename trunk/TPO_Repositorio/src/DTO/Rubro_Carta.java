package DTO;

import java.io.Serializable;

public class Rubro_Carta  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer rubro_id;
	private String name;
	
	
	public Integer getrubro_id() {
		return rubro_id;
	}
	public void setrubro_id(Integer rubro_id) {
		this.rubro_id = rubro_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
