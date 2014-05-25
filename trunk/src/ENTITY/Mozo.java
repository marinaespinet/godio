package ENTITY;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mozos")


public class Mozo {
	@Id
	@GeneratedValue

	private Integer mozo_id;
	private String name;
	@ManyToOne
	@JoinColumn(name="MOZO_SECTOR_ID")
	private Sector mozo_sector;
	private Float comision;
	@ManyToOne
	@JoinColumn(name="MOZO_USER_ID")
	private Usuario mozo_user;
	
	
	public int getMozo_id() {
		return mozo_id;
	}
	public void setMozo_id(int mozo_id) {
		this.mozo_id = mozo_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sector getMozo_sector() {
		return mozo_sector;
	}
	public void setMozo_sector(Sector mozo_sector) {
		this.mozo_sector = mozo_sector;
	}
	public Float getComision() {
		return comision;
	}
	public void setComision(Float comision) {
		this.comision = comision;
	}
	public Usuario getMozo_user() {
		return mozo_user;
	}
	public void setMozo_user(Usuario mozo_user) {
		this.mozo_user = mozo_user;
	}
	
	
}
