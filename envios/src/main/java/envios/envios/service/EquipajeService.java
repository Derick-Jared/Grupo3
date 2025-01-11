package envios.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import envios.envios.model.EquipajeModel;
import envios.envios.repository.IDetalleEnvioRepository;
import envios.envios.repository.IEquipajeRepository;

@Service
public class EquipajeService implements IEquipajeService{
    @Autowired
    public IEquipajeRepository repository;

    @Autowired
    public IDetalleEnvioRepository detalleRepository;

    @Override
    public EquipajeModel create(EquipajeModel model) {
        if(!detalleRepository.existsById(model.getDetalleEnvio_id())) return null;
        return repository.save(model);
    }

    @Override
    public List<EquipajeModel> getAll() {
        return (List<EquipajeModel>) repository.findAll();
    }

    @Override
    public List<EquipajeModel> getAllHabilitado() {
        return (List<EquipajeModel>) repository.findAllHab();
    }

    @Override
    public List<EquipajeModel> getAllByDetalleId(int id) {
        if(!detalleRepository.existsById(id)) return null;
        return (List<EquipajeModel>) repository.findAllByDetalleEnvioId(id);
    }

    @Override
    public EquipajeModel getById(int id) {
        return (EquipajeModel) repository.findById(id).get();
    }

    @Override
    public EquipajeModel update(EquipajeModel model) {
        EquipajeModel newModel = repository.findById(model.getId()).get();
        if(newModel == null) return null;
        model.setDetalleEnvio_id(newModel.getDetalleEnvio_id());
        return repository.save(model);
    }

    @Override
    public EquipajeModel updateEstado(EquipajeModel model) {
        EquipajeModel newModel = repository.findById(model.getId()).get();
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
