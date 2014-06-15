package ENTITY;
import javax.persistence.*;

@Entity
@Table(name="Users")

public class Usuario {
	@Id
	@GeneratedValue
	private Integer user_id;
	private String user_name;
	
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
	
	
	
}
