package DTO;
import java.sql.Date;


public class Movimiento_Stock {

	private	Integer movimiento_id;
	private Deposito deposito_origen;
	private Deposito deposito_destino;
	private Date fecha_movimiento_dt;
	private String motivo_desc;
	private Login login_id;
	private Producto producto;
	private Integer cantidad;
	private String lote;
	private Usuario solicitante;
	private Date fecha_compra_producto_dt;
	private Date fecha_vencim_producto_dt;
	private String movimiento_estado;
	
	
	
	
	public Movimiento_Stock(Deposito origen,
			Deposito destino, String motivo, Producto producto,
			Integer cantidad, String lote, Usuario solicitante,
			Date compra, Date vencimiento) {
		super();
		deposito_origen = origen;
		deposito_destino = destino;
		motivo_desc = motivo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.lote = lote;
		this.solicitante = solicitante;
		fecha_compra_producto_dt = compra;
		fecha_vencim_producto_dt = vencimiento;
	}
	
	
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
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
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
	public String getMovimiento_estado() {
		return movimiento_estado;
	}
	public void setMovimiento_estado(String movimiento_estado) {
		this.movimiento_estado = movimiento_estado;
	}
	
	

	
}
