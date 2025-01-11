package envios.envios.model;

import java.sql.Date;

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
@Table(name = "detalle_envio")
public class DetalleEnvioModel extends Auditable<Integer> {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotNull
    @Column(name = "cantidadEquipaje", nullable =  false)
    public int cantidadEquipaje;

    @NotNull
    @Column(name = "costoTotal", nullable =  false)
    public double costoTotal;

    @NotNull
    @Column(name = "fechaEnvio", nullable = true)
    public Date fechaEnvio;

    @NotNull
    @Column(name = "fechaEstimada", nullable = true)
    public Date fechaEstimada;

    @NotNull
    @Column(name = "fechaEntrega", nullable = true)
    public Date fechaEntrega;

    @NotBlank
    @Column(name = "ruc", length = 20, nullable = true)
    public String ruc;

    @NotNull
    @Column(name = "idEnvio", nullable = false)
    public int envio_id;

    @NotNull
    @Column(name = "sedeInicio", nullable = false)
    public int puntoInicio;

    @NotNull
    @Column(name = "sedeFinal", nullable = false)
    public int puntoFinal;

    @NotBlank
    @Column(name = "estado", length = 5, nullable = false)
    public String estado;
}
