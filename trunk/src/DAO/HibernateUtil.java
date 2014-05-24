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
        	 //TODO: EQUIPO - cada uno agregar sus clases aqui
        	 config.addAnnotatedClass(Rol.class);
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
