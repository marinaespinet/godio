package DTO;

import java.io.Serializable;

public class Sector  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private int sector_id;
	private String name;
	private Sucursal sector_sucursal;
	
	
	public int getSector_id() {
		return sector_id;
	}
	public void setSector_id(int sector_id) {
		this.sector_id = sector_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sucursal getSector_sucursal() {
		return sector_sucursal;
	}
	public void setSector_sucursal(Sucursal sector_sucursal) {
		this.sector_sucursal = sector_sucursal;
	}
	
	
	
}
