package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="AREAS")

public class Area {
	@Id
	@GeneratedValue
	private Integer area_id;
	private String name;
			
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
