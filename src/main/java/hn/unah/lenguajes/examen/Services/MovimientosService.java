package hn.unah.lenguajes.examen.Services;

import java.util.List;

import hn.unah.lenguajes.examen.Entity.Movimientos;

public interface MovimientosService {
    
    public Movimientos crearMovimientos(Movimientos movimiento);

    public List<Movimientos> ObtenerMovimientosByCuenta(String numeroCuenta);
}
