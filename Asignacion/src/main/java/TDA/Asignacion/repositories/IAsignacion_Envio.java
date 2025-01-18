package TDA.Asignacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TDA.Asignacion.models.Asignacion_EnvioModel;

@Repository
public interface IAsignacion_Envio extends CrudRepository<Asignacion_EnvioModel,Integer>{

    
}
