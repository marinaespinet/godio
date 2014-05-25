package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="CARTAS")

public class Carta {
	@Id
	@GeneratedValue
	private Integer carta_id;
	
	@Column(name="fecha_expiracion_dt")
	private Date fecha_expiracion;
	
	@OneToMany
	@JoinColumn(name="item_carta_id")
	private List<Item_Carta> items;
	
	
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
