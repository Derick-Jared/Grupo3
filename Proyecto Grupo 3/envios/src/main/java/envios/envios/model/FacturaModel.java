package envios.envios.model;

import java.time.LocalDateTime;

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
@Table(name = "factura")
public class FacturaModel extends Auditable<Integer> {
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotBlank
    @Column(name = "tipoMoneda", length = 5, nullable =  false)
    public String tipoMoneda;

    @NotNull
    @Column(name = "costo", nullable =  false)
    public double costo;

    @NotNull
    @Column(name = "fechaPago", nullable =  true)
    public LocalDateTime fechaPago;

    @NotBlank
    @Column(name = "metodoPago", length = 5, nullable =  true)
    public String metodoPago;

    @NotBlank
    @Column(name = "numeroCuenta", length = 20, nullable =  true)
    public String numeroCuenta;

    @NotNull
    @Column(name = "idDetalleEnvio", nullable = false)
    public int idDetalleEnvio;

    @NotBlank
    @Column(name = "estado", length = 5, nullable = false)
    public String estado;
}
