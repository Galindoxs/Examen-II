package hn.unah.lenguajes.examen.Services;

import java.util.List;

import hn.unah.lenguajes.examen.Entity.Cliente;

public interface ClienteService {
    
    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerClientes();

    public Cliente obtenerClienteByDni(String dni);
}
