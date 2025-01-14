package TDA2024.Usuarios.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import TDA2024.Usuarios.models.EmpleadoModel;

public interface IEmpleadoRepository extends MongoRepository <EmpleadoModel , Integer> {

    EmpleadoModel findFirstByOrderByIdDesc();
    
}
