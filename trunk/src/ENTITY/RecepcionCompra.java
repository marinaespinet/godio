import java.sql.Date;
import java.util.Vector;


public class RecepcionCompra {

	private Integer recepcion_id;
	private Date recepcion_fecha_dt;
	private Compra recepcion_compra;
	private Vector<Item_Recepcion_Compra>items;
	
	
	
	public RecepcionCompra(Date fecha, Compra compra) {
		super();
		this.recepcion_fecha_dt = fecha;
		this.recepcion_compra = compra;
	}
	public Integer getRecepcion_id() {
		return recepcion_id;
	}
	public void setRecepcion_id(Integer recepcion_id) {
		this.recepcion_id = recepcion_id;
	}
	public Date getRecepcion_fecha_dt() {
		return recepcion_fecha_dt;
	}
	public void setRecepcion_fecha_dt(Date recepcion_fecha_dt) {
		this.recepcion_fecha_dt = recepcion_fecha_dt;
	}
	public Compra getRecepcion_compra() {
		return recepcion_compra;
	}
	public void setRecepcion_compra(Compra recepcion_compra) {
		this.recepcion_compra = recepcion_compra;
	}
	public Vector<Item_Recepcion_Compra> getItems() {
		return items;
	}
	public void setItems(Vector<Item_Recepcion_Compra> items) {
		this.items = items;
	}
	
	public void agregarItem(Item_Recepcion_Compra itemRecepcionCompra){
		//TODO
	}
	
}
