package ENTITY;
import javax.persistence.*;


@Entity
@Table(name="Depositos")



public class Deposito {
	@Id
	@GeneratedValue

	private Integer deposito_id;
	
	@OneToOne
	@JoinColumn(name="DEPOSITO_AREA_ID")
	private Area deposito_area;
	
	public Integer getDeposito_id() {
		return deposito_id;
	}
	public void setDeposito_id(Integer deposito_id) {
		this.deposito_id = deposito_id;
	}
	public Area getDeposito_area() {
		return deposito_area;
	}
	public void setDeposito_area(Area deposito_area) {
		this.deposito_area = deposito_area;
	}
	
	
	
}
