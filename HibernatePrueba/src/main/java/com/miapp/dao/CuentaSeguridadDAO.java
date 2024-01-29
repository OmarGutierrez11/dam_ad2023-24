package com.miapp.dao;

import java.util.List;

public interface CuentaSeguridadDAO {
    void addCuenta(CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO);
    List<CuentaSeguridadSocialDAOImpl> lista();
    CuentaSeguridadSocialDAOImpl getCuenta(Long id);
    void deleteCuenta(CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO);
    void updateCuenta(CuentaSeguridadSocialDAOImpl cuentaSeguridadSocialDAO);
}
