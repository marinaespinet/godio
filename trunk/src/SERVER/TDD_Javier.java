package SERVER;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import BUSINESS.PedidosController;
import BUSINESS.RestauranteController;
import BUSINESS.StockController;
import DAO.*;
import DTO.Item_Pedido;
import ENTITY.*;
import Exceptions.RestaurantException;

public class TDD_Javier {

	public static void main(String[] args) {
		
		
		//unitTestSucursales();
		//unitTestSucursalPorNombre();
		//unitTestSucursalPorId()
		//unitTestSucursalPorId();
		//unitTestAreas();
		//unitTestAreaPorNombre();
		//unitTestAreaPorId();
		//unitTestSectores();
		//unitTestSectorPorNombre();
		//unitTestSectorPorId();
		//unitTestMozos();
		//unitTestMozoPorNombre();
		//unitTestMozoPorId();
		//unitTestMesas();
		//unitTestMesaPorId();
		//unitTestReservas();
		//unitTestReservaPorId();
		//unitTestReservaPorFecha();
		//unitTestCrearReserva();
		
		//unitTestRegistrarReclamo();
		//unitTestControlarStock();
		unitTestPrepararComanda();
		
	}
	
	

	/******** CASO DE USO 06 - REGISTRAR RECLAMO 
	 * @throws RestaurantException ************/
	private static void unitTestRegistrarReclamo() throws RestaurantException {
		//tengo la mesa, busco el pedido
		Pedido elPedidoDelReclamoEntity = PedidosController.getInstancia().getPedidoActualEnMesa(3);
		
				
		//armo un DTO con los datos que necesito, itemPedidos y se lo mando a la interfaz
		DTO.Pedido elPedidoDelReclamoDTO = RestauranteController.getInstancia().getPedidoDTOReclamo(elPedidoDelReclamoEntity);

		
		// Lo listo simplemente para ver lo que ve el mozo en la interfaz y ver que haya algun item_pedido. Es un DTO que tiene unicamente
		// el Id del pedido, y los items del pedido. Esos items tambien son distintos a la Entity porque tienen id y un campo especial
		// que es "la descripcion rapida" de lo que contienen, para no traerme el item carta, los platos y recien ahi el nombre
		List<DTO.Item_Pedido> losItems = elPedidoDelReclamoDTO.listarItems();
		for(DTO.Item_Pedido elItemPedido : losItems){
			System.out.println("Item Nro " + elItemPedido.getItem_id() + ", plato " + elItemPedido.getDescripcionPlatoContenido());
		}
			
				
		//me llega un itemPedidoDTO que hay que persistir, lo creo para el ejemplo
		DTO.Item_Pedido elItemObservadoDTO = new DTO.Item_Pedido();
		elItemObservadoDTO.setItem_id(1);
		elItemObservadoDTO.setItem_no_facturar_ind(true);
		elItemObservadoDTO.setObservaciones_no_facturar("tenia un pucho apagado");
		
		//convierto el Item_Pedido DTO a Entity
		ENTITY.Item_Pedido elItemObservadoEnt = RestauranteController.getInstancia().getItemPedidoEntityFromDTOReclamo(elItemObservadoDTO);
		
		//lo persisto
		PedidosDAO.getInstancia().setItemPedido(elItemObservadoEnt);
	}

	

