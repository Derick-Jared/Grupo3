package Catalogo.Catalogo.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.NotFound;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Catalogo")
@Data
@EntityListeners(AuditingEntityListener.class)
public class CatalogoModel {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    @Column(name = "tabla", nullable = false)
    public int tabla;

    @Column(name = "item", nullable = false)
    public int item;

    @Column(name = "descripcion_corta", nullable = false, length = 5)
    @NotBlank(message = "La descripcion corta es obligatoria")
    @Size(max = 5, message = "La descripcion corta no puede superar los 5 caracteres")
    public String descripcion_corta;

    @Column(name = "descripcion_larga", nullable = false, length = 255)
    @NotBlank(message = "La descripcion larga es obligatoria")
    @Size(max = 255, message = "La descripcion corta no puede superar los 5 caracteres")
    public String descripcion_larga;

    @Column(name = "estado", nullable = false, length = 5)
    public String estado;

    // @CreatedBy
    @Column(name = "creado_por")
    public Integer creado_por;

    @CreatedDate
    @Column(name = "creado_en")
    public LocalDateTime creado_en;

    // @LastModifiedBy
    @Column(name = "actualizado_por")
    public Integer actualizado_por;

    @LastModifiedDate
    @Column(name = "actualizado_en")
    public LocalDateTime actualizado_en;
}
