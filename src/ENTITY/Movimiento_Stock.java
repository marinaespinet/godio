package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Movimientos_Stock")
public class Movimiento_Stock {
	@Id
	@GeneratedValue
	private	Integer movimiento_id;
	
	@ManyToOne
	@JoinColumn(name="DEPOSITO_ORIGEN_ID")
	private Deposito deposito_origen;
	
	@ManyToOne
	@JoinColumn(name="DEPOSITO_DESTINO_ID")
	private Deposito deposito_destino;
	
	@Column(insertable=false)
	private Date fecha_movimiento_dt;
	private String motivo_desc;
	
	@OneToOne
	@JoinColumn(name="LOGIN_ID")
	private Login login_id;
	
	@ManyToOne
	@JoinColumn(name="PRODUCTO_ID")
	private Producto producto;
	
	private Integer cantidad;
	private String lote;

	
	private Date fecha_compra_producto_dt;
	private Date fecha_vencim_producto_dt;
	
	
	public Integer getMovimiento_id() {
		return movimiento_id;
	}
	public void setMovimiento_id(Integer movimiento_id) {
		this.movimiento_id = movimiento_id;
	}
	public Deposito getDeposito_origen() {
		return deposito_origen;
	}
	public void setDeposito_origen(Deposito deposito_origen) {
		this.deposito_origen = deposito_origen;
	}
	public Deposito getDeposito_destino() {
		return deposito_destino;
	}
	public void setDeposito_destino(Deposito deposito_destino) {
		this.deposito_destino = deposito_destino;
	}
	public Date getFecha_movimiento_dt() {
		return fecha_movimiento_dt;
	}
	public void setFecha_movimiento_dt(Date fecha_movimiento_dt) {
		this.fecha_movimiento_dt = fecha_movimiento_dt;
	}
	public String getMotivo_desc() {
		return motivo_desc;
	}
	public void setMotivo_desc(String motivo_desc) {
		this.motivo_desc = motivo_desc;
	}
	public Login getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Login login_id) {
		this.login_id = login_id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getFecha_compra_producto_dt() {
		return fecha_compra_producto_dt;
	}
	public void setFecha_compra_producto_dt(Date fecha_compra_producto_dt) {
		this.fecha_compra_producto_dt = fecha_compra_producto_dt;
	}
	public Date getFecha_vencim_producto_dt() {
		return fecha_vencim_producto_dt;
	}
	public void setFecha_vencim_producto_dt(Date fecha_vencim_producto_dt) {
		this.fecha_vencim_producto_dt = fecha_vencim_producto_dt;
	}	
	
}
