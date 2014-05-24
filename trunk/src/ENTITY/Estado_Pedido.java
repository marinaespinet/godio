package ENTITY;

import javax.persistence.*;

@Entity
@Table(name="ESTADOS_PEDIDOS")

public class Estado_Pedido {
	
	@Id
	private Integer estado_id;
	private String estado_name;
	
	public Estado_Pedido(){
		super();
	}

}
