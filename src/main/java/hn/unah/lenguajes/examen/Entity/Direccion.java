package hn.unah.lenguajes.examen.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "direccion")
@Data
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddireccion")
    private long idDireccion;

    private String estado;

    private String ciudad;

    private String calle;

    @OneToOne
    @JoinColumn(name = "dni",referencedColumnName = "dni")
    private Cliente cliente;

    
}
