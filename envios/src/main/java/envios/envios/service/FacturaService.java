package envios.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import envios.envios.model.FacturaModel;
import envios.envios.repository.IDetalleEnvioRepository;
import envios.envios.repository.IFacturaRepository;

@Service
public class FacturaService implements IFacturaService{
    @Autowired
    public IFacturaRepository repository;

    @Autowired
    public IDetalleEnvioRepository detalleRepository;

    @Override
    public FacturaModel create(FacturaModel model) {
        if(!detalleRepository.existsById(model.getIdDetalleEnvio())) return null;
        if(repository.findByDetalle(model.getIdDetalleEnvio()) != null) return null;
        return repository.save(model);
    }

    @Override
    public List<FacturaModel> getAll() {
        return (List<FacturaModel>) repository.findAll();
    }

    @Override
    public List<FacturaModel> getAllHabilitado() {
        return (List<FacturaModel>) repository.findAllHab();
    }

    @Override
    public FacturaModel getById(int id) {
        return (FacturaModel) repository.findById(id).get();
    }

    @Override
    public FacturaModel getByIdDetalleEnvio(int id) {
        return repository.findByDetalle(id);
    }

    @Override
    public FacturaModel update(FacturaModel model) {
        FacturaModel newModel = repository.findById(model.getId()).get();
        if(newModel == null) return null;
        model.setIdDetalleEnvio(newModel.getIdDetalleEnvio());
        return repository.save(model);
    }

    @Override
    public FacturaModel updateEstado(FacturaModel model) {
        FacturaModel newModel = repository.findById(model.getId()).get();
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