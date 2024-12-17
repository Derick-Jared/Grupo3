package TDA2024.Recepcion.models;

import java.io.Serializable;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recepcion")
public class RecepcionModel implements Serializable {
    
    @BsonId
    private Integer id;
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

    public RecepcionModel(Integer id, String fechaRecepcion, String sede, String nombre, String apellido, String cedula,
            String tipo_documento, String estado, Integer creado_por, String creado_en, Integer actualizado_por,
            String actualizado_en) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
