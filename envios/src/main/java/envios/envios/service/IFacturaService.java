package envios.envios.service;

import java.util.List;

import envios.envios.model.FacturaModel;

public interface IFacturaService {
    public FacturaModel create (FacturaModel model);
    public List<FacturaModel> getAll();
    public List<FacturaModel> getAllHabilitado();
    public FacturaModel getById(int id);
    public FacturaModel getByIdDetalleEnvio(int id);
    public FacturaModel update(FacturaModel model);
    public FacturaModel updateEstado(FacturaModel model);
    public boolean delete(int id);
}
