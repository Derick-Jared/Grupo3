package TDA.Asignacion.services;

import java.util.List;

import TDA.Asignacion.models.Asignacion_EnvioModel;

public interface IAsignacion_EnvioService {
    public List<Asignacion_EnvioModel> findAll ();
    public Asignacion_EnvioModel findById (int id);
    public Asignacion_EnvioModel add (Asignacion_EnvioModel model);
    public Asignacion_EnvioModel update (Asignacion_EnvioModel model);
    public boolean delete (int id);
}
