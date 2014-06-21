package ENTITY;
import javax.persistence.*;

@Entity
@Table(name="Users")

public class Usuario {
	@Id
	@GeneratedValue
	private Integer user_id;
	private String user_name;
	private String user_password;
	
	@OneToOne
	@JoinColumn(name="user_area_id")
	private Area area; 
	
	@OneToOne
	@JoinColumn(name="user_sucursal_id")
	private Sucursal sucursal; 
	
	@ManyToOne()
	@JoinColumn(name="user_role_id")
	private Rol user_rol;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Rol getUser_rol() {
		return user_rol;
	}
	public void setUser_rol(Rol user_rol) {
		this.user_rol = user_rol;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
	
}
