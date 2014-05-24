package DTO;
import java.sql.Date;
import java.util.Vector;


public class Pedido {

	private Integer pedido_id;
	private Mesa pedido_mesa;
	private Mozo pedido_mozo;
	private String pedido_estado;
	private Login pedido_login;
	private Integer cant_comensales;
	private Date fecha_apertura_dt;
	private Date fecha_pago_dt;
	private Date fecha_cierre_dt;
	private Vector<Item_Pedido>items;
	
	
	public Pedido(Mesa mesa, Mozo mozo, Integer cantComensales,
			Vector<Item_Pedido> items) {
		super();
		this.pedido_mesa = mesa;
		this.pedido_mozo = mozo;
		this.cant_comensales = cantComensales;
		this.items = items;
	}
	public Integer getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(Integer pedido_id) {
		this.pedido_id = pedido_id;
	}
	public Mesa getPedido_mesa() {
		return pedido_mesa;
	}
	public void setPedido_mesa(Mesa pedido_mesa) {
		this.pedido_mesa = pedido_mesa;
	}
	public Mozo getPedido_mozo() {
		return pedido_mozo;
	}
	public void setPedido_mozo(Mozo pedido_mozo) {
		this.pedido_mozo = pedido_mozo;
	}
	public String getPedidoEstado() {
		return pedido_estado;
	}
	public void modificarPedidoEstado(String estado) {
		this.pedido_estado = estado;
	}
	public Login getPedido_login() {
		return pedido_login;
	}
	public void setPedido_login(Login pedido_login) {
		this.pedido_login = pedido_login;
	}
	public Integer getCant_comensales() {
		return cant_comensales;
	}
	public void setCant_comensales(Integer cant_comensales) {
		this.cant_comensales = cant_comensales;
	}
	public Date getFecha_apertura_dt() {
		return fecha_apertura_dt;
	}
	public void setFecha_apertura_dt(Date fecha_apertura_dt) {
		this.fecha_apertura_dt = fecha_apertura_dt;
	}
	public Date getFecha_pago_dt() {
		return fecha_pago_dt;
	}
	public void setFecha_pago_dt(Date fecha_pago_dt) {
		this.fecha_pago_dt = fecha_pago_dt;
	}
	public Date getFecha_cierre_dt() {
		return fecha_cierre_dt;
	}
	public void setFecha_cierre_dt(Date fecha_cierre_dt) {
		this.fecha_cierre_dt = fecha_cierre_dt;
	}
	public Vector<Item_Pedido>listarItems() {
		return items;
	}
	public void setItems(Vector<Item_Pedido> items) {
		this.items = items;
	}
	
	public void agregarItem(Item_Pedido item){
		//TODO
	}
	
}
