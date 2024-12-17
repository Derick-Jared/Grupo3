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
    public CatalogoModel addTabla(CatalogoModel model) {
        return repository.save(model);
    }

    @Override
    public CatalogoModel addItem(CatalogoModel model) {
        return repository.save(model);
    }

    @Override
    public int update(CatalogoModel model) {
        return repository.updateCatalogoItem(model.getId(),model.getDescripcion_corta(),model.getDescripcion_larga(),model.getActualizado_en(),model.getActualizado_por());
    }

    // @Cacheable(cacheNames = {"catalogoCache"}, key = "'allCatalogo'" )
    @Override
    public List<CatalogoModel> getAllCatalogo() {
        return (List<CatalogoModel>) repository.findAll();
    }

    @Override
    public CatalogoModel getTabla(int tabla) {
        return repository.findTablaExist(tabla);
    }

    @Override
    public int getMaxTabla() {
        return repository.findMaxTabla();
    }

    @Override
    public int getMaxItembyTabla(int tabla) {
        return repository.findMaxItemByTabla(tabla);
    }

    @Override
    public CatalogoModel getItemById(int id) {
        return (CatalogoModel) repository.findById(id).get();
    }
    
}
