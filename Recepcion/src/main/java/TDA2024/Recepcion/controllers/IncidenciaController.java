package TDA2024.Recepcion.controllers;

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

import TDA2024.Recepcion.models.IncidenciaModel;
import TDA2024.Recepcion.services.IIncidenciaService;

import TDA2024.Recepcion.routes.routes;

@RestController
@RequestMapping(routes.BASE)
public class IncidenciaController {

    @Autowired
    IIncidenciaService incidenciaService;

    @GetMapping(routes.GET_ALL)
	public List<IncidenciaModel> listar() {
		return (List<IncidenciaModel>) incidenciaService.findAll();
	}

    @GetMapping(routes.GET_BY_ID)
    public IncidenciaModel getById(@PathVariable Integer id) {
        return incidenciaService.findById(id);
    }

    @PostMapping(routes.CREATE)
    public IncidenciaModel create(@RequestBody IncidenciaModel model) {
        return incidenciaService.add(model);
    }

    @PutMapping(routes.UPDATE)
    public IncidenciaModel update(@RequestBody IncidenciaModel model) {
        return incidenciaService.update(model);
    }

    @DeleteMapping(routes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = incidenciaService.delete(id);
        if (deleted) {
            return "incidencia eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el incidencia.";
        }
    }


}
