package DTO;

public class Pago_Factura {

	private Integer pago_id;
	private Factura pago_factura;
	private Medio_Pago medio_pago;
	private Float monto_total;
	
	
	public Integer getPago_id() {
		return pago_id;
	}
	public void setPago_id(Integer pago_id) {
		this.pago_id = pago_id;
	}
	public Factura getPago_factura() {
		return pago_factura;
	}
	public void setPago_factura(Factura pago_factura) {
		this.pago_factura = pago_factura;
	}
	public Medio_Pago getMedio_pago() {
		return medio_pago;
	}
	public void setMedio_pago(Medio_Pago medio_pago) {
		this.medio_pago = medio_pago;
	}
	public Float getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Float monto_total) {
		this.monto_total = monto_total;
	}
	
	public Boolean verificarPagoFactura(Factura factura){
		//TODO
		return true;
	}
	
}
