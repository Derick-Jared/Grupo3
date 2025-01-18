package TDA2024.Usuarios.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleado")
public class EmpleadoModel {

    @BsonId
    private Integer id;
    private String cargo;
    private String estado;
    private String idPersona;
    private Integer creado_por;
    private String creado_en;
    private Integer actualizado_por;
    private String actualizado_en;
    
    public EmpleadoModel() {
    }

    public EmpleadoModel(Integer id, String cargo, String estado, String idPersona, Integer creado_por,
            String creado_en, Integer actualizado_por, String actualizado_en) {
        this.id = id;
        this.cargo = cargo;
        this.estado = estado;
        this.idPersona = idPersona;
        this.creado_por = creado_por;
        this.creado_en = creado_en;
        this.actualizado_por = actualizado_por;
        this.actualizado_en = actualizado_en;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(Integer creado_por) {
        this.creado_por = creado_por;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }

    public Integer getActualizado_por() {
        return actualizado_por;
    }

    public void setActualizado_por(Integer actualizado_por) {
        this.actualizado_por = actualizado_por;
    }

    public String getActualizado_en() {
        return actualizado_en;
    }

    public void setActualizado_en(String actualizado_en) {
        this.actualizado_en = actualizado_en;
    }


        
}
