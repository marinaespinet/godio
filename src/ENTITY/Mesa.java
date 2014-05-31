package ENTITY;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="MESAS")


public class Mesa {
	@Id
	@GeneratedValue

	private Integer mesa_id;
	private Integer mesa_cd;

	@ManyToOne @JoinColumn(name="mesa_sucursal_id")
	private Sucursal mesa_sucursal;
	
	@ManyToOne @JoinColumn(name="mesa_sector_id")
	private Sector mesa_sector;
	
	@ManyToOne @JoinColumn(name="MESA_ESTADO_ID")
	private Estado_Mesa mesa_estado;
	
	private Integer max_cant_comensales;
	
	
	private Integer union_mesa_id;
	
	
	public Integer getMesa_id() {
		return mesa_id;
	}
	public void setMesa_id(Integer mesa_id) {
		this.mesa_id = mesa_id;
	}
	public Integer getMesa_cd() {
		return mesa_cd;
	}
	public void setMesa_cd(Integer mesa_cd) {
		this.mesa_cd = mesa_cd;
	}
	public Sucursal getMesa_sucursal() {
		return mesa_sucursal;
	}
	public void setMesa_sucursal(Sucursal mesa_sucursal) {
		this.mesa_sucursal = mesa_sucursal;
	}
	public Sector getMesa_sector() {
		return mesa_sector;
	}
	public void setMesa_sector(Sector mesa_sector) {
		this.mesa_sector = mesa_sector;
	}
	public Estado_Mesa getMesa_estado() {
		return mesa_estado;
	}
	public void setMesa_estado(Estado_Mesa mesa_estado) {
		this.mesa_estado = mesa_estado;
	}
	public Integer getMax_cant_comensales() {
		return max_cant_comensales;
	}
	public void setMax_cant_comensales(Integer max_cant_comensales) {
		this.max_cant_comensales = max_cant_comensales;
	}
	public Integer getUnion_mesa_id() {
		return union_mesa_id;
	}
	public void setUnion_mesa_id(Integer union_mesa_id) {
		this.union_mesa_id = union_mesa_id;
	}

	
}
