package BUSINESS;

import java.util.*;
import java.sql.Date;

import DAO.*;
import ENTITY.Factura;
import ENTITY.Item_Factura;
import ENTITY.Mesa;


public class FacturasController {
	
	private static FacturasController instancia = null;

	public static FacturasController getInstancia(){
		if(instancia == null){			
			instancia = new FacturasController();
		} 
		return instancia;
	}
	
	public void solicitarFactura(Integer numeroDeMesa){
		ENTITY.Pedido pedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(numeroDeMesa);
		if(pedido!=null){
			Long pendientes=verificarItemsPendientes(pedido.getPedido_id());
			if (pendientes==0){
					System.out.println("No hay items pendientes de entrega, se solicitará la factura");
					pedido.modificarPedidoEstado(EstadosDAO.getInstancia().buscarEstadoPedido("Cerrado"));
					PedidosDAO.getInstancia().grabarPedidoActualizado(pedido);
					pedido.getPedido_mesa().setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa(4));
					LocationDAO.getInstancia().grabarMesaActualizada(pedido.getPedido_mesa());
					crearFactura(pedido);
			}
			else
				System.out.println("Hay " + pendientes + " items pendientes de entrega");
		}
		else
			System.out.println("No se encontró un pedido abierto para la mesa: " + numeroDeMesa);
	}	

	private Long verificarItemsPendientes(Integer pedido_id) {
		return(PedidosDAO.getInstancia().verificarItemsPendientesDelPedido(pedido_id));
		
	}

	public void crearFactura(ENTITY.Pedido pedido) {
		Factura factura=new Factura();
		llenarDatosDelPedido(factura, pedido);
		Double monto=calcularMontoFactura(pedido);
		factura.setMonto_total(monto);
		FacturasDAO.getInstancia().grabarFactura(factura);
		System.out.println("Se ha creado la factura nro: " + factura.getFactura_id() + " con un monto total de: $" + factura.getMonto_total());
		agregarItems(factura,pedido);
	}

private void llenarDatosDelPedido(Factura factura, ENTITY.Pedido pedido) {
	Date hoy = new java.sql.Date(System.currentTimeMillis());
	factura.setFecha_factura_dt(hoy);
	factura.setFactura_mesa(pedido);
	factura.setFactura_mozo(pedido.getPedido_mozo());
		
}

private void agregarItems(Factura factura, ENTITY.Pedido pedido) {
	List<ENTITY.Item_Pedido> itemsPed = PedidosDAO.getInstancia().getItems(pedido.getPedido_id());//pedido.listarItems();
	for(ENTITY.Item_Pedido unItem: itemsPed){
		Item_Factura it = new Item_Factura();
		it.setItem_pedido(unItem);
		it.setItem_plato(unItem.getItem_carta().getPlato());
		it.setCant_plato(unItem.getCantidad());
		it.setFactura(factura);
		FacturasDAO.getInstancia().addItemsFactura(it);	
		}
}	

public Double calcularMontoFactura(ENTITY.Pedido pedido) {
	Double monto = PedidosDAO.getInstancia().calcularMonto(pedido.getPedido_id());
	return monto;
}

public Float montoPagos(Integer facturaID){
	return (FacturasDAO.getInstancia().getMontoPagos(facturaID)).floatValue();
}


}