package DTO;

public class Item_Operacion_Caja {

	private Integer item_operacion_id;
	private Float monto;
	private Integer cantidad;
	private Integer tipo_comprobante;
	private Integer item_operacion_operacion_id;
	
	
	
	public Integer getItem_operacion_operacion_id() {
		return item_operacion_operacion_id;
	}


	public void setItem_operacion_operacion_id(
			Integer item_operacion_operacion_id) {
		this.item_operacion_operacion_id = item_operacion_operacion_id;
	}

	
	public Item_Operacion_Caja(Float monto,
			Integer cantidad, Integer tipo_comprobante, Integer operacion) {
		super();
		this.monto = monto;
		this.cantidad = cantidad;
		this.tipo_comprobante = tipo_comprobante;
		this.item_operacion_operacion_id = operacion;
	
	}


	public Integer getItem_operacion_id() {
		return item_operacion_id;
	}
	public void setItem_operacion_id(Integer item_operacion_id) {
		this.item_operacion_id = item_operacion_id;
	}
	public Float getMonto() {
		return monto;
	}
	public void setMonto(Float monto) {
		this.monto = monto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getTipo_comprobante() {
		return tipo_comprobante;
	}
	public void setTipo_comprobante(Integer tipo_comprobante) {
		this.tipo_comprobante = tipo_comprobante;
	}
	
	
	
}
