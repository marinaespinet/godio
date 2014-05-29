	package SERVER;

	import java.util.*;

	import BUSINESS.*;
	import DAO.*;
	import ENTITY.*;
	
public class TDD_M {

		public static void main(String[] args) {

			//unitTestPedidos();
			//unitTestUnPedido();
			//unitTestListarItemsPedido();
			//unitTestListarPedidoPorEstado();
			//unitTestPedidoAbiertoDeMesa();
			FacturasController.getInstancia().solicitarFactura(1);
			//unitTestCalcularMonto();
			//unitTestVerificarPedidoPendiente();
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(2));
		}


		private static void unitTestVerificarPedidoPendiente() {
			System.out.println("TEST Verificar pedidos pendientes");
			Long flag=PedidosDAO.getInstancia().verificarItemsPendientesDelPedido(1);
			if (flag==0)
					System.out.println("No hay pedidos pendientes");
			else
				System.out.println("Ojo! Hay pedidos pendientes");
		}


		private static void unitTestCalcularMonto() {
			System.out.print("TEST: Calcular monto de factura");
			Double resultado = FacturasDAO.getInstancia().calcularMonto(1);
			System.out.println("Monto: $"+ resultado);
			
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
						System.out.println("Encontré un item. Descripcion: " + unItem.getItem_carta().getPlato().getName() + " cantidad: " + unItem.getCantidad());
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

	private static boolean unitTestPedidoAbiertoDeMesa(){
		System.out.print("TEST: Buscar el pedido abierto de una mesa");
		Pedido pedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(1);
		if(pedido!=null){
					System.out.println("Pedido: " + pedido.getPedido_id() + " en estado " + pedido.getPedidoEstado().getEstado_name() + " Mesa: " + pedido.getPedido_mesa().getMesa_id());
				return true;
			} else{
				System.out.println("Mal :(");
				return false;}
	}

	}





