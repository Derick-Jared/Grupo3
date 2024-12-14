package Catalogo.Catalogo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/Listar")
    public ResponseEntity<List<CatalogoModel>> getAll(){
        logger.info("Solicitando listado de tablas");
        List<CatalogoModel> items = service.getAllCatalogo();
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_TABLA)
    public ResponseEntity<List<CatalogoModel>> getAllTablas(){
        logger.info("Solicitando listado de tablas");
        List<CatalogoModel> items = service.getTablas();
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_ITEM)
    public ResponseEntity<List<CatalogoModel>> getItemsByTabla(@PathVariable int tabla){
        logger.info("Solicitando items de tabla {}",tabla);
        List<CatalogoModel> items = service.getItems(tabla);
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    
    @PostMapping(UrlConstant.CATALOGO_ADD_ITEM) 
    public ResponseEntity<CatalogoModel> CreateItems(@RequestBody CatalogoModel item){
        logger.info("Agregando item {}",item);
        CatalogoModel items = service.addItem(item);
        logger.debug("Item agregado");
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_DESC)
    public ResponseEntity<CatalogoModel> getItemDesc(@PathVariable String desc){
        logger.info("Solicitando descripcion de item {}",desc);
        CatalogoModel items = service.getByDescripcionCorta(desc);
        logger.debug("Número de items encontrados: {}", items);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping(UrlConstant.CATALOGO_UPDATE_ITEM)
    public ResponseEntity<CatalogoModel> updateItem(@RequestBody CatalogoModel item){
        logger.info("Solicitando items de tabla {}",item);
        CatalogoModel items = service.update(item);
        logger.debug("Item actualizado: {}", items);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}
