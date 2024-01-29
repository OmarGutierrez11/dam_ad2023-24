package com.miapp.dao;

import com.miapp.modelo.Direccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DireccionDAOImpl implements  DireccionDAO {

    private SessionFactory sessionFactory;

    public DireccionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDireccion(Direccion direccion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(direccion);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public Direccion getDireccion(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Direccion direc = null;
        try{
            transaction = session.beginTransaction();
            session.get(Direccion.class, id);

        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return direc;
    }

    @Override
    public List<Direccion> listaDirecciones() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Direccion> listaDirecciones;
        try {
            transaction = session.beginTransaction();
            listaDirecciones = (List<Direccion>) session.createQuery("from Direccion").list();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return listaDirecciones;
    }

    @Override
    public void deleteDireccion(Direccion direccion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(direccion);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public void updateDireccion(Direccion direccion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(direccion);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }
}
