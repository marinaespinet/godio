package DTO;

import java.io.Serializable;

public class Rol  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer role_id;
	private String role_name;
	
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
	
}
