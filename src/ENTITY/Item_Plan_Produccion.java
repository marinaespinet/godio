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
	public Semielaborado getItem_plan_semielaborado() {
		return item_plan_semielaborado;
	}
	public void setItem_plan_semielaborado(Semielaborado item_plan_semielaborado) {
		this.item_plan_semielaborado = item_plan_semielaborado;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Sucursal getItem_plan_sucursal() {
		return item_plan_sucursal;
	}
	public void setItem_plan_sucursal(Sucursal item_plan_sucursal) {
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
	
}
