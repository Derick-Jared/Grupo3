package TDA2024.Recepcion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA2024.Recepcion.models.RecepcionModel;
import TDA2024.Recepcion.repositories.IRecepcionRepository;
import TDA2024.Recepcion.services.interfaces.IRecepcionService;
@Service
public class RecepcionService implements IRecepcionService{

    @Autowired
    IRecepcionRepository recepcionRepository;

    @Override
    public Iterable<RecepcionModel> findAll() {
        return recepcionRepository.findAll();
    }

    @Override
    public RecepcionModel findById(Integer id) {
        return recepcionRepository.findById(id).get();
    }

    @Override
    public RecepcionModel add(RecepcionModel model) {
        return recepcionRepository.save(model);
    }

    @Override
    public RecepcionModel update(RecepcionModel model) {
        return recepcionRepository.save(model);
    }

    @Override
    public boolean delete(Integer id) {
        if(recepcionRepository.findById(id).get()!=null){
            recepcionRepository.deleteById(id);
            return true; 
        }else{
            return false;
        }
    }
    
}
