package envios.envios.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable<U> {
    
    @CreatedDate
    @Column(name = "creado_en", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime creado_en;

    @CreatedBy
    @Column(name = "creado_por", updatable = false)
    public U creado_por;

    @LastModifiedDate
    @Column(name = "actualizado_en")
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime actualizado_en;

    @LastModifiedBy
    @Column(name = "actualizado_por")
    public U actualizado_por;
}
