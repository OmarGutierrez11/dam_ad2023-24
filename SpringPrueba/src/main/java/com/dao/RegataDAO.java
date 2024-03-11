package com.dao;



import com.interfaces.InterfaceRegata;
import com.modelo.Regata;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RegataDAO implements InterfaceRegata {


    @Override
    public Regata findById(Long id) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Regata.class, id);
        }
    }

    @Override
    public List<Regata> findAll() {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Regata",
                    Regata.class).getResultList();
        }
    }

    @Override
    public Regata save(Regata regata) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(regata);
            transaction.commit();
            return regata;
        }
    }

    @Override
    public Regata update(Regata regata) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(regata);
            transaction.commit();
            return regata;
        }
    }

    @Override
    public void delete(Regata regata) {
        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(regata);
            transaction.commit();
        }
    }
}
