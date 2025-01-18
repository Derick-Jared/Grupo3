package TDA.Asignacion.services;

import java.util.List;

import TDA.Asignacion.models.*;

public interface IMantenimientoService {
    public List<MantenimientoModel> findAll ();
    public MantenimientoModel findById (int id);
    public MantenimientoModel add (MantenimientoModel model);
    public MantenimientoModel update (MantenimientoModel model);
    public boolean delete (int id);
}
