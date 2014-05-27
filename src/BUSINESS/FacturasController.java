package BUSINESS;

import java.util.*;

import DAO.*;
import ENTITY.*;
import ENTITY.Pedido;
import DTO.*;

public class FacturasController {
	
	private static FacturasController instancia = null;

	public static FacturasController getInstancia(){
		if(instancia == null){			
			instancia = new FacturasController();
		} 
		return instancia;
	}
	
	public boolean solicitarFactura(Integer numeroDeMesa){
		Pedido pedido = PedidosDAO.getInstancia().getPedidoAbiertoDeMesa(numeroDeMesa);
		if(pedido!=null){
			boolean flag = PedidosDAO.getInstancia().verificarItemsPendientesDeMesa(pedido.getPedido_id());
			if (flag==true){
					System.out.println("No hay items pendientes, podes pedir la factura");
					pedido.modificarPedidoEstado(EstadosDAO.getInstancia().buscarEstadoPedido("Cerrado"));
					pedido.getPedido_mesa().setMesa_estado(EstadosDAO.getInstancia().buscarEstadoMesa("ProximaLiberarse"));
					crearFactura(pedido);
			}
			return flag;
		}
		else 
			return false;
		}

	private Factura crearFactura(Pedido pedido) {
		Factura factura=new Factura();
		return factura;
		//TODO
	}



}
