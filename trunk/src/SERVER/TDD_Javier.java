package SERVER;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import BUSINESS.CajaController;
import BUSINESS.ComprasController;
import BUSINESS.PedidosController;
import BUSINESS.RestauranteController;
import BUSINESS.StockController;
import Exceptions.RestaurantException;

public class TDD_Javier {

	public static void main(String[] args) throws RestaurantException {
		
		
		//unitTestRegistrarReclamo();
		//unitTestControlarStock();
		//unitTestPrepararComanda();
		//unitTestRecepcionMercaderia();
		//unitTestLiquidarComisiones();
		unitTestControlarMovimientoDeStock();
	}
	

	/******** CASO DE USO 06 - REGISTRAR RECLAMO ************/
	
	private static void unitTestRegistrarReclamo() throws RestaurantException {
	
		//tengo la mesa, busco el pedido
		Integer idMesa = 3; 
		List<DTO.Reclamo> losItemsParaReclamos = PedidosController.getInstancia().obtenerItemsParaReclamo(idMesa);
		
		//vuelve la lista con los items marcados. Simulo la carga
		losItemsParaReclamos.get(0).setCantidadNoFacturar(1);
		losItemsParaReclamos.get(0).setObservaciones("Un desastre todo");
		
		//llamo al controller desde la interfaz y le digo que efectivamente lo persista (obviamente a traves del DAO que corresponda)
		PedidosController.getInstancia().registrarReclamo(losItemsParaReclamos);
		
	}
	

	/******** CASO DE USO 10 - CONTROLAR STOCK ************/
	
	private static void unitTestControlarStock() throws RestaurantException {
		
		//Tengo la sucursal donde voy a controlar el Stock, debo imprimir por pantalla el stock que posee el deposito
		List<DTO.Stock> stockSucursalDTO = StockController.getInstancia().getStockPorDeposito(1);
		
		//Recibo DTOs. Los listo simplemente para ver que los datos vienen bien.
		for(DTO.Stock unStock : stockSucursalDTO){
			System.out.println("En la sucursal 1 hay " + unStock.getCantidad() + " " + unStock.getNombreProducto() + " que vence el dia " + unStock.getFecha_vencimiento_producto_dt());
		}
		
	}
	
	
	/******** CASO DE USO 08 - PREPARAR COMANDA ************/
	
	private static void unitTestPrepararComanda() {
		
	
		// El Area ingresa a "Preparar Comanda", que busca los pedidos que esten pendientes de preparacion
		// Es decir que tengo la sucursal y el area (area 1, sucursal 1)
		List<DTO.Item_Pedido> losItemsPedidoPendientesDTO = PedidosController.getInstancia().getItemPedidosPendientesDTO(1,1);
		
		//vuelve la lista con los items marcados. Simulo la carga
		losItemsPedidoPendientesDTO.get(0).setItem_id(2);
		losItemsPedidoPendientesDTO.get(0).setEstado_id(2);
		losItemsPedidoPendientesDTO.get(0).setEstado_name("Entregado");
		
		//llamo al controller desde la interfaz y le digo que efectivamente lo persista (obviamente a traves del DAO que corresponda)
		PedidosController.getInstancia().marcarItemPedidoPreparado(losItemsPedidoPendientesDTO);
		
	}
	
		
	/******** CASO DE USO 27 - RECEPCION DE MERCADERIA ************/
	
	private static void unitTestRecepcionMercaderia() throws RestaurantException {
		
		//tengo un montón de datos sobre productos nuevos, la fecha actual y la cantidad
		//simulo esos datos
		DTO.RecepcionCompra laRecepcion = new DTO.RecepcionCompra();
		Date laFecha = RestauranteController.getInstancia().getDate(2014, 07, 01, 10, 00);
		laRecepcion.setRecepcion_fecha_dt(laFecha);
		List<DTO.Item_Recepcion_Compra> losItems = new ArrayList<DTO.Item_Recepcion_Compra>();
		
		DTO.Item_Recepcion_Compra elItemRecepcion1 = new DTO.Item_Recepcion_Compra();
		elItemRecepcion1.setItem_Id_Producto(1);
		elItemRecepcion1.setCant(1);
		elItemRecepcion1.setItem_recepcion_id(1);
				
		losItems.add(elItemRecepcion1);
			
		laRecepcion.setItems(losItems);
		
		ComprasController.getInstancia().setRecepcionCompra(laRecepcion);
						
	}

		
	/******** CASO DE USO 15 - LIQUIDAR COMISIONES ************/
	
	private static void unitTestLiquidarComisiones() throws RestaurantException {
		
		//Tengo el dia del que quiero liquidar las comisiones y la sucursal
		Date diaLiquidado = RestauranteController.getInstancia().getDate(2014, 05, 29, 00, 00);
		CajaController.getInstancia().liquidarComisionesMozos(diaLiquidado, 1);

	}
	
			
	/******** CASO DE USO 13 - CONTROLAR MOVIMIENTOS DE STOCK ****************/ 
	
	private static void unitTestControlarMovimientoDeStock() throws RestaurantException {
		//Tengo la sucursal donde voy a controlar los movimientos de Stock, que debo imprimir por pantalla
		List<DTO.Movimiento_Stock> movimientosStockSucursalDTO = StockController.getInstancia().getMovimientosDeStockPorDeposito(1);
		
		//Recibo DTOs. Los listo simplemente para ver que los datos vienen bien.
		for(DTO.Movimiento_Stock unMovimiento : movimientosStockSucursalDTO){
			System.out.println("En la sucursal 1 se movieron " + unMovimiento.getCantidad() + " de " + unMovimiento.getProductoName() +  
								" " + " desde el deposito " + unMovimiento.getDeposito_origenId() + 
								" hacia el deposito " + unMovimiento.getDeposito_destinoId());
		}
	
		
	}
	
	
}
