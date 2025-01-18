package com.example.security.repositories;

import com.example.security.models.UsuarioModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAuthRepository extends MongoRepository <UsuarioModel , Long>{
    
}
