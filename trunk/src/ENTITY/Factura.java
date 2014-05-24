package ENTITY;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Facturas")


public class Factura {

	@Id
	@GeneratedValue

	private Integer factura_id;
	
	private Date fecha_factura_dt;
	
	@ManyToOne
	@JoinColumn(name="mesa_id")
	private Mesa factura_mesa;
	
	@ManyToOne
	@JoinColumn(name="mozo_id")
	private Mozo factura_mozo;
	
	private Float monto_total;
	
	@OneToMany
	@JoinColumn(name="item_factura_id")
	private List<Item_Factura>items;
	
	
	
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
	public void setFactura_mesa(Mesa factura_mesa) {
		this.factura_mesa = factura_mesa;
	}
	public Mozo getFactura_mozo() {
		return factura_mozo;
	}
	public void setFactura_mozo(Mozo factura_mozo) {
		this.factura_mozo = factura_mozo;
	}
	public Float getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Float monto_total) {
		this.monto_total = monto_total;
	}
	public List<Item_Factura> getItems() {
		return items;
	}
	public void setItems(List<Item_Factura> items) {
		this.items = items;
	}
	

}
