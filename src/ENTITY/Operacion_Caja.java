package ENTITY;

import java.sql.Date;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name="OPERACIONES_CAJA")


public class Operacion_Caja {

	@Id
	@Column(name="cierre_id")
	private Integer operacion_caja_id;
	
	@Column(name="fecha_cierre_dt")
	private Date fecha_dt;
	
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	private Sucursal cierre_sucursal_id;
	
	@OneToMany
	@JoinColumn(name="item_cierre_id")
	private Vector<Item_Operacion_Caja>items;
	
	private Float recaudacion;
	private Float comisiones;
	
	@OneToOne
	@JoinColumn(name="tipo_operacion_caja_id")
	private Tipo_Operacion tipo;	
	
	public Operacion_Caja() {
		super();
	}
	
	/*
	public Operacion_Caja(Sucursal sucursal,
			Vector<Item_Operacion_Caja> items, Tipo_Operacion tipo) {
		super();
		operacion_caja_sucursal = sucursal;
		this.items = items;
		this.tipo = tipo;
	}
	*/
	
	public Integer getOperacion_caja_id() {
		return operacion_caja_id;
	}
	public void setOperacion_caja_id(Integer operacion_caja_id) {
		this.operacion_caja_id = operacion_caja_id;
	}
	public Date getFecha_dt() {
		return fecha_dt;
	}
	public void setFecha_dt(Date fecha_dt) {
		this.fecha_dt = fecha_dt;
	}
	public Sucursal getOperacion_caja_sucursal() {
		return cierre_sucursal_id;
	}
	public void setOperacion_caja_sucursal(Sucursal operacion_caja_sucursal) {
		this.cierre_sucursal_id = operacion_caja_sucursal;
	}
	public Vector<Item_Operacion_Caja> getItems() {
		return items;
	}
	public void setItems(Vector<Item_Operacion_Caja> items) {
		this.items = items;
	}
	public Float getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(Float recaudacion) {
		this.recaudacion = recaudacion;
	}
	public Float getComisiones() {
		return comisiones;
	}
	public void setComisiones(Float comisiones) {
		this.comisiones = comisiones;
	}
	public Tipo_Operacion getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Operacion tipo) {
		this.tipo = tipo;
	}

}
