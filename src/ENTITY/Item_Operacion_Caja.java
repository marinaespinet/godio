package ENTITY;


public class Item_Operacion_Caja {

	private Integer item_operacion_id;
	private Float monto;
	private Integer cantidad;
	private Tipo_Comprobante tipo_comprobante;
	
	
	
	
	public Item_Operacion_Caja(Float monto, Integer cantidad,
			Tipo_Comprobante tipo) {
		super();
		this.monto = monto;
		this.cantidad = cantidad;
		this.tipo_comprobante = tipo;
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
