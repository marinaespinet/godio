
public class Mozo {

	private Integer mozo_id;
	private String name;
	private Sector mozo_sector;
	private Float comision;
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
