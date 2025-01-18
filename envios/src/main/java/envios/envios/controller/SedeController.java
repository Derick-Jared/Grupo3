package envios.envios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import envios.envios.constant.UrlConstant;
import envios.envios.model.SedeModel;
import envios.envios.service.SedeService;

@RestController
@RequestMapping(UrlConstant.SEDE_BASE)
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {
    @Autowired
    private SedeService service;
    @GetMapping(UrlConstant.SEDE_GET_ALL)
    public List<SedeModel> getAllSede(){
        return service.getAll();
    }

    @GetMapping(UrlConstant.SEDE_GET_HAB)
    public List<SedeModel> getAllHabilitadosEnvios(){
        return service.getAllHabilitado();
    }

    @GetMapping(UrlConstant.SEDE_GET_BY_ID)
    public SedeModel getSedeById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping(UrlConstant.SEDE_ADD)
    public SedeModel creareSede(@RequestBody SedeModel model){
        return service.create(model);
    }

    @PutMapping(UrlConstant.SEDE_UPDATE)
    public SedeModel updateSede(@RequestBody SedeModel model){
        return service.update(model);
    }

    @PutMapping(UrlConstant.SEDE_UPDATE_ESTADO)
    public SedeModel updateEstadoSede(@RequestBody SedeModel model){
        return service.updateEstado(model);
    }
}
