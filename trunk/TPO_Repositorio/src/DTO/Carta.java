package DTO;
import java.io.Serializable;
import java.sql.Date;


public class Carta  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private Integer carta_id;
	private Date fecha_expiracion;
	
	
	public Integer getCarta_id() {
		return carta_id;
	}
	public void setCarta_id(Integer carta_id) {
		this.carta_id = carta_id;
	}
	public Date getFecha_expiracion() {
		return fecha_expiracion;
	}
	public void setFecha_expiracion(Date fecha_expiracion) {
		this.fecha_expiracion = fecha_expiracion;
	}
	
	
	
}
