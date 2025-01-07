package envios.envios.service;

import java.util.List;

import envios.envios.model.EnvioModel;

public interface IEnvioService {
    public EnvioModel create (EnvioModel model);
    public List<EnvioModel> getAll();
    public List<EnvioModel> getAllHabilitado();
    public List<EnvioModel> getAllByUser(int id);
    public EnvioModel getById(int id);
    public EnvioModel update(EnvioModel model);
    public EnvioModel updateEstado(EnvioModel model);
    public boolean delete(int id);
}
