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
			
			testMostrarFactura(1);
			
			//CU03 Solicitar factura 
			//FacturasController.getInstancia().solicitarFactura(3);
			
			//CU04 Crear Factura
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(1));
			
			//CU10 Agregar Plato al pedido
			/*DTO.Plato pl = new DTO.Plato();
			pl.setPlato_id(1);
			pl.setName("Arroz con leche");
			PedidosController.getInstancia().agregarPlatoAlPedido(pl, 3, 1, 1);*/
			
			
			//CU11 CU14 Abrir Caja/Cerrar Caja
			Integer nroOperacion = CajaController.getInstancia().crearOperacionCaja(2, 3);
			
			Float monto=(float) 5;
			
			DTO.Item_Operacion_Caja item = new DTO.Item_Operacion_Caja();

			item.setCantidad(1);
			item.setMonto(monto);
			item.setTipo_comprobante(1);
			item.setItem_operacion_operacion_id(nroOperacion);
			
			CajaController.getInstancia().agregarItemsCaja(item,12);
			
			System.out.println("Id operacion: "+item.getItem_operacion_operacion_id());
			
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
			//	FacturasController.getInstancia().solicitarFactura(1);
			//unitTestCalcularMonto();
			//unitTestVerificarPedidoPendiente();
			//FacturasController.getInstancia().crearFactura(PedidosDAO.getInstancia().getPedido(2));
			//System.out.println("Hoy es "+ new java.sql.Date(System.currentTimeMillis()));
		}


		private static DTO.Factura testMostrarFactura(int nro) {
		DTO.Factura facDTO = new DTO.Factura();
		ENTITY.Factura facEnt = FacturasDAO.getInstancia().getFactura(nro);
		facDTO.setFecha_factura_dt(facEnt.getFecha_factura_dt());
		facDTO.setMonto_total(facEnt.getMonto_total());
		facDTO.setMesa_cd(facEnt.getFactura_mesa().getPedido_mesa().getMesa_cd());
		facDTO.setMozo_nombre(facEnt.getFactura_mozo().getName());
		List<Item_Factura> items = FacturasDAO.getInstancia().getItems(nro);
		ArrayList<DTO.Item_Factura> itemsDTO = new ArrayList<DTO.Item_Factura>();
		for (Item_Factura i:items){
			DTO.Item_Factura itemDTO= new DTO.Item_Factura();
			itemDTO.setPlato(i.getItem_plato().getName());
			itemDTO.setCant_plato(i.getCant_plato());
			Float importeItem = i.getCant_plato()*i.getItem_pedido().getItem_carta().getPrecio_monto();
			itemDTO.setImporte(importeItem);
			itemsDTO.add(itemDTO);
		}
		facDTO.setItems(itemsDTO);
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

	}





