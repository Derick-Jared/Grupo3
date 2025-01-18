package TDA.Asignacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TDA.Asignacion.models.Asignacion_EnvioModel;
import TDA.Asignacion.repositories.IAsignacion_Envio;

@Service
public class AsignacionService implements IAsignacion_EnvioService {
    @Autowired
    IAsignacion_Envio repository;

    @Override
    public List<Asignacion_EnvioModel> findAll() {
        return (List<Asignacion_EnvioModel>) repository.findAll();
    }

    @Override
    public Asignacion_EnvioModel findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Asignacion_EnvioModel add(Asignacion_EnvioModel model) {
        return repository.save(model);
    }

    @Override
    public Asignacion_EnvioModel update(Asignacion_EnvioModel model) {
        return repository.save(model);
    }

    @Override
    public boolean delete(int id) {
        if(repository.findById(id)!=null) {
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
