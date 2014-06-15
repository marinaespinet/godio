package DTO;

import java.io.Serializable;

public class Area implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer area_id;
	private String name;	
	
	public Area(String n, Integer i){
		this.name = n;
		this.area_id = i;
	}
	
	public Area() {
		// TODO Auto-generated constructor stub
	}

	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
