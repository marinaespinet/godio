package DTO;

public class Estimado_Consumo_Area {

	private Integer estimado_consumo_id;
	private Area estimado_consumo_area;
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
