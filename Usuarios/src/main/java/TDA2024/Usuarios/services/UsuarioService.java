package TDA2024.Usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import TDA2024.Usuarios.models.UsuarioModel;
import TDA2024.Usuarios.repositories.IUsuarioRepository;
import TDA2024.Usuarios.services.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    IUsuarioRepository usuarioRepository;
    @Override
    public Iterable<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel findById(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public UsuarioModel add(UsuarioModel model) {
        return usuarioRepository.save(model);
    }

    @Override
    public UsuarioModel update(UsuarioModel model) {
        return usuarioRepository.save(model);
    }

    @Override
    public boolean delete(Integer id) {
        if(usuarioRepository.findById(id).get()!=null){
            usuarioRepository.deleteById(id);
            return true; 
        }else{
            return false;
        }
    }

    @Override
    public UsuarioModel findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public boolean validaLogin(String email, String password) {
        UsuarioModel usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            if(password.equals(usuario.getPassword())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer findLastId() {
        UsuarioModel ultimoUsuario = usuarioRepository.findFirstByOrderByIdDesc();
        return (ultimoUsuario.getId() != null) ? ultimoUsuario.getId() : 0;
    }

    @Override
    public Iterable<UsuarioModel> findAllEstado(String estado) {
        return usuarioRepository.findAllByEstado(estado);
    }

    
    
    
}
