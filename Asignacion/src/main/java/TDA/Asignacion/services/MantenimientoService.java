package TDA.Asignacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA.Asignacion.models.MantenimientoModel;
import TDA.Asignacion.repositories.IMantenimientoRepository;


@Service
public class MantenimientoService implements IMantenimientoService {

    @Autowired
    IMantenimientoRepository repository;

    @Override
    public List<MantenimientoModel> findAll() {
        return (List<MantenimientoModel>) repository.findAll();
    }

    @Override
    public MantenimientoModel findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public MantenimientoModel add(MantenimientoModel model) {
        return repository.save(model);
    }

    @Override
    public MantenimientoModel update(MantenimientoModel model) {
        if(repository.findById(model.id)!=null){
            return repository.save(model);
        }else{
            return null;
        }
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
