package envios.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import envios.envios.model.EnvioModel;
import envios.envios.model.SedeModel;
import envios.envios.repository.ISedeRepository;

@Service
public class SedeService implements ISedeService{
    @Autowired
    public ISedeRepository repository;

    @Override
    public SedeModel create(SedeModel model) {
        return repository.save(model);
    }

    @Override
    public List<SedeModel> getAll() {
        return (List<SedeModel>) repository.findAll();
    }

    @Override
    public List<SedeModel> getAllHabilitado() {
        return (List<SedeModel>) repository.findAllHab();
    }

    @Override
    public SedeModel getById(int id) {
        return (SedeModel) repository.findById(id).get();
    }

    @Override
    public SedeModel update(SedeModel model) {
        return repository.save(model);
    }

    @Override
    public SedeModel updateEstado(SedeModel model) {
        SedeModel newModel = repository.findById(model.getId()).get();
        if(newModel == null) return null;
        newModel.setEstado(model.getEstado());
        return repository.save(newModel);
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }
}
