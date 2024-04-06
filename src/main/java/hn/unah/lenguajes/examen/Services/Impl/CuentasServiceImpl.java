package hn.unah.lenguajes.examen.Services.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen.Entity.Cliente;
import hn.unah.lenguajes.examen.Entity.Cuentas;
import hn.unah.lenguajes.examen.Repositories.ClienteRepository;
import hn.unah.lenguajes.examen.Repositories.CuentasRepository;
import hn.unah.lenguajes.examen.Services.CuentasService;

@Service
public class CuentasServiceImpl implements CuentasService{

    @Autowired
    private CuentasRepository cuentasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cuentas crearCuenta(Cuentas cuenta) {
        if(this.cuentasRepository.existsById(cuenta.getNumeroCuenta())){
            //Cuentas nuevaCuenta = new Cuentas();
            cuenta.setFechaApertura(LocalDate.now());
            cuenta.setEstado(true);

            if(cuenta.getSaldo() < 500){
                cuenta.setSaldo(500);
            }

            return this.cuentasRepository.save(cuenta);

        }
        return null;
    }

    @Override
    public Cliente cuentaToCliente(String dni, String numeroCuenta) {
       if(this.cuentasRepository.existsById(numeroCuenta)){
        if(this.clienteRepository.existsById(dni)){
            Cuentas cuenta = this.cuentasRepository.findById(numeroCuenta).get();
            //Validacion de cuenta en clientes
            if(this.clienteRepository.existsById(numeroCuenta)){
                return null;
            }else{
                Cliente cliente = this.clienteRepository.findById(dni).get();
                cliente.setCuentas((List<Cuentas>) cuenta);
                return this.clienteRepository.save(cliente);
                
            }
        }
       }
       return null;
    }
}