package envios.envios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "equipaje")
public class EquipajeModel extends Auditable<Integer> {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotBlank
    @Column(name = "contenido", length = 500, nullable =  false)
    public String contenido;

    @NotNull
    @Column(name = "peso", nullable =  false)
    public double peso;

    @NotNull
    @Column(name = "costo", nullable =  false)
    public double costo;

    @NotBlank
    @Column(name = "tipoEquipaje", length = 5, nullable = false)
    public String tipoEquipaje;

    @NotNull
    @Column(name = "idDetalleEnvio", nullable = false)
    public int detalleEnvio_id;

    @NotBlank
    @Column(name = "estado", length = 5, nullable = false)
    public String estado;
}
