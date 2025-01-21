package envios.envios.dot;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import envios.envios.model.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class RequestEnvio {
    private Integer id;
    private int idEnvio;
    private String fechaRecepcion;
    private String sede;
    private String nombre;
    private String apellido;
    private String cedula;
    private String tipo_documento;
    private String estado;
    public String creado_en;

    public Integer creado_por;

    public String actualizado_en;

    public Integer actualizado_por;
}
