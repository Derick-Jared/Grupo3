package TDA2024.Recepcion.models;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "recepcion")
public class RecepcionModel implements Serializable {
    
    @BsonId
    private Integer id;
    private int idEnvio;
    private String fechaRecepcion;
    private String sede;
    private String nombre;
    private String apellido;
    private String cedula;
    private String tipo_documento;
    private String estado;
    private Integer creado_por;
    private String creado_en;
    private Integer actualizado_por;
    private String actualizado_en;
    
    public RecepcionModel() {
    }

    public RecepcionModel(Integer id, String fechaRecepcion, int idEnvio, String sede, String nombre, String apellido, String cedula,
            String tipo_documento, String estado, Integer creado_por, String creado_en, Integer actualizado_por,
            String actualizado_en) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.idEnvio = idEnvio;
        this.sede = sede;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.tipo_documento = tipo_documento;
        this.estado = estado;
        this.creado_por = creado_por;
        this.creado_en = creado_en;
        this.actualizado_por = actualizado_por;
        this.actualizado_en = actualizado_en;
    }

}
