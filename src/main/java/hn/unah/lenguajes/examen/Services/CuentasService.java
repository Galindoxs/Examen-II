package hn.unah.lenguajes.examen.Services;

import hn.unah.lenguajes.examen.Entity.Cuentas;

public interface CuentasService {
    
    public Cuentas crearCuenta(Cuentas cuenta);

    public Cuentas cuentaToCliente(String dni, String numeroCuenta);
}
