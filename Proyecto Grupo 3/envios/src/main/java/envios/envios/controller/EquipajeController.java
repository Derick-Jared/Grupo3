package envios.envios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import envios.envios.constant.UrlConstant;
import envios.envios.model.EquipajeModel;
import envios.envios.service.EquipajeService;

@RestController
@RequestMapping(UrlConstant.EQUIPAJE_BASE)
public class EquipajeController {
    @Autowired
    private EquipajeService service;

    @GetMapping(UrlConstant.EQUIPAJE_GET_ALL)
    public List<EquipajeModel> getAllEquipaje(){
        return service.getAll();
    }

    @GetMapping(UrlConstant.EQUIPAJE_GET_HAB)
    public List<EquipajeModel> getAllHabilitadosEquipaje(){
        return service.getAllHabilitado();
    }

    @GetMapping(UrlConstant.EQUIPAJE_GET_BY_DETALLE_ID)
    public List<EquipajeModel> getEquipajeByDetalleId(@PathVariable int id){
        return service.getAllByDetalleId(id);
    }

    @GetMapping(UrlConstant.EQUIPAJE_GET_BY_ID)
    public EquipajeModel getEquipajeById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping(UrlConstant.EQUIPAJE_ADD)
    public EquipajeModel creareEquipaje(@RequestBody EquipajeModel model){
        return service.create(model);
    }

    @PutMapping(UrlConstant.EQUIPAJE_UPDATE)
    public EquipajeModel updateEquipaje(@RequestBody EquipajeModel model){
        return service.update(model);
    }

    @PutMapping(UrlConstant.EQUIPAJE_UPDATE_ESTADO)
    public EquipajeModel updateEstadoEquipaje(@RequestBody EquipajeModel model){
        return service.updateEstado(model);
    }
}
