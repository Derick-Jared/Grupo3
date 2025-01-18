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

import TDA2024.Recepcion.models.RecepcionModel;
import TDA2024.Recepcion.routes.RecepcionRoutes;
import TDA2024.Recepcion.services.interfaces.IRecepcionService;

@RestController
@RequestMapping(RecepcionRoutes.BASE)
public class RecepcionController {

    @Autowired
    IRecepcionService recepcionService;

    @GetMapping(RecepcionRoutes.GET_ALL)
	public List<RecepcionModel> listar() {
		return (List<RecepcionModel>) recepcionService.findAll();
	}

    @GetMapping(RecepcionRoutes.GET_BY_ID)
    public RecepcionModel getById(@PathVariable Integer id) {
        return recepcionService.findById(id);
    }

    @PostMapping(RecepcionRoutes.CREATE)
    public RecepcionModel create(@RequestBody RecepcionModel model) {
        return recepcionService.add(model);
    }

    @PutMapping(RecepcionRoutes.UPDATE)
    public RecepcionModel update(@RequestBody RecepcionModel model) {
        return recepcionService.update(model);
    }

    @DeleteMapping(RecepcionRoutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = recepcionService.delete(id);
        if (deleted) {
            return "recepcion eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el recepcion.";
        }
    }



}
