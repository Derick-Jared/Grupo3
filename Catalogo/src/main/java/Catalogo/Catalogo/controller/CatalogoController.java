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
import jakarta.validation.Valid;

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

    @PostMapping(UrlConstant.CATALOGO_ADD_ITEM) 
    public ResponseEntity<?> CreateItems(@Valid @RequestBody CatalogoModel model){
        CatalogoModel newModel = service.addItem(model);
        if(newModel.getId() == 0){
            logger.error("Item no encontrado o repetido: {}", model.getId());
            return new ResponseEntity<>("Item no encontrado o repetido ",HttpStatus.CONFLICT);
        }
        logger.debug("Item agregado: {}",newModel.getId());
        return new ResponseEntity<>(newModel, HttpStatus.OK);
    }

    @PutMapping(UrlConstant.CATALOGO_UPDATE_ITEM)
    public ResponseEntity<?> updateItem(@Valid @RequestBody CatalogoModel model){
        CatalogoModel newModel = service.update(model);
        if(newModel.getId() == 0){
            logger.error("Item no encontrado o repetido: {}", model.getId());
            return new ResponseEntity<>("Item no encontrado o repetido ",HttpStatus.CONFLICT);
        }
        logger.error("Item actualizado: {}", model.getId());
        return new ResponseEntity<>(newModel,HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_ALL_TABLA)
    public ResponseEntity<List<CatalogoModel>> getAllTablas(){
        logger.info("Solicitando listado de tablas");
        List<CatalogoModel> items = service.getAllTablas();
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_ITEM_BY_TABLA)
    public ResponseEntity<List<CatalogoModel>> getItemsByTabla(@PathVariable int tabla){
        logger.info("Solicitando items de tabla {}",tabla);
        List<CatalogoModel> items = service.getItemsByTabla(tabla);
        logger.debug("Número de items encontrados: {}", items.size());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping(UrlConstant.CATALOGO_GET_DESC)
    public ResponseEntity<CatalogoModel> getItemDesc(@PathVariable String desc){
        logger.info("Solicitando descripcion de item {}",desc);
        CatalogoModel items = service.getByDescripcionCorta(desc);
        logger.debug("Número de items encontrados: {}", items);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}