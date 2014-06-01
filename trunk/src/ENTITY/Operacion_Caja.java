package ENTITY;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="OPERACIONES_CAJA")


public class Operacion_Caja {

	@Id
	@GeneratedValue
	@Column(name="cierre_id")
	private Integer operacion_caja_id;
	
	@Column(name="fecha_cierre_dt")
	private Date fecha_dt;
	
	@ManyToOne
	@JoinColumn(name="CIERRE_SUCURSAL_ID")
	private Sucursal cierre_sucursal_id;
	
	@OneToMany
	@JoinColumn(name="item_cierre_cierre_id")
	private List<Item_Operacion_Caja> items;
	
	private Double recaudacion_monto;
	private Double comisiones_monto;
	
	@OneToOne
	@JoinColumn(name="tipo_operacion_caja_id")
	private Tipo_Operacion_Caja tipo;	
	
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
	public List<Item_Operacion_Caja> getItems() {
		return items;
	}
	public void setItems(List<Item_Operacion_Caja> items) {
		this.items = items;
	}
	public Double getRecaudacion() {
		return recaudacion_monto;
	}
	public void setRecaudacion(Double recaudacion) {
		this.recaudacion_monto = recaudacion;
	}
	public Double getComisiones() {
		return comisiones_monto;
	}
	public void setComisiones(Double monto) {
		this.comisiones_monto = monto;
	}
	public Tipo_Operacion_Caja getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Operacion_Caja tipo) {
		this.tipo = tipo;
	}

}
