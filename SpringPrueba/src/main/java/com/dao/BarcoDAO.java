package com.dao;

import com.interfaces.InterfaceBarco;
import com.modelo.Barco;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BarcoDAO implements InterfaceBarco {
    @Override
    public Barco findById(Long id) {
        // Abre una sesión de Hibernate y obtén el barco por su ID
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Barco.class, id);
        }
    }

    @Override
    public List<Barco> findAll() {
        // Abre una sesión de Hibernate y obtén todos los barcos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Barco",
                    Barco.class).getResultList();
        }
    }

    @Override
    public Barco save(Barco barco) {
        // Abre una sesión de Hibernate y guarda el barco en la base de datos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction =
                    session.beginTransaction();
            session.save(barco);
            transaction.commit();
            return barco;
        }
    }

    @Override
    public Barco update(Barco barco) {
        // Abre una sesión de Hibernate y actualiza el barco en la base de datos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction =
                    session.beginTransaction();
            session.update(barco);
            transaction.commit();
            return barco;
        }
    }

    @Override
    public void delete(Barco barco) {
        // Abre una sesión de Hibernate y elimina el barco de la base de datos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction =
                    session.beginTransaction();
            session.delete(barco);
            transaction.commit();
        }
    }
}
