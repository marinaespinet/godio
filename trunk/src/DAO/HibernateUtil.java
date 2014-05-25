package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import ENTITY.*;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
             config.addAnnotatedClass(Area.class);
        	 config.addAnnotatedClass(Carta.class);
        	 config.addAnnotatedClass(Compra.class);
        	 config.addAnnotatedClass(Deposito.class);
        	 config.addAnnotatedClass(Estado_Pedido.class);
        	 config.addAnnotatedClass(Estado_Insumo.class);
        	 config.addAnnotatedClass(Estimado_Consumo_Area.class);
        	 config.addAnnotatedClass(Factura.class);
        	 config.addAnnotatedClass(Ingrediente.class);
        	 config.addAnnotatedClass(Insumo_Semielaborado.class);
        	 config.addAnnotatedClass(Insumo.class);
        	 config.addAnnotatedClass(Item_Carta.class);
        	 config.addAnnotatedClass(Item_Compra.class);
        	 config.addAnnotatedClass(Item_Factura.class);
        	 config.addAnnotatedClass(Item_Operacion_Caja.class);
        	 config.addAnnotatedClass(Item_Pedido.class);
        	 config.addAnnotatedClass(Item_Plan_Produccion.class);
        	 config.addAnnotatedClass(Item_Recepcion_Compra.class);
        	 config.addAnnotatedClass(Liquidacion_Comision_Mozo.class);
        	 config.addAnnotatedClass(Login.class);
        	 config.addAnnotatedClass(Medio_Pago.class);
        	 config.addAnnotatedClass(Mesa.class);
        	 config.addAnnotatedClass(Movimiento_Stock.class);
        	 config.addAnnotatedClass(Mozo.class);
        	 config.addAnnotatedClass(Operacion_Caja.class);
        	 config.addAnnotatedClass(Pago_Factura.class);
        	 config.addAnnotatedClass(Pedido.class);
        	 config.addAnnotatedClass(Plan_Produccion.class);
        	 config.addAnnotatedClass(Plato.class);
        	 config.addAnnotatedClass(Producto.class);
        	 config.addAnnotatedClass(Proveedor.class);
        	 config.addAnnotatedClass(RecepcionCompra.class);        
        	 config.addAnnotatedClass(Reserva.class);
        	 config.addAnnotatedClass(Rol.class);
        	 config.addAnnotatedClass(Sector.class);
        	 config.addAnnotatedClass(Semielaborado.class);
        	 config.addAnnotatedClass(Stock.class);
        	 config.addAnnotatedClass(Sucursal.class);
        	 config.addAnnotatedClass(Tipo_Caducidad.class);
        	 config.addAnnotatedClass(Tipo_Comprobante.class);
        	 config.addAnnotatedClass(Tipo_Operacion.class);
        	 config.addAnnotatedClass(Usuario.class);

             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
