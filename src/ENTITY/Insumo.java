package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Insumos")
@PrimaryKeyJoinColumn(name="insumo_id")
public class Insumo extends Producto {
	
	@Column(insertable=false, updatable=false)
	private Integer insumo_id;
	
	private Float precio_compra;
	private Date fecha_vencimiento;
	@ManyToOne @JoinColumn(name="ESTADO_ID")
	private Estado_Insumo estado;
	private Boolean puede_compra_ind;
	
	@OneToOne @JoinColumn(name="INSUMO_ID")
	private Stock stock;
	
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
	public Estado_Insumo getEstado() {
		return estado;
	}
	public void setEstado(Estado_Insumo estado) {
		this.estado = estado;
	}
	public Boolean getPuede_compra_ind() {
		return puede_compra_ind;
	}
	public void setPuede_compra_ind(Boolean puede_compra_ind) {
		this.puede_compra_ind = puede_compra_ind;
	}
	
	
	
}
