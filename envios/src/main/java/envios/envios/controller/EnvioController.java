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
import envios.envios.model.EnvioModel;
import envios.envios.service.EnvioService;

@RestController
@RequestMapping(UrlConstant.ENVIO_BASE)
@CrossOrigin(origins = "http://localhost:4200")
public class EnvioController {
    @Autowired
    private EnvioService service;
    @GetMapping(UrlConstant.ENVIO_GET_ALL)
    public List<EnvioModel> getAllEnvios(){
        return service.getAll();
    }

    @GetMapping(UrlConstant.ENVIO_GET_HAB)
    public List<EnvioModel> getAllHabilitadosEnvios(){
        return service.getAllHabilitado();
    }

    @GetMapping(UrlConstant.ENVIO_GET_BY_ID_USER)
    public List<EnvioModel> getEnvioByUserId(@PathVariable int id){
        return service.getAllByUser(id);
    }

    @GetMapping(UrlConstant.ENVIO_GET_BY_ID)
    public EnvioModel getEnvioById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping(UrlConstant.ENVIO_ADD)
    public EnvioModel creareEnvio(@RequestBody EnvioModel model){
        return service.create(model);
    }

    @PutMapping(UrlConstant.ENVIO_UPDATE)
    public EnvioModel updateEnvio(@RequestBody EnvioModel model){
        return service.update(model);
    }

    @PutMapping(UrlConstant.ENVIO_UPDATE_ESTADO)
    public EnvioModel updateEstadoEnvio(@RequestBody EnvioModel model){
        return service.updateEstado(model);
    }
}
