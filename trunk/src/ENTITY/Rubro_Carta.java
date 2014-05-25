package ENTITY;

import javax.persistence.*;

@Entity @Table(name="RUBROS_CARTA")

public class Rubro_Carta {
	@Id
	@GeneratedValue
	private Integer Rubro_id;
	private String name;
			
	public Integer getRubro_id() {
		return Rubro_id;
	}
	public void setRubro_id(Integer Rubro_id) {
		this.Rubro_id = Rubro_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
