package TDA2024.Usuarios.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import TDA2024.Usuarios.models.PersonaModel;

public interface IPersonaRepositories extends MongoRepository  <PersonaModel , Integer>{
    
}
