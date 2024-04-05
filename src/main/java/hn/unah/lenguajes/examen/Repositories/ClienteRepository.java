package hn.unah.lenguajes.examen.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.examen.Entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
    
}
