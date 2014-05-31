package DTO;

public class Item_Operacion_Caja {

	private Integer item_operacion_id;
	private Float monto;
	private Integer cantidad;
	private Tipo_Comprobante tipo_comprobante;
	private Operacion_Caja item_operacion_operacion_id;
	
	
	
	public Operacion_Caja getItem_operacion_operacion_id() {
		return item_operacion_operacion_id;
	}


	public void setItem_operacion_operacion_id(
			Operacion_Caja item_operacion_operacion_id) {
		this.item_operacion_operacion_id = item_operacion_operacion_id;
	}

	
	public Item_Operacion_Caja(Integer item_operacion_id, Float monto,
			Integer cantidad, Tipo_Comprobante tipo_comprobante,
			Operacion_Caja op) {
		super();
		this.item_operacion_id = item_operacion_id;
		this.monto = monto;
		this.cantidad = cantidad;
		this.tipo_comprobante = tipo_comprobante;
		this.item_operacion_operacion_id = op;
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
	public Tipo_Comprobante getTipo_comprobante() {
		return tipo_comprobante;
	}
	public void setTipo_comprobante(Tipo_Comprobante tipo_comprobante) {
		this.tipo_comprobante = tipo_comprobante;
	}
	
	
	
}
