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
import Catalogo.Catalogo.exception.response.ErrorResponse;
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
    
    @PostMapping(UrlConstant.CATALOGO_ADD_ITEM) 
    public ResponseEntity<?> CreateItems(@Valid @RequestBody CatalogoModel item){
        ErrorResponse error;
        CatalogoModel newModel = service.getTabla(item.getTabla());
        if(newModel == null && item.getTabla() != 0){
            logger.warn("No se encontro a la tabla {}",item.getTabla());
            error = new ErrorResponse(
            "No se encontro a la tabla: " + item.getDescripcion_corta(), 
            HttpStatus.NOT_FOUND.value(), 
            "");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        newModel = service.getByDescripcionCorta(item.getDescripcion_corta());
        if(newModel != null){
            logger.warn("Ya existe un elemento con esa descripcion corta: {}", item.getDescripcion_corta());
            error = new ErrorResponse(
            "Ya existe un elemento con esa descripcion corta: " + item.getDescripcion_corta(), 
            HttpStatus.EXPECTATION_FAILED.value(), 
            "");
            return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
        }

        int newItem = item.getItem() == 0 ? service.getMaxTabla() + 1 : service.getMaxItembyTabla(item.getTabla()) + 1;
        item.setItem(newItem);
        logger.info("Agregando item {}",item);
        CatalogoModel items = service.addItem(item);
        logger.debug("Item agregado");
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping(UrlConstant.CATALOGO_UPDATE_ITEM)
    public ResponseEntity<?> updateItem(@Valid @RequestBody CatalogoModel item){
        ErrorResponse error;
        CatalogoModel newModel = service.getTabla(item.getTabla());
        if(newModel == null && item.getTabla() != 0){
            logger.warn("No se encontro a la tabla {}",item.getTabla());
            error = new ErrorResponse(
            "No se encontro a la tabla: " + item.getDescripcion_corta(), 
            HttpStatus.NOT_FOUND.value(), 
            "");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        newModel = service.getByDescripcionCorta(item.getDescripcion_corta());
        if(newModel != null && newModel.getId() != item.getId()){
            logger.warn("Ya existe un elemento con esa descripcion corta: {}", item.getDescripcion_corta());
            error = new ErrorResponse(
            "Ya existe un elemento con esa descripcion corta: " + item.getDescripcion_corta(), 
            HttpStatus.EXPECTATION_FAILED.value(), 
            "");
            return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
        }

        int success = service.update(item);
        if(success > 0){
            newModel = service.getItemById(item.getId());
            logger.info("Item actualizado: {}", newModel);
            return new ResponseEntity<>(newModel, HttpStatus.OK);
        }
        else{
            logger.error("Ocurrio un problema, No se pudo actualizar el item de id: {}",item.getId());
            error = new ErrorResponse(
            "Ocurrio un problema, No se pudo actualizar el item de id: {}" + item.getId(), 
            HttpStatus.EXPECTATION_FAILED.value(), 
            "");
            return new ResponseEntity<>(error, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping(UrlConstant.CATALOGO_GET_DESC)
    public ResponseEntity<CatalogoModel> getItemDesc(@PathVariable String desc){
        logger.info("Solicitando descripcion de item {}",desc);
        CatalogoModel items = service.getByDescripcionCorta(desc);
        logger.debug("Número de items encontrados: {}", items);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}