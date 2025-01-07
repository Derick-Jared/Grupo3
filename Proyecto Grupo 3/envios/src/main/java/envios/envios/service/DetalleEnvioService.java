package envios.envios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import envios.envios.model.DetalleEnvioModel;
import envios.envios.model.EnvioModel;
import envios.envios.model.SedeModel;
import envios.envios.repository.IDetalleEnvioRepository;
import envios.envios.repository.IEnvioRepository;
import envios.envios.repository.ISedeRepository;

@Service
public class DetalleEnvioService implements IDetalleEnvioService{
    @Autowired
    public IDetalleEnvioRepository repository;

    @Autowired
    public IEnvioRepository envioRepository;

    @Autowired
    public ISedeRepository sedeRepository;

    @Override
    public DetalleEnvioModel create(DetalleEnvioModel model) {
        EnvioModel newModel = (EnvioModel) envioRepository.findById(model.getEnvio_id()).get();
        if(newModel == null || !validarSede(model)) return null;
        return repository.save(model);
    }

    @Override
    public List<DetalleEnvioModel> getAll() {
        return (List<DetalleEnvioModel>) repository.findAll();
    }

    @Override
    public List<DetalleEnvioModel> getAllHabilitado() {
        return (List<DetalleEnvioModel>) repository.findAllHab();
    }

    @Override
    public DetalleEnvioModel getById(int id) {
        return (DetalleEnvioModel) repository.findById(id).get();
    }

    @Override
    public DetalleEnvioModel update(DetalleEnvioModel model) {
        DetalleEnvioModel newModel = (DetalleEnvioModel) repository.findById(model.getId()).get();
        if(newModel == null || !validarSede(model)) return null;
        model.setEnvio_id(newModel.getEnvio_id());
        model.setEstado(newModel.getEstado());
        return repository.save(model);
    }

    @Override
    public DetalleEnvioModel updateEstado(DetalleEnvioModel model) {
        DetalleEnvioModel newModel = repository.findById(model.getId()).get();
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

    public boolean validarSede(DetalleEnvioModel model){
        if(model.getPuntoInicio() == model.getPuntoFinal()) return false;
        if(!sedeRepository.existsById(model.getPuntoInicio()) || !sedeRepository.existsById(model.getPuntoFinal())) return false;
        return true;
    }
}
