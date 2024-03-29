package ENTITY;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="LOGIN")
public class Login {

	@Id
	@GeneratedValue
	private Integer login_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")	
	private Usuario user;
	
	@Column(insertable=false)
	private Date fecha_login_dt;
	
	private Date fecha_logout_dt;
	
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Date getFecha_login_dt() {
		return fecha_login_dt;
	}
	public void setFecha_login_dt(Date fecha_login_dt) {
		this.fecha_login_dt = fecha_login_dt;
	}
	public Date getFecha_logout_dt() {
		return fecha_logout_dt;
	}
	public void setFecha_logout_dt(Date fecha_logout_dt) {
		this.fecha_logout_dt = fecha_logout_dt;
	}
	
	
	
	
}
