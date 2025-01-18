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

import TDA.Asignacion.models.VehiculoModel;
import TDA.Asignacion.routes.VehiculoRoutes;
import TDA.Asignacion.services.VehiculoService;

@RestController
@RequestMapping(VehiculoRoutes.BASE)
public class VehiculoController {
    @Autowired
    VehiculoService Service;

    @GetMapping(VehiculoRoutes.GET_ALL)
	public List<VehiculoModel> listar() {
		return (List<VehiculoModel>) Service.findAll();
	}
    @GetMapping(VehiculoRoutes.GET_BY_ID)
    public VehiculoModel getById(@PathVariable Integer id) {
        return Service.findById(id);
    }

    @PostMapping(VehiculoRoutes.CREATE)
    public VehiculoModel create(@RequestBody VehiculoModel model) {
        return Service.add(model);
    }

    @PutMapping(VehiculoRoutes.UPDATE)
    public VehiculoModel update(@RequestBody VehiculoModel model) {
        return Service.update(model);
    }

    @DeleteMapping(VehiculoRoutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = Service.delete(id);
        if (deleted) {
            return "Vehiculo eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el Vehiculo.";
        }
    }




}
