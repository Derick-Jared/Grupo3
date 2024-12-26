package TDA2024.Usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TDA2024.Usuarios.models.EmpleadoModel;
import TDA2024.Usuarios.repositories.IEmpleadoRepository;
import TDA2024.Usuarios.services.interfaces.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    IEmpleadoRepository empleadoRepository;
    @Override
    public Iterable<EmpleadoModel> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoModel findById(Integer id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public EmpleadoModel add(EmpleadoModel model) {
        return empleadoRepository.save(model);
    }

    @Override
    public EmpleadoModel update(EmpleadoModel model) {
        return empleadoRepository.save(model);
    }

    @Override
    public boolean delete(Integer id) {
        if(empleadoRepository.findById(id).get()!=null){
            empleadoRepository.deleteById(id);
            return true; 
        }else{
            return false;
        }
    }
    
}
