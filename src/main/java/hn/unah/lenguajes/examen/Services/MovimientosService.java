package hn.unah.lenguajes.examen.Services;

import hn.unah.lenguajes.examen.Entity.Movimientos;

public interface MovimientosService {
    
    public Movimientos crearMovimientos(Movimientos movimiento);

    public Movimientos ObtenerMovimientosByCuenta(String numeroCuenta);
}
