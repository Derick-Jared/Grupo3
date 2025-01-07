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
import envios.envios.model.DetalleEnvioModel;
import envios.envios.service.DetalleEnvioService;

@RestController
@RequestMapping(UrlConstant.DETALLE_BASE)
public class DetalleEnvioController {
    @Autowired
    private DetalleEnvioService service;
    @GetMapping(UrlConstant.DETALLE_GET_ALL)
    public List<DetalleEnvioModel> getAllDetalle(){
        return service.getAll();
    }

    @GetMapping(UrlConstant.DETALLE_GET_HAB)
    public List<DetalleEnvioModel> getAllHabilitadosEnvios(){
        return service.getAllHabilitado();
    }

    @GetMapping(UrlConstant.DETALLE_GET_BY_ID)
    public DetalleEnvioModel getDetalleById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping(UrlConstant.DETALLE_ADD)
    public DetalleEnvioModel creareDetalle(@RequestBody DetalleEnvioModel model){
        return service.create(model);
    }

    @PutMapping(UrlConstant.DETALLE_UPDATE)
    public DetalleEnvioModel updateDetalle(@RequestBody DetalleEnvioModel model){
        return service.update(model);
    }

    @PutMapping(UrlConstant.DETALLE_UPDATE_ESTADO)
    public DetalleEnvioModel updateEstadoDetalle(@RequestBody DetalleEnvioModel model){
        return service.updateEstado(model);
    }
}
