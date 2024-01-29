package com.miapp.dao;

import com.miapp.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDAOImpl implements  UsuarioDAO{

    private SessionFactory sesionFactory;

    public UsuarioDAOImpl(SessionFactory sesionFactory) {
        this.sesionFactory = sesionFactory;
    }

    @Override
    public void addUsuario(Usuario usuario) {

        Session session = sesionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        }catch (RuntimeException e){
            if(transaction != null) transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }




    }

    @Override
    public Usuario getusuarioByID(Long id) {
        Session session = sesionFactory.openSession();
        Transaction transaction = null;
        Usuario usu = null;
        try {
            transaction = session.beginTransaction();
            usu = (Usuario) session.get(Usuario.class, id);
            transaction.commit();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return usu;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        Session session = sesionFactory.openSession();
        Transaction transaction = null;
        List<Usuario> listaUsuarios = null;
        try {
            transaction = session.beginTransaction();
            listaUsuarios = session.createQuery("from Usuario").list();
        }catch (RuntimeException e){
            throw e;
        }finally {
            session.close();
        }
        return listaUsuarios;
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        Session session = sesionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        }catch (RuntimeException e){
            if(transaction != null) transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        Session session = sesionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();
        }catch (RuntimeException e){
            if(transaction != null) transaction.rollback();
            throw  e;
        }finally {
            session.close();
        }
    }
}
