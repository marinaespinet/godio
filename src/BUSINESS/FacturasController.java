package BUSINESS;

import java.util.*;
import java.sql.Date;

import DAO.*;
import ENTITY.Factura;
import ENTITY.Item_Factura;
import ENTITY.Mesa;
import Exceptions.RestaurantException;


public class FacturasController {
	
	private static FacturasController instancia = null;

	public static FacturasController getInstancia(){
		if(instancia == null){			
			instancia = new FacturasController();
		} 
		return instancia;
	}
	
	public void solicitarFactura(Integer numeroDeMesa) throws RestaurantException{
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
			else throw new RestaurantException("Hay " + pendientes + " items pendientes de entrega");
		}
		else throw new RestaurantException("No se encontró un pedido abierto para la mesa: " + numeroDeMesa);
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
	List<ENTITY.Item_Pedido> itemsPed = PedidosDAO.getInstancia().getItems(pedido.getPedido_id());
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

public DTO.Factura getFacturaDTO(Factura facEnt,List<Object[]> items) {
	DTO.Factura facDTO = new DTO.Factura();
	facDTO.setFactura_id(facEnt.getFactura_id());
	facDTO.setFecha_factura_dt(facEnt.getFecha_factura_dt());
	facDTO.setMonto_total(facEnt.getMonto_total());
	facDTO.setMesa_cd(facEnt.getFactura_mesa().getPedido_mesa().getMesa_cd());
	facDTO.setMozo_nombre(facEnt.getFactura_mozo().getName());
	ArrayList<DTO.Item_Factura> itemsDTO = getItemsDTO(items);
	facDTO.setItems(itemsDTO);
	return facDTO;
}

private ArrayList<DTO.Item_Factura> getItemsDTO(List<Object[]> items) {
	ArrayList<DTO.Item_Factura> itemsDTO = new ArrayList<DTO.Item_Factura>();
	for (Object[] i:items){
		DTO.Item_Factura itemDTO= new DTO.Item_Factura();
		itemDTO.setPlato(i[0].toString());
		itemDTO.setCant_plato((Integer)i[1]);
		Float importeItem = (Float)((Integer)i[1]*(Float)i[2]);
		if((boolean)i[3]==true)
			importeItem=importeItem*0;
		itemDTO.setImporte(importeItem);
		itemsDTO.add(itemDTO);
	}
	return itemsDTO;
}


}