package ENTITY;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="SEMIELABORADOS")
@PrimaryKeyJoinColumn(name="semielaborado_id")
public class Semielaborado extends Producto{
	
	@Column(insertable=false, updatable=false)
	private Integer semielaborado_id;
	private Float horas_elaboracion_cant;
	
	@OneToMany @JoinColumn(name="INSUMOS_SEMIELABORADO_SEMIELABORADO_ID")
	private List<Insumo_Semielaborado> insumos;
	
	
	public Integer getSemielaborado_id() {
		return semielaborado_id;
	}
	public void setSemielaborado_id(Integer semielaborado_id) {
		this.semielaborado_id = semielaborado_id;
	}
	public Float getHoras_elaboracion_cant() {
		return horas_elaboracion_cant;
	}
	public void setHoras_elaboracion_cant(Float horas_elaboracion_cant) {
		this.horas_elaboracion_cant = horas_elaboracion_cant;
	}
	
	public List<Insumo_Semielaborado> getInsumos() {
		return insumos;
	}
	public void setInsumos(List<Insumo_Semielaborado> insumos) {
		this.insumos = insumos;
	}
	
	
}
