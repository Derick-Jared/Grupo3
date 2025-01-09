package TDA2024.Usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import TDA2024.Usuarios.models.*;
import TDA2024.Usuarios.routes.*;
import TDA2024.Usuarios.services.interfaces.IUsuarioService;

@RestController
@RequestMapping(UsuarioRoutes.BASE)
@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {
    @Autowired
    IUsuarioService usuarioService;
    
    @GetMapping(UsuarioRoutes.GET_ALL)
	public List<UsuarioModel> listar() {
		return (List<UsuarioModel>) usuarioService.findAll();
	}
     @GetMapping(UsuarioRoutes.GET_BY_ID)
    public UsuarioModel getById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @PostMapping(UsuarioRoutes.CREATE)
    public UsuarioModel create(@RequestBody UsuarioModel model) {
        return usuarioService.add(model);
    }

    @PutMapping(UsuarioRoutes.UPDATE)
    public UsuarioModel update(@RequestBody UsuarioModel model) {
        return usuarioService.update(model);
    }

    @DeleteMapping(UsuarioRoutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = usuarioService.delete(id);
        if (deleted) {
            return "usuario eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el usuario.";
        }
    }
}
