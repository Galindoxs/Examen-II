package hn.unah.lenguajes.examen.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.examen.Entity.Cliente;
import hn.unah.lenguajes.examen.Entity.Direccion;
import hn.unah.lenguajes.examen.Repositories.ClienteRepository;
import hn.unah.lenguajes.examen.Repositories.DireccionRepository;
import hn.unah.lenguajes.examen.Services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public Direccion crearDireccion(Direccion direccion, String dni) {
        this.direccionRepository.save(direccion);

       if(this.clienteRepository.existsById(dni)){
            Cliente cliente = this.clienteRepository.findById(dni).get();
            cliente.setDireccion(direccion);
            this.clienteRepository.save(cliente);
            return cliente.getDireccion();
       }
        return direccion;
    }
    
}
