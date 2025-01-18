package TDA.Asignacion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table( name = "vehiculo")
public class VehiculoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "placa")
    public String placa;

    @Column(name = "marca")
    public String marca;

    @Column(name = "modelo")
    public String modelo;

    @Column(name = "capacidadCarga")
    public String capacidadCarga;

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
