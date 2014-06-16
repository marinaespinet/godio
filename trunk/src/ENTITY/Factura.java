package ENTITY;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import BUSINESS.ProductosController;
import DAO.CartasDAO;
import DAO.EstadosDAO;
import DAO.FacturasDAO;
import DAO.PedidosDAO;
import DTO.Item_Pedido;
import DTO.Plato;

@Entity
@Table(name="Facturas")


public class Factura {

	@Id
	@GeneratedValue

	private Integer factura_id;
	
	private Date fecha_factura_dt;
	
	@ManyToOne
	@JoinColumn(name="FACTURA_MESA_ID")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="FACTURA_MOZO_ID")
	private Mozo factura_mozo;
	
	private Double monto_total;
	
	@OneToMany
	@JoinColumn(name="item_factura_id")
	private List<Item_Factura>items;

	@OneToMany()
	@JoinColumn(name="pago_factura_id")
	private List<Pago_Factura> pagos;
	
	public Integer getFactura_id() {
		return factura_id;
	}
	public void setFactura_id(Integer factura_id) {
		this.factura_id = factura_id;
	}
	public Date getFecha_factura_dt() {
		return fecha_factura_dt;
	}
	public void setFecha_factura_dt(java.util.Date fecha) {
		this.fecha_factura_dt = (Date) fecha;
	}
	public Pedido getFactura_mesa() {
		return pedido;
	}
	public void setFactura_mesa(Pedido factura_mesa) {
		this.pedido = factura_mesa;
	}
	public Mozo getFactura_mozo() {
		return factura_mozo;
	}
	public void setFactura_mozo(Mozo factura_mozo) {
		this.factura_mozo = factura_mozo;
	}
	public Double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Double monto) {
		this.monto_total = monto;
	}
	public List<Item_Factura> getItems() {
		return items;
	}
	public void setItems(List<Item_Factura> items) {
		this.items = items;
	}
	public List<Pago_Factura>  getPago_factura() {
		return pagos;
	}
	public void setPago_factura(List<Pago_Factura>  pago_factura) {
		this.pagos = pago_factura;
	}

	
}
	


