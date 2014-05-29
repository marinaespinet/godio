package ENTITY;

import javax.persistence.*;


@Entity
@Table(name="ITEMS_PLAN_PRODUCCION")
public class Item_Plan_Produccion {
	@Id
	@GeneratedValue

	private Integer item_plan_id;
	@ManyToOne
	@JoinColumn(name="ITEM_PLAN_SEMIELABORADO_ID")
	private Semielaborado item_plan_semielaborado;
	
	private Integer cantidad;
	@ManyToOne
	@JoinColumn(name="ITEM_PLAN_SUCURSAL_ID")
	private Sucursal item_plan_sucursal;
	
	private Integer item_plan_avance_qty;
	
	@ManyToOne
	@JoinColumn(name="item_plan_plan_id")
	private Plan_Produccion item_plan_plan_id;
	
	public Integer getItem_plan_id() {
		return item_plan_id;
	}
	public void setItem_plan_id(Integer item_plan_id) {
		this.item_plan_id = item_plan_id;
	}
	public Semielaborado getSemielaborado() {
		return item_plan_semielaborado;
	}
	public void setSemielaborado(Semielaborado item_plan_semielaborado) {
		this.item_plan_semielaborado = item_plan_semielaborado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Sucursal getSucursal() {
		return item_plan_sucursal;
	}
	public void setSucursal(Sucursal item_plan_sucursal) {
		this.item_plan_sucursal = item_plan_sucursal;
	}
	public Integer getItem_plan_avance_qty() {
		return item_plan_avance_qty;
	}
	public void setAvance(Integer cantidad) {
		this.item_plan_avance_qty = cantidad;
	}
	
	public Integer verificarAvanceTareas(){
		//TODO
		return 0;
	}
	public Plan_Produccion getPlan() {
		return item_plan_plan_id;
	}
	public void setPlan(Plan_Produccion item_plan_plan_id) {
		this.item_plan_plan_id = item_plan_plan_id;
	}
	
}
