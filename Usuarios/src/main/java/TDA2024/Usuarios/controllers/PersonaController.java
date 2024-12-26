package TDA2024.Usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import TDA2024.Usuarios.services.interfaces.IPersonaService;

@RestController
@RequestMapping(PersonaRoutes.BASE)
public class PersonaController {
    @Autowired
    IPersonaService personaService;

     @GetMapping(PersonaRoutes.GET_ALL)
	public List<PersonaModel> listar() {
		return (List<PersonaModel>) personaService.findAll();
	}
     @GetMapping(PersonaRoutes.GET_BY_ID)
    public PersonaModel getById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @PostMapping(PersonaRoutes.CREATE)
    public PersonaModel create(@RequestBody PersonaModel model) {
        return personaService.add(model);
    }

    @PutMapping(PersonaRoutes.UPDATE)
    public PersonaModel update(@RequestBody PersonaModel model) {
        return personaService.update(model);
    }

    @DeleteMapping(PersonaRoutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = personaService.delete(id);
        if (deleted) {
            return "incidencia eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el incidencia.";
        }
    }
}
