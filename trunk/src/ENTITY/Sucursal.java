package ENTITY;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="SUCURSALES")
public class Sucursal {
@Id
@GeneratedValue
	private Integer sucursal_id;
	private String name;
	private Integer cant_max_mesas;
	private Integer cant_max_cubiertos;
	private Integer cant_max_hs_produccion_cocina;
	private Boolean es_admin_central_ind;
	
	@OneToMany
	private List<Reserva> reservas;

	  @ManyToMany
	    @JoinTable(name="AREAS_SUCURSALES", joinColumns = {@JoinColumn(name="SUCURSALES_SUCURSAL_ID")}, 
	                        inverseJoinColumns = @JoinColumn(name = "AREAS_AREA_ID"))
	private List<Area> areas;
	
	public List<Area> getAreas() {
		return areas;
	}
	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	public Integer getSucursal_id() {
		return sucursal_id;
	}
	public void setSucursal_id(Integer sucursal_id) {
		this.sucursal_id = sucursal_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCant_max_mesas() {
		return cant_max_mesas;
	}
	public void setCant_max_mesas(Integer cant_max_mesas) {
		this.cant_max_mesas = cant_max_mesas;
	}
	public Integer getCant_max_cubiertos() {
		return cant_max_cubiertos;
	}
	public void setCant_max_cubiertos(Integer cant_max_cubiertos) {
		this.cant_max_cubiertos = cant_max_cubiertos;
	}
	public Integer getCant_max_hs_produccion_cocina() {
		return cant_max_hs_produccion_cocina;
	}
	public void setCant_max_hs_produccion_cocina(
			Integer cant_max_hs_produccion_cocina) {
		this.cant_max_hs_produccion_cocina = cant_max_hs_produccion_cocina;
	}
	public Boolean getEs_admin_central_ind() {
		return es_admin_central_ind;
	}
	public void setEs_admin_central_ind(Boolean es_admin_central_ind) {
		this.es_admin_central_ind = es_admin_central_ind;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}
