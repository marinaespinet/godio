package ENTITY;

//import java.sql.Date;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="RESERVAS")


public class Reserva {
	@Id
	@GeneratedValue

	private Integer reserva_id;
	
	@ManyToOne
	@JoinColumn(name="RESERVA_SUCURSAL_ID")
	private Sucursal sucursal;
	@Column(name="fecha_dt")
	private Date fecha;
	private Integer cant_comensales;
	private Integer minutos_duracion;
	
	
	public Integer getReserva_id() {
		return reserva_id;
	}
	public void setReserva_id(Integer reserva_id) {
		this.reserva_id = reserva_id;
	}
	public Sucursal getReserva_mesa() {
		return sucursal;
	}
	public void setReserva_mesa(Sucursal reserva_mesa) {
		this.sucursal = reserva_mesa;
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
	
	
}
