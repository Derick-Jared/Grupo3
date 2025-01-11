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
@Table(name = "envio")
public class EnvioModel extends Auditable<Integer> {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(name = "codigo", length = 10, nullable =  false)
    private String codigo;

    @NotBlank
    @Column(name = "tipoEnvio", length = 5, nullable =  false)
    private String tipoEnvio;

    @NotNull
    @Column(name = "idUsuario", nullable =  false)
    private int idUsuario;

    @NotNull
    @Column(name = "idEmpleado", nullable = false)
    private int idEmpleado;

    @NotBlank
    @Column(name = "estado", length = 5, nullable = false)
    private String estado;
}
