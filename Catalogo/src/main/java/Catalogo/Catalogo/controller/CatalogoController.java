package Catalogo.Catalogo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Catalogo.Catalogo.constant.UrlConstant;
import Catalogo.Catalogo.model.CatalogoModel;
import Catalogo.Catalogo.services.CatalogoService;

@RestController
@RequestMapping(UrlConstant.CATALOGO_BASE)
public class CatalogoController {
    private static final Logger logger = LoggerFactory.getLogger(CatalogoController.class); 

    @Autowired
    CatalogoService service;

    @GetMapping(UrlConstant.CATALOGO_GET_TABLA)
    public ResponseEntity<List<CatalogoModel>> getAllTablas(){
        logger.info("Solicitando listado de tablas");
        List<CatalogoModel> items = service.getTablas();
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_TABLA)
    public ResponseEntity<List<CatalogoModel>> getItemsByTabla(@PathVariable String tabla){
        logger.info("Solicitando items de tabla {}",tabla);
        List<CatalogoModel> items = service.getItems(tabla);
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
}
