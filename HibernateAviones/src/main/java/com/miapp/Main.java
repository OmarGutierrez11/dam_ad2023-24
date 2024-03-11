package com.miapp;

import com.miapp.dao.BilleteDAOImpl;
import com.miapp.modelo.Cliente;
import com.miapp.util.HibernateUtils;

public class Main {

    public static void main(String[]args){
        Cliente cli1 = new Cliente();
        cli1.setNombre("C/ Puerto Ventana");
        BilleteDAOImpl direcDaoImpl = new BilleteDAOImpl(HibernateUtils.getSessionFactory());
        direcDaoImpl.addCliente(cli1);






    }


}
