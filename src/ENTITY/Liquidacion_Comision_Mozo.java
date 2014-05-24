package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="LIQUIDACIONES_COMISIONES_MOZOS")
public class Liquidacion_Comision_Mozo {

	private Integer comision_id;
	private Date fecha_registracion_dt;
	private Date fecha_liquidacion_dt;
	private Mozo comision_mozo;
	private Float importe_amount;
	
	
	public Integer getComision_id() {
		return comision_id;
	}
	public void setComision_id(Integer comision_id) {
		this.comision_id = comision_id;
	}
	public Date getFecha_registracion_dt() {
		return fecha_registracion_dt;
	}
	public void setFecha_registracion_dt(Date fecha_registracion_dt) {
		this.fecha_registracion_dt = fecha_registracion_dt;
	}
	public Date getFecha_liquidacion_dt() {
		return fecha_liquidacion_dt;
	}
	public void setFecha_liquidacion_dt(Date fecha_liquidacion_dt) {
		this.fecha_liquidacion_dt = fecha_liquidacion_dt;
	}
	public Mozo getComision_mozo() {
		return comision_mozo;
	}
	public void setComision_mozo(Mozo comision_mozo) {
		this.comision_mozo = comision_mozo;
	}
	public Float getImporte_amount() {
		return importe_amount;
	}
	public void setImporte_amount(Float importe_amount) {
		this.importe_amount = importe_amount;
	}
	
	
	
}
