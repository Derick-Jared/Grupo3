package com.example.security.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.security.models.UsuarioModel;
import com.example.security.repositories.IAuthRepository;

public class AuthService {
    
    @Autowired
    IAuthRepository authRepository;

    public List<UsuarioModel> getAcces(){
        return (List<UsuarioModel>) authRepository.findAll();
    }

    public Boolean validateCrdentials(String userName, String password){
        List<UsuarioModel> result = (List<UsuarioModel>) authRepository.findAll();
        List<UsuarioModel> resultFilter = result.stream()
                .filter(t -> t.getEmail().equals(userName) && t.getPassword().equals(password))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()) {
            return false;
        }
        return true;
    }
}
