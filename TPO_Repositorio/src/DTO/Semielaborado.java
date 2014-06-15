package DTO;
import java.io.Serializable;
import java.util.Vector;


public class Semielaborado extends Producto  implements Serializable {
	private static final long serialVersionUID = 1L;
	


	private Integer semielaborado_id;
	private Float horas_elaboracion_cant;
	private String nombres;
	private Vector<Insumo_Semielaborado>insumos;
	
	
		public Semielaborado(String n, Integer id) {
		super(n, id);
		// TODO Auto-generated constructor stub
	}
	
	public Integer getSemielaborado_id() {
		return semielaborado_id;
	}
	public void setSemielaborado_id(Integer semielaborado_id) {
		this.semielaborado_id = semielaborado_id;
	}
	public Float getHoras_elaboracion_cant() {
		return horas_elaboracion_cant;
	}
	public void setHoras_elaboracion_cant(Float horas_elaboracion_cant) {
		this.horas_elaboracion_cant = horas_elaboracion_cant;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Vector<Insumo_Semielaborado> getInsumos() {
		return insumos;
	}
	public void setInsumos(Vector<Insumo_Semielaborado> insumos) {
		this.insumos = insumos;
	}
	
	
}
