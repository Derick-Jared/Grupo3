package TDA2024.Usuarios.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persona")
public class PersonaModel {
    
    @BsonId
    private Integer id;
    private String cedula;
    private String tipo_documento;
    private String nombres;
    private String apellidos;
    private String razon_social;
    private String direccion;
    private String telefono;
    private String email;
    private String estado;
    private Integer creado_por;
    private String creado_en;
    private Integer actualizado_por;
    private String actualizado_en;

    public PersonaModel() {
    }

    public PersonaModel(Integer id, String cedula, String tipo_documento, String nombres, String apellidos,
            String razon_social, String direccion, String telefono, String email, String estado, Integer creado_por,
            String creado_en, Integer actualizado_por, String actualizado_en) {
        this.id = id;
        this.cedula = cedula;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.razon_social = razon_social;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
