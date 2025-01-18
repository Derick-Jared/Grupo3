package com.example.security.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
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
}
