package TDA2024.Recepcion.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import TDA2024.Recepcion.models.RecepcionModel;

public interface IRecepcionRepository extends MongoRepository <RecepcionModel, Integer> {
    
}
