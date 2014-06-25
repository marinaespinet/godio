package DTO;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Factura  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer factura_id;
	private Date fecha_factura_dt;
	private Integer mesa_cd;
	private String mozo_nombre;
	private Double monto_total;
	private ArrayList<Item_Factura>items;
	
	
	
	public Factura(Date fecha, Integer mesa, String mozo,
			ArrayList<Item_Factura> items) {
		super();
		this.fecha_factura_dt = fecha;
		this.mesa_cd = mesa;
		this.mozo_nombre = mozo;
		//this.factura_mesa = mesa;
		//this.factura_mozo = mozo;
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
	/*public Mesa getFactura_mesa() {
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
	}*/
	public Double getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(Double monto_total) {
		this.monto_total = monto_total;
	}
	public List<Item_Factura> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item_Factura> list) {
		this.items = list;
	}

	public Integer getMesa_cd() {
		return mesa_cd;
	}

	public void setMesa_cd(Integer mesa_cd) {
		this.mesa_cd = mesa_cd;
	}

	public String getMozo_nombre() {
		return mozo_nombre;
	}

	public void setMozo_nombre(String mozo_nombre) {
		this.mozo_nombre = mozo_nombre;
	}
	
	
	
}