	/******** CASO DE USO 10 - CONTROLAR STOCK ************/
	private static void unitTestControlarStock() {
		
		//Tengo la sucursal donde voy a controlar el Stock, debo imprimir por pantalla el stock que posee el deposito
		List<Stock> stockSucursalEnt = StockController.getInstancia().getStockPorDeposito(1);
		
		//Tengo un listado de Entities, las paso a DTOs que me convengan
		List<DTO.Stock> stockSucursalDTO = StockController.getInstancia().getDTOFromEntityStockPorSucursal(stockSucursalEnt);
		
		//Los listo simplemente para ver que los datos vienen bien, pero deberia mandarlo directamente al cliente
		for(DTO.Stock unStock : stockSucursalDTO){
			System.out.println("En la sucursal 1 hay " + unStock.getCantidad() + " " + unStock.getNombreProducto() + " que vence el dia " + unStock.getFecha_vencimiento_producto_dt());
		}
		
		
	}
	
	
	/******** CASO DE USO 08 - PREPARAR COMANDA ************/
	private static void unitTestPrepararComanda() {
		// El Area ingresa a "Preparar Comanda", que busca los pedidos que esten pendientes de preparacion
		// Es decir que tengo la sucursal y el area (area 1, sucursal 1)
		List<ENTITY.Item_Pedido> losItemPedidosPendientesEnt = PedidosController.getInstancia().getItemPedidosPendientes(1,1);
		
		//Transformo las Entities en DTOs que sirvan para el Area y se los mando 
		List<DTO.Item_Pedido> losItemPedidoPendientesDTO = PedidosController.getInstancia().getDTOFromEntityItemsPedido(losItemPedidosPendientesEnt); 
		
		//Recibo un itemPedido que ya está listo, lo transformo en Entity. Ahora creo uno para simular
		DTO.Item_Pedido itemDTO = new DTO.Item_Pedido();
		itemDTO.setItem_id(1);
		itemDTO.setEstado_id(2);
		itemDTO.setEstado_name("Entregado");
		
		ENTITY.Item_Pedido elItemQueEstaListo = PedidosController.getInstancia().getItemPedidoEntityFromDTO(itemDTO);
		
		//lo persisto
		PedidosDAO.getInstancia().setItemPedido(elItemQueEstaListo);
		
	}
	
	/******** CASO DE USO 06 - RECEPCION DE MERCADERIA ************/
	
