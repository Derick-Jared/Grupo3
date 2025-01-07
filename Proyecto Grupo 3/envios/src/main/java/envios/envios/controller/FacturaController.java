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
import envios.envios.model.FacturaModel;
import envios.envios.service.FacturaService;

@RestController
@RequestMapping(UrlConstant.FACTURA_BASE)
public class FacturaController {
    @Autowired
    private FacturaService service;

    @GetMapping(UrlConstant.FACTURA_GET_ALL)
    public List<FacturaModel> getAllEquipaje(){
        return service.getAll();
    }

    @GetMapping(UrlConstant.FACTURA_GET_HAB)
    public List<FacturaModel> getAllHabilitadosEquipaje(){
        return service.getAllHabilitado();
    }

    @GetMapping(UrlConstant.FACTURA_GET_BY_ID)
    public FacturaModel getEquipajeById(@PathVariable int id){
        return service.getById(id);
    }

    @GetMapping(UrlConstant.FACTURA_GET_BY_DETALLE_ID)
    public FacturaModel getFacturaByIdDetalle(@PathVariable int id){
        return service.getByIdDetalleEnvio(id);
    }

    @PostMapping(UrlConstant.FACTURA_ADD)
    public FacturaModel creareEquipaje(@RequestBody FacturaModel model){
        return service.create(model);
    }

    @PutMapping(UrlConstant.FACTURA_UPDATE)
    public FacturaModel updateEquipaje(@RequestBody FacturaModel model){
        return service.update(model);
    }

    @PutMapping(UrlConstant.FACTURA_UPDATE_ESTADO)
    public FacturaModel updateEstadoEquipaje(@RequestBody FacturaModel model){
        return service.updateEstado(model);
    }
}
