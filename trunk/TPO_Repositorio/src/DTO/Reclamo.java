package DTO;

import java.io.Serializable;

public class Reclamo implements Serializable {

	private String platoNombre;
	private Integer cantidadNoFacturar = 0;
	private String observaciones;
	private Integer idItemPedido;
	
	public String getPlatoNombre() {
		return platoNombre;
	}
	public void setPlatoNombre(String platoNombre) {
		this.platoNombre = platoNombre;
	}
	public Integer getCantidadNoFacturar() {
		return cantidadNoFacturar;
	}
	public void setCantidadNoFacturar(Integer cantidadNoFacturar) {
		this.cantidadNoFacturar = cantidadNoFacturar;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	
	
	
}
