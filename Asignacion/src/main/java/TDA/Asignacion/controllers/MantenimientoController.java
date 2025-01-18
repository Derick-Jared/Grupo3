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

import TDA.Asignacion.models.MantenimientoModel;
import TDA.Asignacion.routes.Mantenimientoroutes;
import TDA.Asignacion.services.MantenimientoService;

@RestController
@RequestMapping(Mantenimientoroutes.BASE)
public class MantenimientoController {
    @Autowired
    MantenimientoService Service;

    @GetMapping(Mantenimientoroutes.GET_ALL)
	public List<MantenimientoModel> listar() {
		return (List<MantenimientoModel>) Service.findAll();
	}
    @GetMapping(Mantenimientoroutes.GET_BY_ID)
    public MantenimientoModel getById(@PathVariable Integer id) {
        return Service.findById(id);
    }

    @PostMapping(Mantenimientoroutes.CREATE)
    public MantenimientoModel create(@RequestBody MantenimientoModel model) {
        return Service.add(model);
    }

    @PutMapping(Mantenimientoroutes.UPDATE)
    public MantenimientoModel update(@RequestBody MantenimientoModel model) {
        return Service.update(model);
    }

    @DeleteMapping(Mantenimientoroutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = Service.delete(id);
        if (deleted) {
            return "Mantenimiento eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el Mantenimiento.";
        }
    }
}
