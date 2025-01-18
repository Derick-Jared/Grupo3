package TDA.Asignacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.Asignacion.models.VehiculoModel;

@Repository
public interface IVehiculoModel extends CrudRepository<VehiculoModel,Integer>{
    
}
