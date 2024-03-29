package DTO;
import java.io.Serializable;
import java.sql.Date;


public class Insumo extends Producto  implements Serializable {
	private static final long serialVersionUID = 1L;
	


	private Integer insumo_id;
	private Float precio_compra;
	private Date fecha_vencimiento;
	private String estado;
	private Boolean puede_compra_ind;
	
	public Insumo(String n, Integer id) {
		super(n, id);
		// TODO Auto-generated constructor stub
	}
	
	public Insumo() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Integer getInsumo_id() {
		return insumo_id;
	}
	public void setInsumo_id(Integer insumo_id) {
		this.insumo_id = insumo_id;
	}
	public Float getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(Float precio_compra) {
		this.precio_compra = precio_compra;
	}
	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}
	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Boolean getPuede_compra_ind() {
		return puede_compra_ind;
	}
	public void setPuede_compra_ind(Boolean puede_compra_ind) {
		this.puede_compra_ind = puede_compra_ind;
	}
	
	
	
}
