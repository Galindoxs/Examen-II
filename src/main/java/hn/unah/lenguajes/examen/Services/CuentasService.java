package hn.unah.lenguajes.examen.Services;

import hn.unah.lenguajes.examen.Entity.Cliente;
import hn.unah.lenguajes.examen.Entity.Cuentas;

public interface CuentasService {
    
    public Cuentas crearCuenta(Cuentas cuenta);

    public Cliente cuentaToCliente(String dni, String numeroCuenta);
}
