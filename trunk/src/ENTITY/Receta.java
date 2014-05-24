import java.util.Vector;


public class Receta {

	private Integer receta_id;
	private Vector<Ingrediente> ingredientes;
	
	
	public Integer getReceta_id() {
		return receta_id;
	}
	public void setReceta_id(Integer receta_id) {
		this.receta_id = receta_id;
	}
	public Vector<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Vector<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public Integer verificarDisponibilidadReceta(){
		//TODO
		return 0;
	}
	
	public void modificarStockReceta(Integer cantidad){
		//TODO
	}
	
}