	private static boolean unitTestMesaPorId() {
	
		System.out.print("Test Mesa por Id: ");
		Mesa unaMesa = LocationDAO.getInstancia().getMesaPorId(1);
		if(unaMesa != null){
		System.out.println("La mesa con el Id 1 efectivamente existe y tiene una cantidad maxima de comensales de " + unaMesa.getMax_cant_comensales());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestMesas() {

		System.out.print("Test Mesas: ");
		List<Mesa> lasMesas = LocationDAO.getInstancia().getMesas();
		if(lasMesas != null){
			for(Mesa unaMesa : lasMesas)
				System.out.println("Encontré una mesa con el Id " + unaMesa.getMesa_id() + " para " + unaMesa.getMax_cant_comensales() + " comensales");
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static void unitTestCrearReserva() {
		
		Sucursal laSucursalDeLaReserva = LocationDAO.getInstancia().getSucursalPorId(1);
		
		Calendar unaFecha = Calendar.getInstance();
		unaFecha.set(Calendar.YEAR,1983);
		unaFecha.set(Calendar.MONTH,2);
		unaFecha.set(Calendar.DAY_OF_MONTH,20);
		unaFecha.set(Calendar.HOUR_OF_DAY, 21);
		unaFecha.set(Calendar.MINUTE, 0);
		
		Date laFecha = new java.sql.Date(unaFecha.getTimeInMillis());
		
		Reserva unaReserva = new Reserva();
		unaReserva.setCant_comensales(5);
		unaReserva.setFecha(laFecha);
		unaReserva.setMinutos_duracion(45);
		unaReserva.setReserva_mesa(laSucursalDeLaReserva);
		
		LocationDAO.getInstancia().setReserva(unaReserva);
	}

	private static boolean unitTestReservaPorFecha() {
		
		System.out.print("Test Reserva por fecha: ");
		Date unaFecha = new Date(25/05/2014);
		Reserva unaReserva = LocationDAO.getInstancia().getReservaPorFecha(unaFecha);
		if(unaReserva != null){
		System.out.println("La Reserva para el dia " + unaReserva.getFecha() + " efectivamente existe es para " + unaReserva.getCant_comensales() + " comensales");
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestReservaPorId() {
		
		System.out.print("Test Reserva por Id: ");
		Reserva unaReserva = LocationDAO.getInstancia().getReservaPorId(1);
		if(unaReserva != null){
		System.out.println("La reserva con el Id 1 efectivamente existe y es para el dia " + unaReserva.getFecha());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestReservas() {
		
		System.out.print("Test Reservas: ");
		List<Reserva> lasReservas = LocationDAO.getInstancia().getReservas();
		if(lasReservas != null){
			for(Reserva unaReserva : lasReservas)
				System.out.println("Encontré una reserva, el dia " + unaReserva.getFecha() + " para " + unaReserva.getCant_comensales() + " comensales");
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestMozoPorId() {

		System.out.print("Test Mozo por Id: ");
		Mozo unMozo = LocationDAO.getInstancia().getMozoPorId(1);
		if(unMozo != null){
		System.out.println("El Mozo 1 efectivamente existe y tiene el nombre " + unMozo.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestMozoPorNombre() {
		
		System.out.print("Test Mozo por nombre: ");
		Mozo unMozo = LocationDAO.getInstancia().getMozoPorNombre("Juan");
		if(unMozo != null){
		System.out.println("El mozo " + unMozo.getName() + " efectivamente existe y tiene el Id " + unMozo.getMozo_id());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestMozos() {
		
		System.out.print("Test Mozos: ");
		List<Mozo> losMozos = LocationDAO.getInstancia().getMozos();
		if(losMozos != null){
			for(Mozo unMozo : losMozos)
				System.out.println("Encontré un Mozo y se llama: " + unMozo.getName() + " que corresponde al username  " + unMozo.getMozo_user().getUser_name());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSectorPorId() {
		
		System.out.print("Test Sector por Id: ");
		Sector unSector = LocationDAO.getInstancia().getSectorPorId(33);
		if(unSector != null){
		System.out.println("El sector 33 efectivamente existe y tiene el nombre " + unSector.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSectorPorNombre() {
		
		System.out.print("Test Sector por nombre: ");
		Sector unSector = LocationDAO.getInstancia().getSectorPorNombre("Ventana1");
		if(unSector != null){
		System.out.println("El sector " + unSector.getName() + " efectivamente existe y tiene el Id " + unSector.getSector_id());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSectores() {
		
		System.out.print("Test Sectores: ");
		List<Sector> losSectores = LocationDAO.getInstancia().getSectores();
		if(losSectores != null){
			for(Sector unSector : losSectores)
				System.out.println("Encontré un sector y se llama: " + unSector.getName() + " que corresponde a la sucursal " + unSector.getSector_sucursal().getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestAreaPorId() {
		
		System.out.print("Test Area por Id: ");
		Area unArea = LocationDAO.getInstancia().getAreaPorId(1);
		if(unArea != null){
		System.out.println("El area con el Id 1 efectivamente existe y se llama " + unArea.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestAreaPorNombre() {

		System.out.print("Test Area por nombre: ");
		Area unArea = LocationDAO.getInstancia().getAreaPorNombre("Cocina");
		if(unArea != null){
		System.out.println("El area " + unArea.getName() + " efectivamente existe y tiene el Id " + unArea.getArea_id());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestAreas() {
		
		System.out.print("Test Areas: ");
		List<Area> lasAreas = LocationDAO.getInstancia().getAreas();
		if(lasAreas != null){
			for(Area unArea : lasAreas)
				System.out.println("Encontré un area y se llama: " + unArea.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSucursalPorId() {
		
		System.out.print("Test Sucursal por Id: ");
		Sucursal unaSucursal = LocationDAO.getInstancia().getSucursalPorId(4);
		if(unaSucursal != null){
		System.out.println("La sucursal Nro " + unaSucursal.getSucursal_id() + " efectivamente existe y se llama " + unaSucursal.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	private static boolean unitTestSucursalPorNombre() {
		
		System.out.print("Test Sucursal por nombre: ");
		Sucursal unaSucursal = LocationDAO.getInstancia().getSucursalPorNombre("Belgrano");
		if(unaSucursal != null){
		System.out.println("La sucursal " + unaSucursal.getName() + " efectivamente existe y tiene " + unaSucursal.getCant_max_mesas() + " mesas");
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}

	public static boolean unitTestSucursales(){
		
		System.out.print("Test Sucursales: ");
		List<Sucursal> lasSucursales = LocationDAO.getInstancia().getSucursales();
		if(lasSucursales != null){
			for(Sucursal laSuc : lasSucursales)
				System.out.println("Encontré una sucursal y se llama: " + laSuc.getName());
			return true;
		} else
			System.out.println(" MMMMAAAAAAL");
			return false;
		
	}
	
	
	


}
