package TDA.Asignacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.Asignacion.models.MantenimientoModel;

@Repository
public interface IMantenimientoRepository extends CrudRepository <MantenimientoModel,Integer> {
    
}
