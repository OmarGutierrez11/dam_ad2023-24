package com.miapp.dao;

import com.miapp.modelo.ModalidadesAfiliacion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ModalidadesAfiliacionDAOImpl implements ModalidadesAfiliacionDAO {
   SessionFactory sessionFactory;

    public ModalidadesAfiliacionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addModalidad(ModalidadesAfiliacion modalidadesAfiliacion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(modalidadesAfiliacion);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public ModalidadesAfiliacion getModalidad(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        ModalidadesAfiliacion modalidadesAfiliacion = null;
        try{
            transaction = session.beginTransaction();
           modalidadesAfiliacion = (ModalidadesAfiliacion) session.get(ModalidadesAfiliacionDAO.class, id);
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return modalidadesAfiliacion;
    }

    @Override
    public List<ModalidadesAfiliacion> listaModalidades() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<ModalidadesAfiliacion> listaModalidades;
        try {
            transaction = session.beginTransaction();
            listaModalidades = session.createQuery("from ModalidadesAfiliacion").list();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return listaModalidades;
    }

    @Override
    public void updateModalidad(ModalidadesAfiliacion modalidadesAfiliacion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(modalidadesAfiliacion);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteModalidad(ModalidadesAfiliacion modalidadesAfiliacion) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(modalidadesAfiliacion);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }
}
