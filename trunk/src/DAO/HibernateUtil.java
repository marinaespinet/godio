package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entity.*;
 
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
//             config.addAnnotatedClass(UsuarioBean.class);
        	 config.addAnnotatedClass(UnidadEntity.class);
        	 config.addAnnotatedClass(IngredienteEntity.class);
        	 config.addAnnotatedClass(PlatoEntity.class);
        	 config.addAnnotatedClass(Item_IngredienteEntity.class);
        	 config.addAnnotatedClass(FacturaEntity.class);
        	 config.addAnnotatedClass(ItemFacturaEntity.class);
        	 config.addAnnotatedClass(RubroEntity.class);
        	 config.addAnnotatedClass(Cuenta.class);
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
