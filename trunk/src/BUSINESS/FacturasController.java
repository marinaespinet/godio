package BUSINESS;

import java.util.*;
import java.sql.Date;

import DAO.*;
import ENTITY.*;
import DTO.*;


public class FacturasController {
	
	private static FacturasController instancia = null;

	public static FacturasController getInstancia(){
		if(instancia == null){			
			instancia = new FacturasController();
		} 
		return instancia;
	}
	
	public void solicitarFactura(Integer numeroDeMesa){
		Pedido pedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(numeroDeMesa);
		if(pedido!=null){
			System.out.println("Tengo un pedido");
			Long pendientes=verificarItemsPendientes(pedido.getPedido_id());
			if (pendientes==0){
					System.out.println("No hay items pendientes, podes pedir la factura");
					pedido.modificarPedidoEstado(EstadosDAO.getInstancia().buscarEstadoPedido("Cerrado"));
					System.out.println("Pedido cerrado");
					pedido.getPedido_mesa().setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa("ProximaLiberarse"));
					System.out.println("Mesa proxima a liberarse");
					crearFactura(pedido);
			}
			else
				System.out.println("Hay " + pendientes + " items pendientes de entrega");
		}
		else
			System.out.println("No se encontró un pedido abierto para la mesa " + numeroDeMesa);
	}	

	private Long verificarItemsPendientes(Integer pedido_id) {
		return(PedidosDAO.getInstancia().verificarItemsPendientesDelPedido(pedido_id));
		
	}

	public void crearFactura(Pedido pedido) {
		System.out.println("Entré a crearFactura");
		Factura factura=new Factura();
		System.out.println("new Factura");
		llenarDatosDelPedido(factura, pedido);
		System.out.println("Llené los datos del pedido");
		Double monto=calcularMontoFactura(pedido);
		factura.setMonto_total(monto);
		System.out.println("Calculé monto de factura");
		FacturasDAO.getInstancia().grabarFactura(factura);
		System.out.println("Se ha creado la factura nro: " + factura.getFactura_id() + " con un monto total de: $" + factura.getMonto_total());
	}

private void llenarDatosDelPedido(Factura factura, Pedido pedido) {
	//Corregir esto con la clase Calendar
	factura.setFecha_factura_dt(PedidosDAO.getInstancia().getFechaAperturaSQL(pedido.getPedido_id()));
	factura.setFactura_mesa(pedido.getPedido_mesa());
	factura.setFactura_mozo(pedido.getPedido_mozo());
	System.out.println("llene los datos de factura");
	//agregarItems(factura,pedido);
	System.out.println("agregué los items");
	
}

private void agregarItems(Factura factura, Pedido pedido) {
	List<Item_Pedido> itemsPed = pedido.listarItems();
	for(Item_Pedido unItem: itemsPed){
		Item_Factura it = new Item_Factura();
		it.setItem_pedido(unItem);
		it.setItem_plato(unItem.getItem_carta().getPlato());
		it.setCant_plato(unItem.getCantidad());
		it.setFactura(factura);
		FacturasDAO.getInstancia().addItemsFactura(it);	
		}
}	

public Double calcularMontoFactura(Pedido pedido) {
	Double monto = PedidosDAO.getInstancia().calcularMonto(pedido.getPedido_id());
	return monto;
}

public DTO.Factura getFacturaDTO(Factura factura){
	DTO.Factura facturaDTO = new DTO.Factura();
	facturaDTO.setFactura_id(factura.getFactura_id());
	facturaDTO.setFactura_mesa(getMesaDTO(factura.getFactura_mesa()));
	facturaDTO.setFactura_mozo(factura.getFactura_mozo());
	facturaDTO.setFecha_factura_dt(factura.getFecha_factura_dt());
	facturaDTO.setItems(factura.getItems());
	facturaDTO.setMonto_total(factura.getMonto_total());
	return facturaDTO;
}

//Esto tendría que ir a LocationController
public DTO.Mesa getMesaDTO(Mesa mesa){
	DTO.Mesa mesaDTO = new DTO.Mesa();
	mesaDTO.setMesa_cd(mesa.getMesa_cd());
	mesaDTO.setMesa_id(mesa.getMesa_id());
	mesaDTO.setMax_cant_comensales(mesa.getMax_cant_comensales());
	mesaDTO.setMesa_estado(mesa.getMesa_estado());
	mesaDTO.setMesa_sector(mesa.getMesa_sector());
	mesaDTO.setMesa_sucursal(mesa.getMesa_sucursal());
	mesaDTO.setUnion_mesa(mesa.getUnion_mesa());
}



}