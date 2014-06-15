package DTO;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Vector;


public class Factura  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer factura_id;
	private Date fecha_factura_dt;
	private Mesa factura_mesa;
	private Mozo factura_mozo;
	private Double monto_total;
	private List<Item_Factura>items;
	
	
	
	public Factura(Date fecha, Mesa mesa, Mozo mozo,
			List<Item_Factura> items) {
		super();
		this.fecha_factura_dt = fecha;
		this.factura_mesa = mesa;
		this.factura_mozo = mozo;
		this.items = items;
	}
	
	public Factura() {
		super();
	}

	public Integer getFactura_id() {
		return factura_id;
	}
	public void setFactura_id(Integer factura_id) {
		this.factura_id = factura_id;
	}
	public Date getFecha_factura_dt() {
		return fecha_factura_dt;
	}
	public void setFecha_factura_dt(Date fecha_factura_dt) {
		this.fecha_factura_dt = fecha_factura_dt;
	}
	public Mesa getFactura_mesa() {
		return factura_mesa;
	}
	public void setFactura_mesa(Mesa mesa) {
		this.factura_mesa = mesa;
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
	public void setMonto_total(Double monto_total) {
		this.monto_total = monto_total;
	}
	public List<Item_Factura> getItems() {
		return items;
	}
	public void setItems(List<Item_Factura> list) {
		this.items = list;
	}
	
}
