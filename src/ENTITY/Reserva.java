package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="")


public class Reserva {

	private Integer reserva_id;
	private Mesa reserva_mesa;
	private Date fecha;
	private Integer cant_comensales;
	private Integer minutos_duracion;
	
	
	public Integer getReserva_id() {
		return reserva_id;
	}
	public void setReserva_id(Integer reserva_id) {
		this.reserva_id = reserva_id;
	}
	public Mesa getReserva_mesa() {
		return reserva_mesa;
	}
	public void setReserva_mesa(Mesa reserva_mesa) {
		this.reserva_mesa = reserva_mesa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getCant_comensales() {
		return cant_comensales;
	}
	public void setCant_comensales(Integer cant_comensales) {
		this.cant_comensales = cant_comensales;
	}
	public Integer getMinutos_duracion() {
		return minutos_duracion;
	}
	public void setMinutos_duracion(Integer minutos_duracion) {
		this.minutos_duracion = minutos_duracion;
	}
	
	public Boolean buscarReservas(Date fecha, Integer cantComensales){
		
		//TODO
		return null;
		
	}
	
	
}
