package TDA2024.Usuarios.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;



import TDA2024.Usuarios.models.UsuarioModel;


public interface IUsuarioRepository extends MongoRepository <UsuarioModel , Integer> {
    
    UsuarioModel findByEmail(String email);
    UsuarioModel findFirstByOrderByIdDesc();
}
