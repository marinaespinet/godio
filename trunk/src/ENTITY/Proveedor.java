package ENTITY;

import javax.persistence.*;


@Entity
@Table(name="PROVEEDORES")
public class Proveedor {
	@Id
	@GeneratedValue

	private Integer proveedor_id;
	@Column(name="PROVEEDOR_NAME")
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
