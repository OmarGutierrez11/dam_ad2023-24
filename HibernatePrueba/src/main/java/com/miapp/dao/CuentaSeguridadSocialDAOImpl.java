package com.miapp.dao;

import com.miapp.modelo.CuentaSeguridadSocial;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CuentaSeguridadSocialDAOImpl implements  CuentaSeguridadDAO{

    SessionFactory sessionFactory;

    public CuentaSeguridadSocialDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCuenta(CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(cuentaSeguridadSocialDAO);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public List<CuentaSeguridadSocialDAOImpl> lista() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<CuentaSeguridadSocialDAOImpl> listaCuentas;
        try {
            transaction = session.beginTransaction();
            listaCuentas = session.createQuery("from CuentaSeguridadSocial").list();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return listaCuentas;
    }

    @Override
    public CuentaSeguridadSocialDAOImpl getCuenta(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO = null;
        try{
            transaction = session.beginTransaction();
            session.get(CuentaSeguridadSocial.class, id);
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return cuentaSeguridadSocialDAO;
    }

    @Override
    public void deleteCuenta(CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(cuentaSeguridadSocialDAO);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public void updateCuenta(CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(cuentaSeguridadSocialDAO);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }
}
