package DTO;

public class Item_Plan_Produccion {

	private Integer item_plan_id;
	private Semielaborado item_plan_semielaborado;
	private Integer cantidad;
	private Sucursal item_plan_sucursal;
	private Integer item_plan_avance_qty;
	private Integer plan_id;
	private Integer sucursalID;
	private Integer semielaboradoID;
	
	public Item_Plan_Produccion(Semielaborado semielaborado,
			Integer cantidad,Sucursal sucursal) {
		super();
		this.item_plan_semielaborado = semielaborado;
		this.cantidad = cantidad;
		this.item_plan_sucursal = sucursal;
	}
	
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


	
	public Integer getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}

	public Integer getSucursalID() {
		return sucursalID;
	}

	public void setSucursalID(Integer sucursalID) {
		this.sucursalID = sucursalID;
	}

	public Integer getSemielaboradoID() {
		return semielaboradoID;
	}

	public void setSemielaboradoID(Integer semielaboradoID) {
		this.semielaboradoID = semielaboradoID;
	}

	
	
}
