package envios.envios.service;

import java.util.List;

import envios.envios.model.DetalleEnvioModel;

public interface IDetalleEnvioService {
    public DetalleEnvioModel create (DetalleEnvioModel model);
    public List<DetalleEnvioModel> getAll();
    public List<DetalleEnvioModel> getAllHabilitado(); 
    public DetalleEnvioModel getById(int id);
    public DetalleEnvioModel update(DetalleEnvioModel model);
    public DetalleEnvioModel updateEstado(DetalleEnvioModel mdoel);
    public boolean delete(int id);
}
