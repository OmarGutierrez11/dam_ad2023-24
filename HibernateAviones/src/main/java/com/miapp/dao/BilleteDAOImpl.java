package com.miapp.dao;

import com.miapp.modelo.Billete;
import com.miapp.modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BilleteDAOImpl implements  BilleteDAO{

    private SessionFactory sessionFactory;

    public BilleteDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public double calcularPrecioFinal() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Double precio;
        try {
            transaction = session.beginTransaction();
            Billete billete = new Billete();
            precio = billete.getPrecioFinal();

        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return precio;
    }

    @Override
    public void reasignarAsientosFamilia() {

    }

    @Override
    public void creaBillete() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Billete billete = new Billete();
        try {
            transaction = session.beginTransaction();

            session.save(billete);

        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }

    @Override
    public void addCliente(Cliente cliente) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.save(cliente);

        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
    }
}
