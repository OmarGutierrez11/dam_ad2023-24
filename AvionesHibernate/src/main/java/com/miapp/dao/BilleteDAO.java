package com.miapp.dao;

import com.miapp.modelo.Billete;
import com.miapp.modelo.Cliente;
import com.miapp.modelo.Pasajero;

import java.util.List;

public interface BilleteDAO {
double calcularPrecioFinal(long id);
Billete obtenerInfoBillete(long id);

List<Pasajero> infoPasajeroBillete(long id);
void reasignarAsientosFamilia(Long id, String tipo, int fila);
void creaBillete(Double precioPasajero, int descNinos, List<Pasajero> pasajeros);


}
