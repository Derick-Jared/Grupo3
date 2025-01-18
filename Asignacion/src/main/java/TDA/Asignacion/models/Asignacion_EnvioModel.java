package TDA.Asignacion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity

@Table( name = "asignacion_envio")
public class Asignacion_EnvioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "fechaAsignacion")
    public String fechaAsignacion;

    @Column(name = "idChofer")
    public String idChofer;

    @Column(name = "idVehiculo")
    public String idVehiculo;

    @Column(name = "idEnvio")
    public String idEnvio;

    @Column(name = "estado")
    public String estado;

    @Column(name = "creado_por")
    public String creado_por;

    @Column(name = "creado_en")
    public String creado_en;

    @Column(name = "actualizado_por")
    public String actualizado_por;

    @Column(name = "actualizado_en")
    public String actualizado_en;

    


}
