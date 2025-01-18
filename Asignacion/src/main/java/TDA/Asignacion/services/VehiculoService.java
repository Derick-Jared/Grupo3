package TDA.Asignacion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA.Asignacion.models.VehiculoModel;
import TDA.Asignacion.repositories.IVehiculoModel;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    IVehiculoModel repository;


    @Override
    public List<VehiculoModel> findAll() {
        return (List<VehiculoModel>) repository.findAll();
    }

    @Override
    public VehiculoModel findById(int id) {
        return repository.findById(id).get();
    }
    @Override
    public VehiculoModel add(VehiculoModel model) {
            return repository.save(model);
    }

    @Override
    public VehiculoModel update(VehiculoModel model) {
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
