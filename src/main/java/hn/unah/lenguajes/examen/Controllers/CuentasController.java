package hn.unah.lenguajes.examen.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen.Entity.Cliente;
import hn.unah.lenguajes.examen.Entity.Cuentas;
import hn.unah.lenguajes.examen.Services.Impl.CuentasServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api")

public class CuentasController {
    
    @Autowired
    private CuentasServiceImpl cuentasServiceImpl;

    @PostMapping("/cuenta/crear")
    public Cuentas crearCuenta(@RequestBody Cuentas cuenta) {
        return this.cuentasServiceImpl.crearCuenta(cuenta);
    }


    @PutMapping("/cuentas/cuentaToCliente/{dni}")
    public Cliente cuentaToCliente(@PathVariable String dni, @RequestParam String numeroCuenta) {
        return this.cuentasServiceImpl.cuentaToCliente(dni, numeroCuenta);
    }
}
