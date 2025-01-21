package envios.envios.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import envios.envios.model.EnvioModel;
import envios.envios.repository.IEnvioRepository;

@Service
public class EnvioService implements IEnvioService {

    @Autowired
    public IEnvioRepository repository;

    @Override
    public EnvioModel create(EnvioModel model) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ssMMyy");
        String codigo = "ENV-" + LocalDate.now().format(formato);
        model.setCodigo(codigo);
        return repository.save(model);
    }

    @Override
    public List<EnvioModel> getAll() {
        return (List<EnvioModel>) repository.findAll();
    }

    @Override
    public List<EnvioModel> getAllHabilitado() {
        return (List<EnvioModel>) repository.findAllHab();
    }

    @Override
    public List<EnvioModel> getAllByUser(int id) {
        return (List<EnvioModel>) repository.findAllByUserId(id);
    }

    @Override
    public EnvioModel getById(int id) {
        return (EnvioModel) repository.findById(id).get();
    }

    @Override
    public EnvioModel update(EnvioModel model) {
        EnvioModel newModel = repository.findById(model.getId()).get();
        if(newModel == null) return null;
        model.setCodigo(newModel.getCodigo());
        return repository.save(model);
    }

    @Override
    public EnvioModel updateEstado(EnvioModel model) {
        EnvioModel newModel = repository.findById(model.getId()).get();
        if(newModel == null){
            return null;
        }
        newModel.setEstado(model.getEstado());
        return repository.save(newModel);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }
    
}
