package TDA2024.Usuarios.services.interfaces;

import TDA2024.Usuarios.models.UsuarioModel;

public interface IUsuarioService {
    public Iterable<UsuarioModel> findAll();
    public UsuarioModel findById(Integer id);
    public UsuarioModel add (UsuarioModel model);
    public UsuarioModel update(UsuarioModel model);
    public boolean delete (Integer id);
}
