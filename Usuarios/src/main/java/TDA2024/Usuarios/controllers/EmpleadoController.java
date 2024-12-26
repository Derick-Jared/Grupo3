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
import TDA2024.Usuarios.services.interfaces.IEmpleadoService;

@RestController
@RequestMapping(EmpleadoRoutes.BASE)
public class EmpleadoController {
    @Autowired
    IEmpleadoService empleadoService;

    @GetMapping(EmpleadoRoutes.GET_ALL)
	public List<EmpleadoModel> listar() {
		return (List<EmpleadoModel>) empleadoService.findAll();
	}
    @GetMapping(EmpleadoRoutes.GET_BY_ID)
    public EmpleadoModel getById(@PathVariable Integer id) {
        return empleadoService.findById(id);
    }

    @PostMapping(EmpleadoRoutes.CREATE)
    public EmpleadoModel create(@RequestBody EmpleadoModel model) {
        return empleadoService.add(model);
    }

    @PutMapping(EmpleadoRoutes.UPDATE)
    public EmpleadoModel update(@RequestBody EmpleadoModel model) {
        return empleadoService.update(model);
    }

    @DeleteMapping(EmpleadoRoutes.DELETE)
    public String delete(@PathVariable int id) {
        boolean deleted = empleadoService.delete(id);
        if (deleted) {
            return "empleado eliminado exitosamente.";
        } else {
            return "No se pudo eliminar el empleado.";
        }
    }
}
