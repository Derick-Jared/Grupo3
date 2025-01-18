package envios.envios.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "sede")
public class SedeModel extends Auditable<Integer> {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotBlank
    @Column(name = "nombre", length = 255, nullable =  false)
    public String nombre;

    @NotBlank
    @Column(name = "direccion", length = 255, nullable =  false)
    public String direccion;

    @NotBlank
    @Column(name = "ciudad", length = 5, nullable =  false)
    public String ciudad;

    @NotBlank
    @Column(name = "pais", length = 5, nullable = false)
    public String pais;

    @NotBlank
    @Column(name = "departamento", length = 5, nullable = false)
    public String departamento;

    @Column(name = "telefono", length = 15, nullable = false)   
    public String telefono;

    @NotBlank
    @Column(name = "estado", length = 5, nullable = true)
    public String estado;
}
