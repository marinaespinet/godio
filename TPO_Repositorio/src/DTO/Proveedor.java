package DTO;

import java.io.Serializable;

public class Proveedor  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer proveedor_id;
	private String name;
	
	
	public Integer getProveedor_id() {
		return proveedor_id;
	}
	public void setProveedor_id(Integer proveedor_id) {
		this.proveedor_id = proveedor_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
