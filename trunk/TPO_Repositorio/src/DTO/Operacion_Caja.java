package DTO;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Vector;


public class Operacion_Caja  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer operacion_caja_id;
	private Date fecha_dt;
	private Sucursal operacion_caja_sucursal;
	private Vector<Item_Operacion_Caja>items;
	private Double recaudacion;
	private Double comisiones;
	private Tipo_Operacion tipo;
	
	
	
	public Operacion_Caja(Sucursal sucursal,
			Vector<Item_Operacion_Caja> items, Tipo_Operacion tipo) {
		super();
		operacion_caja_sucursal = sucursal;
		this.items = items;
		this.tipo = tipo;
	}
	public Operacion_Caja() {
	super();
	}
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
		return operacion_caja_sucursal;
	}
	public void setOperacion_caja_sucursal(Sucursal operacion_caja_sucursal) {
		this.operacion_caja_sucursal = operacion_caja_sucursal;
	}
	public List<Item_Operacion_Caja> getItems() {
		return items;
	}
	public void setItems(Vector<Item_Operacion_Caja> items) {
		this.items = items;
	}
	public Double getRecaudacion() {
		return recaudacion;
	}
	public void setRecaudacion(Double recaudacion) {
		this.recaudacion = recaudacion;
	}
	public Double getComisiones() {
		return comisiones;
	}
	public void setComisiones(Double comisiones) {
		this.comisiones = comisiones;
	}
	public Tipo_Operacion getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Operacion tipo) {
		this.tipo = tipo;
	}
	
	
}
