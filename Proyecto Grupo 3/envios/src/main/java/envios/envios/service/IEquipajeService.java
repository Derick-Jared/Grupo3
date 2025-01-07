package envios.envios.service;

import java.util.List;

import envios.envios.model.EquipajeModel;

public interface IEquipajeService {
    public EquipajeModel create (EquipajeModel model);
    public List<EquipajeModel> getAll();
    public List<EquipajeModel> getAllHabilitado();
    public List<EquipajeModel> getAllByDetalleId(int id);
    public EquipajeModel getById(int id);
    public EquipajeModel update(EquipajeModel model);
    public EquipajeModel updateEstado(EquipajeModel model);
    public boolean delete(int id);
}
