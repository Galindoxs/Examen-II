package hn.unah.lenguajes.examen.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.examen.Entity.Direccion;
import hn.unah.lenguajes.examen.Services.Impl.DireccionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api")
public class DireccionController {
    
    @Autowired
    private DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/direccion/crear/{dni}")
    public Direccion crearDireccion(@RequestBody Direccion direccion, @PathVariable String dni) {
   
        return this.direccionServiceImpl.crearDireccion(direccion, dni);
    }


}
