package hn.unah.lenguajes.examen.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id     
    private String dni;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    @OneToOne(mappedBy = "cliente")
    private Direccion direccion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cuentas> cuentas;
}



