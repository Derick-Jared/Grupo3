package Catalogo.Catalogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import Catalogo.Catalogo.model.CatalogoModel;
import Catalogo.Catalogo.repository.ICatalogoRepository;

@CacheConfig(cacheNames = {"catalogoCache"})
@Service
public class CatalogoService implements ICatalogoService{

    @Autowired
    ICatalogoRepository repository;

    @Override
    public List<CatalogoModel> getAllTablas() {
        return repository.findAllTablas();
    }

    @Override
    public List<CatalogoModel> getItemsByTabla(int tabla) {
        return repository.findItemsByTabla(tabla);
    }

    @Override
    public CatalogoModel getByDescripcionCorta(String desc) {
        return repository.findByDescripcionCorta(desc);
    }

    @Override
    public CatalogoModel addItem(CatalogoModel model) {
        if(model.getTabla() != 0){
            CatalogoModel newModel = repository.findTablaExist(model.getTabla());
            if(newModel == null){
                model.setId(0);
                return model;
            }
        }
        CatalogoModel searchModel = repository.findByDescripcionCorta(model.getDescripcion_corta());
        if(searchModel != null && searchModel.getId() != model.getId()){
            searchModel.setId(0);
            return searchModel;
        }
        
        Integer maxTabla = repository.findMaxTabla();
        Integer maxItemByTabla = repository.findMaxItemByTabla(model.getTabla());
        int itemValue = model.getTabla() == 0 
            ? (maxTabla != null ? maxTabla + 1 : 1)
            : (maxItemByTabla != null ? maxItemByTabla + 1 : 1); 
        model.setItem(itemValue);
        return repository.save(model);
    }

    @Override
    public CatalogoModel update(CatalogoModel model) {
        CatalogoModel newModel = (CatalogoModel) repository.findById(model.getId()).get();
        if(newModel == null){
            model.setId(0);
            return model;
        }
        CatalogoModel searchModel = (CatalogoModel) repository.findByDescripcionCorta(model.getDescripcion_corta());
        if(searchModel != null && searchModel.getId() != model.getId()){
            searchModel.setId(0);
            return searchModel;
        }
        newModel.setDescripcion_corta(model.getDescripcion_corta());
        newModel.setDescripcion_larga(model.getDescripcion_larga());
        newModel.setActualizado_en(model.getActualizado_en());
        newModel.setActualizado_por(model.getActualizado_por());
        return repository.save(newModel);
    }

    // @Cacheable(cacheNames = {"catalogoCache"}, key = "'allCatalogo'" )
    @Override
    public List<CatalogoModel> getAllCatalogo() {
        return (List<CatalogoModel>) repository.findAll();
    }

    @Override
    public CatalogoModel getItemById(int id) {
        return (CatalogoModel) repository.findById(id).get();
    }
    
}
