package SERVER;

import java.util.*;

import BUSINESS.*;
import DAO.*;
import ENTITY.*;

public class TDD_Marina {

	public static void main(String[] args) {

		//unitTestPedidos();
		//unitTestUnPedido();
		//unitTestListarItemsPedido();
		unitTestListarPedidoPorEstado();
	}


	private static boolean unitTestPedidos() {
		
		System.out.print("TEST: Listar todos los pedidos");
		List<Pedido> pedidos = PedidosDAO.getInstancia().getPedidos();
		if(pedidos!=null){
				for(Pedido unPedido : pedidos)
					System.out.println("Encontré un pedido con Id " + unPedido.getPedido_id() + " en estado " + unPedido.getPedidoEstado().getEstado_name());
				return true;
			} else{
				System.out.println("Mal :(");
				return false;}
	}
	
	private static boolean unitTestUnPedido() {
		
		System.out.print("TEST: Buscar un pedido por Id");
		Pedido pedido = PedidosDAO.getInstancia().getPedido(2);
		if(pedido!=null){
					System.out.println("Encontré un pedido con Id " + pedido.getPedido_id() + " en estado " + pedido.getPedidoEstado().getEstado_name());
				return true;
			} else{
				System.out.println("Mal :(");
				return false;}
	}
	
private static boolean unitTestListarItemsPedido() {
		
		System.out.print("TEST: Listar items de un pedido");
		List<Item_Pedido> items = PedidosDAO.getInstancia().getItems(2);
		if(items!=null){
				for(Item_Pedido unItem : items)
					System.out.println("Encontré un item. Descripcion: " + unItem.getItem_carta().getItem_plato().getName() + " cantidad: " + unItem.getCantidad());
				return true;
			} else{
				System.out.println("Mal :(");
				return false;}
}

private static boolean unitTestListarPedidoPorEstado() {
	
	System.out.print("TEST: Listar todos los pedidos en determinado estado");
	List<Pedido> pedidos = PedidosDAO.getInstancia().getPedidosPorEstado("Abierto");
	if(pedidos!=null){
			for(Pedido unPedido : pedidos)
				System.out.println("Encontré un pedido con Id " + unPedido.getPedido_id() + " en estado " + unPedido.getPedidoEstado().getEstado_name());
			return true;
		} else{
			System.out.println("Mal :(");
			return false;}
	}
}


