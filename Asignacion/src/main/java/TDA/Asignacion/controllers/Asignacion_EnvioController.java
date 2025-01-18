package TDA.Asignacion.controllers;

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

import TDA.Asignacion.models.Asignacion_EnvioModel;
import TDA.Asignacion.routes.Asignacion_EnvioRoutes;
import TDA.Asignacion.services.AsignacionService;


@RestController
@RequestMapping(Asignacion_EnvioRoutes.BASE)
public class Asignacion_EnvioController {
    @Autowired
    AsignacionService Service;

    @GetMapping(Asignacion_EnvioRoutes.GET_ALL)
	public List<Asignacion_EnvioModel> listar() {
		return (List<Asignacion_EnvioModel>) Service.findAll();
	}
    @GetMapping(Asignacion_EnvioRoutes.GET_BY_ID)
    public Asignacion_EnvioModel getById(@PathVariable Integer id) {
        return Service.findById(id);
    }

    @PostMapping(Asignacion_EnvioRoutes.CREATE)
    public Asignacion_EnvioModel create(@RequestBody Asignacion_EnvioModel model) {
        return Service.add(model);
    }

    @PutMapping(Asignacion_EnvioRoutes.UPDATE)
    public Asignacion_EnvioModel update(@RequestBody Asignacion_EnvioModel model) {
        return Service.update(model);
    }

    @DeleteMapping(Asignacion_EnvioRoutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = Service.delete(id);
        if (deleted) {
            return "Asignacion_envio eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el Asignacion_envio.";
        }
    }
}
