package Catalogo.Catalogo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Catalogo")
@Data
public class CatalogoModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "tabla")
    public int tabla;
    @Column(name = "item")
    public int item;
    @Column(name = "descripcionCorta")
    public String descripcionCorta;
    @Column(name = "descripcionLarga")
    public String descripcionLarga;
    @Column(name = "estado")
    public String estado;
    @Column(name = "creado_por")
    public Integer creado_por;
    @Column(name = "creado_en")
    public Date creado_en;
    @Column(name = "actualizado_por")
    public Integer actualizado_por;
    @Column(name = "actualizado_en")
    public Date actualizado_en;
}
