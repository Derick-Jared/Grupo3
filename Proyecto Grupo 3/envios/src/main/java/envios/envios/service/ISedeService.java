package envios.envios.service;

import java.util.List;

import envios.envios.model.SedeModel;

public interface ISedeService {

    public SedeModel create (SedeModel model);
    public List<SedeModel> getAll();
    public List<SedeModel> getAllHabilitado();
    public SedeModel getById(int id);
    public SedeModel update(SedeModel model);
    public SedeModel updateEstado(SedeModel model);
    public boolean delete(int id);
}
