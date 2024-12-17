package TDA2024.Recepcion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA2024.Recepcion.models.IncidenciaModel;
import TDA2024.Recepcion.repositories.IIncidenciaRepository;
import TDA2024.Recepcion.services.interfaces.IIncidenciaService;
//@CacheConfig(cacheNames = "inicidencia")
@Service
public class IncidenciaService implements IIncidenciaService{
    @Autowired
	IIncidenciaRepository incidenciaRepository;

    @Override
    public IncidenciaModel add(IncidenciaModel incidencia) {
       return incidenciaRepository.save(incidencia);
    }

    @Override
    public Iterable<IncidenciaModel> findAll() {
        return incidenciaRepository.findAll();
    }

    @Override
    public IncidenciaModel findById(Integer id) {
        return incidenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Incidencia no encontrada con el ID: " + id));
    }

    @Override
    public IncidenciaModel update(IncidenciaModel incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    @Override
    public boolean delete(Integer id) {
        if(incidenciaRepository.findById(id).get()!=null){
            incidenciaRepository.deleteById(id);
            return true; 
        }else{
            return false;
        }
    }


}
