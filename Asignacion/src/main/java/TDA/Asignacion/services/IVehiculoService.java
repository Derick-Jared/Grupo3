package TDA.Asignacion.services;

import java.util.List;

import TDA.Asignacion.models.*;

public interface IVehiculoService {

    public List<VehiculoModel> findAll ();
    public VehiculoModel findById (int id);
    public VehiculoModel add (VehiculoModel model);
    public VehiculoModel update (VehiculoModel model);
    public boolean delete (int id);
    
}