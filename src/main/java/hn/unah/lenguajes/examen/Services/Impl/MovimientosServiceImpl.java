package hn.unah.lenguajes.examen.Services.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen.Entity.Cuentas;
import hn.unah.lenguajes.examen.Entity.Movimientos;
import hn.unah.lenguajes.examen.Repositories.CuentasRepository;
import hn.unah.lenguajes.examen.Repositories.MovimientosRepository;
import hn.unah.lenguajes.examen.Services.MovimientosService;

@Service
public class MovimientosServiceImpl implements MovimientosService{

    @Autowired
    private MovimientosRepository movimientosRepository;

    @Autowired
    private CuentasRepository cuentasRepository;

    @Override
    public Movimientos crearMovimientos(Movimientos movimiento) {
       if(this.cuentasRepository.existsById(movimiento.getCuentas().getNumeroCuenta())){
        Cuentas cuenta = this.cuentasRepository.findById(movimiento.getCuentas().getNumeroCuenta()).get();
            if(cuenta.isEstado()){
                movimiento.setFechaMovimiento(LocalDate.now());
                if(movimiento.getTipoMovimiento() == 'D'){
                    if(cuenta.getSaldo()!= 0){
                        cuenta.setSaldo(cuenta.getSaldo()-movimiento.getMonto());
                        this.cuentasRepository.save(cuenta);
                    }else{
                        cuenta.setSobreGiro(true);
                        cuenta.setSaldo(cuenta.getSaldo()-movimiento.getMonto());
                        this.cuentasRepository.save(cuenta);
                    }
                
                }else if(movimiento.getTipoMovimiento() == 'C'){
                    cuenta.setSaldo(cuenta.getSaldo()+movimiento.getMonto());
                    this.cuentasRepository.save(cuenta);
                    
                }
                return this.movimientosRepository.save(movimiento);        }
        }
        return null;
       }
    

    @Override
    public List<Movimientos> ObtenerMovimientosByCuenta(String numeroCuenta) {
        return (List<Movimientos>) this.cuentasRepository.findById(numeroCuenta).get();
    }
    
}
