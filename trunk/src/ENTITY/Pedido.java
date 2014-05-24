package ENTITY;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="PEDIDOS_MESAS")


public class Pedido {
	
	@Id
	private Integer pedido_id;
	
	@ManyToOne
	@JoinColumn(name="mesa_id")
	private Mesa pedido_mesa;
	
	@ManyToOne
	@JoinColumn(name="mozo_id")
	private Mozo pedido_mozo;
	
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado_Pedido pedido_estado;
	
	@OneToOne
	@JoinColumn(name="login_id")
	private Login pedido_login;
	
	private Integer cant_comensales;
	private Date fecha_apertura_dt;
	private Date fecha_pago_dt;
	private Date fecha_cierre_dt;
	
	@OneToMany
	@JoinColumn(name="item_pedido_id")
	private List<Item_Pedido>items;
	
	public Pedido() {
		super();
	}
	
	/*
	public Pedido(Mesa mesa, Mozo mozo, Integer cantComensales,
			Vector<Item_Pedido> items) {
		super();
		this.pedido_mesa = mesa;
		this.pedido_mozo = mozo;
		this.cant_comensales = cantComensales;
		this.items = items;
	}*/
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
	public Estado_Pedido getPedidoEstado() {
		return pedido_estado;
	}
	public void modificarPedidoEstado(Estado_Pedido estado) {
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
	public List<Item_Pedido>listarItems() {
		return items;
	}
	public void setItems(List<Item_Pedido> items) {
		this.items = items;
	}

	
}
