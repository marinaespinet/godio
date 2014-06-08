	package SERVER;

	import java.sql.Date;
import java.util.*;

	import BUSINESS.*;
import DAO.*;
import DTO.Plato;
import ENTITY.*;
import Exceptions.RestaurantException;
	
public class TDD_Marina {

		public static void main(String[] args) throws RestaurantException {
			
			//CU03 Solicitar factura 
			//FacturasController.getInstancia().solicitarFactura(1);
			
			//CU04 Crear Factura
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(2));
			
			//CU10 Agregar Plato al pedido
			/*DTO.Plato pl = new DTO.Plato();
			pl.setPlato_id(1);
			pl.setName("Arroz con leche");
			PedidosController.getInstancia().agregarPlatoAlPedido(pl, 1, 1, 1);*/
			
			
			//CU11 CU14 Abrir Caja/Cerrar Caja
			//CajaController.getInstancia().crearOperacionCaja(2, 2);
			Integer tc = (Integer)1;
			Float monto=(float) 5;
			//Operacion_Caja op = OperacionCajaDAO.getInstancia().getOperacion(12);
			//System.out.println("Encontre operacion "+op.getOperacion_caja_id());
			//DTO.Operacion_Caja ope = CajaController.getInstancia().getDTOFromEntity(op);
			DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja(monto, 3, tc,12);
			CajaController.getInstancia().agregarItemsCaja(item,12);
			System.out.println("Id operacion: "+item.getItem_operacion_operacion_id());
			

			
			
			//unitTestPedidos();
			//unitTestUnPedido();
			//unitTestListarItemsPedido();
			//unitTestListarPedidoPorEstado();
			//unitTestPedidoAbiertoDeMesa();
		//	FacturasController.getInstancia().solicitarFactura(1);
			//unitTestCalcularMonto();
			//unitTestVerificarPedidoPendiente();
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(2));
			//System.out.println("Hoy es "+ new java.sql.Date(System.currentTimeMillis()));
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
		
	/*private static boolean unitTestListarItemsPedido() {
			
			System.out.print("TEST: Listar items de un pedido");
			List<Item_Pedido> items = PedidosDAO.getInstancia().getItems(2);
			if(items!=null){
					for(Item_Pedido unItem : items)
			//			System.out.println("Encontré un item. Descripcion: " + unItem.getItem_carta().getItem_carta_id().getName() + " cantidad: " + unItem.getCantidad());
					return true;
				} else{
					System.out.println("Mal :(");
					return false;}
	}*/

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





