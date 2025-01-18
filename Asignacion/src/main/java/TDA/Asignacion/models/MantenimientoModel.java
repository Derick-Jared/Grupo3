package TDA.Asignacion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table( name = "mantenimiento")
public class MantenimientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "descripcion")
    public String descripcion;

    @Column(name = "estado")
    public String estado;

    @Column(name = "fechaInicio")
    public String fechaInicio;

    @Column(name = "fechaFin")
    public String fechaFin;

    @Column(name = "idVehiculo")
    public String idVehiculo;
    
    @Column(name = "creado_por")
    public String creado_por;

    @Column(name = "creado_en")
    public String creado_en;

    @Column(name = "actualizado_por")
    public String actualizado_por;

    @Column(name = "actualizado_en")
    public String actualizado_en;
}
