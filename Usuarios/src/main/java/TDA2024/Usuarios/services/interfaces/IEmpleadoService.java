package TDA2024.Usuarios.services.interfaces;

import TDA2024.Usuarios.models.EmpleadoModel;

public interface IEmpleadoService {
    public Iterable<EmpleadoModel> findAll();
    public EmpleadoModel findById(Integer id);
    public EmpleadoModel add (EmpleadoModel model);
    public EmpleadoModel update(EmpleadoModel model);
    public boolean delete (Integer id);
}
