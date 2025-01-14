package TDA2024.Usuarios.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import TDA2024.Usuarios.models.PersonaModel;

public interface IPersonaRepository extends MongoRepository  <PersonaModel , Integer>{
    
    
    PersonaModel findFirstByOrderByIdDesc();
    
}
