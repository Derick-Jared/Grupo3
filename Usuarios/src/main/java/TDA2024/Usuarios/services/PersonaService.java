package TDA2024.Usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA2024.Usuarios.models.PersonaModel;
import TDA2024.Usuarios.repositories.IPersonaRepositories;
import TDA2024.Usuarios.services.interfaces.IPersonaService;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    IPersonaRepositories personaRepository;
    
    @Override
    public Iterable<PersonaModel> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaModel findById(Integer id) {
        return personaRepository.findById(id).get();
    }

    @Override
    public PersonaModel add(PersonaModel model) {
       return personaRepository.save(model);
    }

    @Override
    public PersonaModel update(PersonaModel model) {
        return personaRepository.save(model);
    }

    @Override
    public boolean delete(Integer id) {
        if(personaRepository.findById(id).get()!=null){
            personaRepository.deleteById(id);
            return true; 
        }else{
            return false;
        }
    }
    
}
