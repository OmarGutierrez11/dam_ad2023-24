package com.miapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    // Una variable estática que guarda la única instancia de SessionFactory.
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Método privado que construye la SessionFactory.
    private static SessionFactory buildSessionFactory() {
        try {
            // Crea la SessionFactory a partir de hibernate.cfg.xml.
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            return configuration.buildSessionFactory();

        } catch (Exception e) {
            // En caso de error durante la creación, se lanza una excepción.
            throw new ExceptionInInitializerError(e);
        }
    }
    // Método público estático que devuelve la única instancia de SessionFactory.
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    // Método público estático para cerrar la SessionFactory.
    public static void shutdown() {
        // Cierra los caches y las conexiones de la pool.
        getSessionFactory().close();
    }
}