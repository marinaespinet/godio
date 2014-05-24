package ENTITY;

import javax.persistence.*;


@Entity
@Table(name="MEDIOS_PAGO")

public class Medio_Pago {

	@Id
	private Integer medio_pago_id;
	
	@Column(name="medio_pago_name")
	private String name;
	
	public Medio_Pago() {
		super();
	}
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
