package ENTITY;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

@Entity
@Table(name="PLAN_PRODUCCION")
public class Plan_Produccion {
	@Id
	@GeneratedValue

	private Integer plan_id;
	@Column(insertable=false)
	private Date fecha_creacion_dt;
	private Date fecha_finalizacion_tareas;
	@OneToMany
	private List<Item_Plan_Produccion>items;
	
	
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public Date getFecha_creacion_dt() {
		return fecha_creacion_dt;
	}
	public void setFecha_creacion_dt(Date fecha_creacion_dt) {
		this.fecha_creacion_dt = fecha_creacion_dt;
	}
	public Date getFecha_finalizacion_tareas() {
		return fecha_finalizacion_tareas;
	}
	public void setFecha_finalizacion_tareas(Date fecha_finalizacion_tareas) {
		this.fecha_finalizacion_tareas = fecha_finalizacion_tareas;
	}
	public List<Item_Plan_Produccion> getItems() {
		return items;
	}
	public void setItems(List<Item_Plan_Produccion> items) {
		this.items = items;
	}
	
	
}
