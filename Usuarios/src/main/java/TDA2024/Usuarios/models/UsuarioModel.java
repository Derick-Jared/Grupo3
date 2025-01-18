package TDA2024.Usuarios.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class UsuarioModel {

    @BsonId
    private Integer id;
    private String email;
    private String password;
    private String tipo_usuario;
    private String idPersona;
    private String estado;
    private Integer creado_por;
    private String creado_en;
    private Integer actualizado_por;
    private String actualizado_en;

    public UsuarioModel() {
    }

    public UsuarioModel(Integer id, String email, String password, String tipo_usuario, String idPersona, String estado,
            Integer creado_por, String creado_en, Integer actualizado_por, String actualizado_en) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
        this.idPersona = idPersona;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
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
