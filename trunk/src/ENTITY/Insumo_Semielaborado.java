package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="Insumos_Semielaborados")


public class Insumo_Semielaborado {
	@Id
	@GeneratedValue
	private Integer insumos_semielaborado_id;
	
	@ManyToOne @JoinColumn(name="INSUMOS_SEMIELABORADO_INSUMO_ID")
	private Insumo insumo;
	@OneToOne @JoinColumn(name="INSUMOS_SEMIELABORADO_SEMIELABORADO_ID")
	private Semielaborado semielaborado;
	private Float cantidad;
	
	public Integer getInsumo_semielaborado_id() {
		return insumos_semielaborado_id;
	}
	public void setInsumo_semielaborado_id(Integer insumo_semielaborado_id) {
		this.insumos_semielaborado_id = insumo_semielaborado_id;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
