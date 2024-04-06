package hn.unah.lenguajes.examen.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen.Entity.Cliente;
import hn.unah.lenguajes.examen.Services.Impl.ClienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class ClienteController {
    
    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/cliente/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
       return this.clienteServiceImpl.crearCliente(cliente);
    }

    @GetMapping("/cliente/obtener")
    public List<Cliente> obtenerClientes() {
        return this.clienteServiceImpl.obtenerClientes();
    }
    
    @GetMapping("/cliente/obtenerPorDni")
    public Cliente obtenerClienteByDni(@PathVariable String dni) {
        return this.clienteServiceImpl.obtenerClienteByDni(dni);
    }
    
}
