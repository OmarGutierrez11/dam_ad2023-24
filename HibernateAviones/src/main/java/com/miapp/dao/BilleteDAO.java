package com.miapp.dao;

import com.miapp.modelo.Cliente;

public interface BilleteDAO {
double calcularPrecioFinal();
void reasignarAsientosFamilia();
void creaBillete();
void addCliente(Cliente cliente);

}
