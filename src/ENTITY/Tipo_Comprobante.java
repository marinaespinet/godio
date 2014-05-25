package ENTITY;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Tipos_Comprobantes")
public class Tipo_Comprobante {
@Id
@GeneratedValue
	private Integer tipo_comprobante_id;

@Column(name="name")
	private String nombre;
	
	
	public Integer getTipo_comprobante_id() {
		return tipo_comprobante_id;
	}
	public void setTipo_comprobante_id(Integer tipo_comprobante_id) {
		this.tipo_comprobante_id = tipo_comprobante_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
