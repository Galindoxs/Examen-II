package hn.unah.lenguajes.examen.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen.Entity.Cliente;
import hn.unah.lenguajes.examen.Repositories.ClienteRepository;
import hn.unah.lenguajes.examen.Services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
       if(this.clienteRepository.existsById(cliente.getDni())){
            return this.clienteRepository.save(cliente);
       }
        return null;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClienteByDni(String dni) {
        return this.clienteRepository.findById(dni).get();
    }
    
}
