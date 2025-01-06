package TDA2024.Recepcion.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import TDA2024.Recepcion.models.IncidenciaModel;

public interface IIncidenciaRepository extends MongoRepository  <IncidenciaModel , Integer>{
    
}
