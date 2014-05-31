package ENTITY;

import javax.persistence.*;


@Entity
@Table(name="PAGOS_FACTURA")

public class Pago_Factura {

	@Id
	private Integer pago_id;
	
	@ManyToOne
	@JoinColumn(name="pago_factura_id")
	private Factura factura;
	
	@OneToOne
	@JoinColumn(name="PAGO_MEDIO_PAGO_ID")
	private Medio_Pago pago_medio_pago_id;
	
	private Float monto_total;
	
	public Pago_Factura() {
		super();
	}
	
	public Integer getPago_id() {
		return pago_id;
	}
	public void setPago_id(Integer pago_id) {
		this.pago_id = pago_id;
	}
	public Factura getPago_factura() {
		return factura;
	}
	public void setPago_factura(Factura pago_factura) {
		this.factura = pago_factura;
	}
	public Medio_Pago getMedio_pago() {
		return pago_medio_pago_id;
	}
	public void setMedio_pago(Medio_Pago medio_pago) {
		this.pago_medio_pago_id = medio_pago;
	}
	public Float getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Float monto_total) {
		this.monto_total = monto_total;
	}
	
}
