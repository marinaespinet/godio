package DTO;

import java.io.Serializable;

public class Insumo_Semielaborado  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer insumo_semielaborado_id;
	private Insumo insumo;
	private Float cantidad;
	
	public Integer getInsumo_semielaborado_id() {
		return insumo_semielaborado_id;
	}
	public void setInsumo_semielaborado_id(Integer insumo_semielaborado_id) {
		this.insumo_semielaborado_id = insumo_semielaborado_id;
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
