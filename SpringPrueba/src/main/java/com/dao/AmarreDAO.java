package com.dao;

import com.interfaces.InterfaceAmarre;
import com.modelo.Amarre;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AmarreDAO implements InterfaceAmarre {

    @Override
    public Amarre findById(Long id) {
        // Abre una sesión de Hibernate y obtén el amarre porsu ID
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Amarre.class, id);
        }
    }
    @Override
    public List<Amarre> findAll() {
        // Abre una sesión de Hibernate y obtén todos los amarres
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Amarre",
                    Amarre.class).getResultList();
        }
    }
    @Override
    public Amarre save(Amarre amarre) {
        // Abre una sesión de Hibernate y guarda el amarre en la base de datos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction =
                    session.beginTransaction();
            session.save(amarre);
            transaction.commit();
            return amarre;
        }
    }
    @Override
    public Amarre update(Amarre amarre) {
        // Abre una sesión de Hibernate y actualiza el amarre en la base de datos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction =
                    session.beginTransaction();
            session.update(amarre);
            transaction.commit();
            return amarre;
        }
    }
    @Override
    public void delete(Amarre amarre) {
        // Abre una sesión de Hibernate y elimina el amarre de la base de datos
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction =
                    session.beginTransaction();
            session.delete(amarre);
            transaction.commit();
        }
    }
}
