package TDA2024.Usuarios.services.interfaces;

import TDA2024.Usuarios.models.UsuarioModel;

public interface IUsuarioService {
    public Iterable<UsuarioModel> findAll();
    public UsuarioModel findById(Integer id);
    public UsuarioModel add (UsuarioModel model);
    public UsuarioModel update(UsuarioModel model);
    public boolean delete (Integer id);
    public UsuarioModel findByEmail (String email);
    public boolean validaLogin ( String email, String password );
    public Integer findLastId();
    public Iterable<UsuarioModel> findAllEstado(String estado);
}
