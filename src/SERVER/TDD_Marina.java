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
			testGetUsuario(1);
			//testMostrarFactura(3);		
			//CU03 Solicitar factura 
			//FacturasController.getInstancia().solicitarFactura(3);
			
			//CU04 Crear Factura
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(2));
			
			//CU10 Agregar Plato al pedido
			PedidosController.getInstancia().agregarPlatoAlPedido(1, 3, 1, 1);
			
			
			//CU11 CU14 Abrir Caja/Cerrar Caja
			/*Integer nroOperacion = CajaController.getInstancia().crearOperacionCaja(2, 3);
			Float monto=(float) 5;
			DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();
			item.setCantidad(1);
			item.setMonto(monto);
			item.setTipo_comprobante(1);
			item.setItem_operacion_operacion_id(nroOperacion);
			CajaController.getInstancia().agregarItemsCaja(item,12);
			System.out.println("Id operacion: "+item.getItem_operacion_operacion_id());*/
			
			//CU17 Registrar Avance de tareas plan de produccion
			//unitTestCU17();
			
			//CU18 Registrar Orden de Compra
			//unitTestCU18();
			
			//RestauranteController.getInstancia().abrirMesa(1, 9);
			
			
			
			//unitTestPedidos();
			//unitTestUnPedido();
			//unitTestListarItemsPedido();
			//unitTestListarPedidoPorEstado();
			//unitTestPedidoAbiertoDeMesa();
			//FacturasController.getInstancia().solicitarFactura(1);
			//unitTestCalcularMonto();
			//unitTestVerificarPedidoPendiente();
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(2));
			//System.out.println("Hoy es "+ new java.sql.Date(System.currentTimeMillis()));
		}

		private static DTO.Factura testMostrarFactura(int nro) {
			
		ENTITY.Factura facEnt = FacturasDAO.getInstancia().getFactura(nro);
		List<Object[]> items = FacturasDAO.getInstancia().getItems(nro);
		DTO.Factura facDTO = FacturasController.getInstancia().getFacturaDTO(facEnt,items);
		System.out.println("Nro de Factura: "+facDTO.getFactura_id()+" Fecha: "+facDTO.getFecha_factura_dt());
		System.out.println("Mesa: "+facDTO.getMesa_cd()+" Mozo: "+facDTO.getMozo_nombre());
		for(DTO.Item_Factura i:facDTO.getItems()){
			System.out.println("Plato: "+i.getPlato()+" - Cantidad: "+i.getCant_plato()+" - Importe: "+i.getImporte());
		}
		return facDTO;
		}



		private static void unitTestCU18() throws RestaurantException {
			System.out.println("TEST CU18 Registrar OC");
			ComprasController.getInstancia().crearOrdenDeCompra(1);
			Integer prod = (Integer)1;
			Integer cant = (Integer)10;
			Double precio = (Double) 15.0;
			DTO.Item_Compra item = new DTO.Item_Compra(prod, cant, precio);
			ComprasController.getInstancia().agregarItemsCompra(item,5);
			
		}


		private static void unitTestCU17() throws RestaurantException{
			ProduccionController.getInstancia().registrarAvancePlanProduccion(1, 3, 2);
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
	
	public static void testGetUsuario(int mozo){
	Usuario usr = LocationDAO.getInstancia().getMozoPorId(mozo).getMozo_user();
	System.out.println(usr.getUser_id());
	Login l = LoginDAO.getInstancia().getLoginActualDeMozo(usr);
	System.out.println(l.getLogin_id());
	System.out.println(l.getFecha_login_dt());
	}

	}





