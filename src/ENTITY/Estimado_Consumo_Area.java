package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="Estimados_Consumos_Areas")


public class Estimado_Consumo_Area {
	@Id
	@GeneratedValue

	private Integer estimado_consumo_id;
	
	@OneToOne
	@JoinColumn(name="ESTIMADO_CONSUMO_AREA_ID")
	private Area estimado_consumo_area;
	
	@OneToOne
	@JoinColumn(name="ESTIMADO_CONSUMO_PRODUCTO_ID")
	private Producto estimado_consumo_producto;
	
	private Integer cantidad;
	
	public Integer getEstimado_consumo_id() {
		return estimado_consumo_id;
	}
	public void setEstimado_consumo_id(Integer estimado_consumo_id) {
		this.estimado_consumo_id = estimado_consumo_id;
	}
	public Area getEstimado_consumo_area() {
		return estimado_consumo_area;
	}
	public void setEstimado_consumo_area(Area estimado_consumo_area) {
		this.estimado_consumo_area = estimado_consumo_area;
	}
	public Producto getEstimado_consumo_producto() {
		return estimado_consumo_producto;
	}
	public void setEstimado_consumo_producto(Producto estimado_consumo_producto) {
		this.estimado_consumo_producto = estimado_consumo_producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
