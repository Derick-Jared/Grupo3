package Catalogo.Catalogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Catalogo.Catalogo.model.CatalogoModel;
import Catalogo.Catalogo.repository.ICatalogoRepository;

@Service
public class CatalogoService implements ICatalogoService{

    @Autowired
    ICatalogoRepository repository;

    @Override
    public List<CatalogoModel> getTablas() {
        return repository.findAllTablas();
    }

    @Override
    public List<CatalogoModel> getItems(String tabla) {
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
    public CatalogoModel addItem(CatalogoModel model, String tabla) {
        model.setTabla(tabla);
        return repository.save(model);
    }

    @Override
    public CatalogoModel update(CatalogoModel model) {
        return repository.save(model);
    }
    
}
